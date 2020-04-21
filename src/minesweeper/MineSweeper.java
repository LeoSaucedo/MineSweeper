package minesweeper;

import javax.swing.JFrame;
import java.awt.BorderLayout;

// Sets up the JFrame
public class MineSweeper extends JFrame {
  private Difficulty diff = Difficulty.EASY;

  public MineSweeper() {
    BorderLayout layout = new BorderLayout();
    setLayout(layout);
    setSize(diff.WIDTH * 30, diff.HEIGHT * 30);
    setTitle("MineSweeper");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);

    // Sets the menu bar
    GameBar gb = new GameBar();
    setJMenuBar(gb);

    // Adds the game and menu panel to the JFrame
    MenuPanel menu = new MenuPanel(diff.MINES);
    MinesPanel mines = new MinesPanel(diff);
    menu.setMinesPanel(mines);
    mines.setMenuPanel(menu);

    // Width is width of diff*30, height is height of diff*30 + height of bar
    mines.setSize(diff.WIDTH * 30, diff.HEIGHT * 30);
    add(menu, BorderLayout.NORTH);
    add(mines, BorderLayout.CENTER);

    setVisible(true);
  }

  public static void main(String[] args) {
    new MineSweeper();
  }
}
