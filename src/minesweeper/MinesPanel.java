package minesweeper;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MinesPanel extends JPanel implements ActionListener, MouseListener {
  private Random rand;
  private final Difficulty diff;
  private Tile[][] minesList;
  private int[][] coord;

  public MinesPanel(Difficulty difficulty) {
    super();
    diff = difficulty;
    rand = new Random();
    // 0 - x, 1 - y
    coord = new int[2][diff.MINES];

    // Create layout of tiles
    setLayout(new GridLayout(diff.HEIGHT, diff.WIDTH));
    minesList = new Tile[diff.WIDTH][diff.HEIGHT];
    for (int i = 0; i < diff.WIDTH; i++) {
      for (int j = 0; j < diff.HEIGHT; j++) {
        minesList[i][j] = new Tile();
        minesList[i][j].addActionListener(this);
        // Sets button identifier to its number in order
        minesList[i][j].setActionCommand(Integer.toString(i * diff.HEIGHT + j));
        add(minesList[i][j]);
      }
    }

    // Add mines
    newGame();
  }

  /**
   * Resets the tiles and starts a new game with new mines.
   */
  public void newGame() {
    for (Tile[] i : minesList)
      for (Tile j : i)
        j.reset();

    for (int i = 0; i < diff.MINES; i++) {
      do {
        coord[0][i] = rand.nextInt(diff.WIDTH);
        coord[1][i] = rand.nextInt(diff.HEIGHT);
      } while (minesList[coord[0][i]][coord[1][i]].isMine());
      minesList[coord[0][i]][coord[1][i]].setMineState(true);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    int val = Integer.parseInt(e.getActionCommand());
    // TODO: Figure out how many mines are next to it.
    if (minesList[val / diff.HEIGHT][val % diff.HEIGHT].reveal(7)) {
      // Shows Mines
      for (int i = 0; i < diff.MINES; i++)
        minesList[coord[0][i]][coord[1][i]].reveal(0);
      // Disables all tiles
      for (Tile[] i : minesList)
        for (Tile j : i)
          j.setEnabled(false);
    }
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    // TODO: Implement right click (flags)
  }

  @Override
  public void mousePressed(MouseEvent e) {
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }
}