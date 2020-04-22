package minesweeper;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JMenu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Sets up the JFrame
public class MineSweeper extends JFrame implements ActionListener {
  // Default difficulty
  private Difficulty diff = Difficulty.MEDIUM;

  // JMenuBar options
  private JMenuItem newBtn;
  private JMenuItem beginnerBtn;
  private JMenuItem intermediateBtn;
  private JMenuItem expertBtn;

  // JPanels for game
  private MenuPanel menu;
  private MinesPanel mines;

  public MineSweeper() {
    BorderLayout layout = new BorderLayout();
    setLayout(layout);
    setSize(diff.WIDTH * 30, diff.HEIGHT * 30 + 60);
    setTitle("MineSweeper");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);

    // Sets the menu bar
    JMenuBar gb = new JMenuBar();
    JMenu gameMenu = new JMenu("Game");
    newBtn = new JMenuItem("New");
    newBtn.addActionListener(this);
    beginnerBtn = new JMenuItem("Beginner");
    beginnerBtn.addActionListener(this);
    intermediateBtn = new JMenuItem("Intermediate");
    intermediateBtn.addActionListener(this);
    expertBtn = new JMenuItem("Expert");
    expertBtn.addActionListener(this);
    gameMenu.add(newBtn);
    gameMenu.add(new JSeparator());
    gameMenu.add(beginnerBtn);
    gameMenu.add(intermediateBtn);
    gameMenu.add(expertBtn);
    gb.add(gameMenu);
    setJMenuBar(gb);

    // Adds the game and menu panel to the JFrame
    menu = new MenuPanel(diff.MINES);
    mines = new MinesPanel(diff);
    menu.setMinesPanel(mines);
    mines.setMenuPanel(menu);

    // Width is width of diff*30, height is height of diff*30 + height of bar
    mines.setPreferredSize(new Dimension(diff.WIDTH * 30, diff.HEIGHT * 30));
    add(menu, BorderLayout.NORTH);
    add(mines, BorderLayout.CENTER);

    setVisible(true);
  }

  public static void main(String[] args) {
    new MineSweeper();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == newBtn) {
      menu.newGame(diff.MINES);
    } else {
      if (e.getSource() == beginnerBtn)
        diff = Difficulty.EASY;
      else if (e.getSource() == intermediateBtn)
        diff = Difficulty.MEDIUM;
      else if (e.getSource() == expertBtn)
        diff = Difficulty.HARD;
      else
        return;
      setSize(diff.WIDTH * 30, diff.HEIGHT * 30 + 60);
      mines.changeDiff(diff);
      menu.newGame(diff.MINES);
      mines.setPreferredSize(new Dimension(diff.WIDTH * 30, diff.HEIGHT * 30));
    }
  }
}
