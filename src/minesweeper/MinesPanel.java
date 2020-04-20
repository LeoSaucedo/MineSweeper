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
        minesList[i][j].addMouseListener(this);
        // Sets button identifier to its number in order
        minesList[i][j].setActionCommand(Integer.toString(i * diff.HEIGHT + j));
        add(minesList[i][j]);
      }
    }

    // Add mines
    addMines();
  }

  // Resets the tiles and starts a new game with new mines
  public void newGame() {
    for(Tile[] i : minesList)
      for(Tile j : i)
        j.reset();

    addMines();
  }

  // Add mines to the game
  private void addMines() {
    for (int i = 0; i < diff.MINES; i++) {
      do {
        coord[0][i] = rand.nextInt(diff.WIDTH);
        coord[1][i] = rand.nextInt(diff.HEIGHT);
      } while (minesList[coord[0][i]][coord[1][i]].isMine());
      minesList[coord[0][i]][coord[1][i]].setMineState(true);

      // Add danger to nearby tiles
      // starts at tile before current one while staying in boundaries of the game
      for(int j = (coord[0][i] == 0)? 0 : coord[0][i]-1; j <= coord[0][i]+1 && j < diff.WIDTH; j++)
        for(int k = (coord[1][i] == 0)? 0 : coord[1][i]-1; k <= coord[1][i]+1 && k < diff.HEIGHT; k++)
          minesList[j][k].increaseDanger();
    }
  }

  // Reveals tile
  private void reveal(int x, int y) {
    // Checks if tile was already revealed for recursive purposes
    if(!minesList[x][y].revealed()) {
      int mines = minesList[x][y].reveal();
      // If the tile had no mines nearby then those nearby tiles are revealed
      if(mines == 0) {
        for(int i = (x == 0)? 0 : x-1; i <= x+1 && i < diff.WIDTH; i++)
          for(int j = (y == 0)? 0 : y-1; j <= y+1 && j < diff.HEIGHT; j++)
            reveal(i, j);
      }
      // If the tile was a mine then all mines are revealed and the player loses
      else if(mines == -1) {
        // Shows Mines
        for(int i = 0; i < diff.MINES; i++)
          minesList[coord[0][i]][coord[1][i]].reveal();
        // Disables all tiles
        for(Tile[] i : minesList)
          for(Tile j : i)
            j.setEnabled(false);
      }
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    int val = Integer.parseInt(e.getActionCommand());
    reveal(val/diff.HEIGHT, val%diff.HEIGHT);
  }

  @Override
  public void mouseClicked(MouseEvent e) {}

  @Override
  public void mousePressed(MouseEvent e) {}

  @Override
  public void mouseReleased(MouseEvent e) {}

  @Override
  public void mouseEntered(MouseEvent e) {}

  @Override
  public void mouseExited(MouseEvent e) {}
}