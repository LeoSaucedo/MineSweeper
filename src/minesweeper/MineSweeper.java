package minesweeper;

import javax.swing.JFrame;

// Sets up the JFrame
public class MineSweeper extends JFrame{
  private Difficulty diff = Difficulty.EASY;

  public MineSweeper() {
    // Width is width of diff*30, height is height of diff*30 + height of bar
    setSize(diff.WIDTH*60, diff.HEIGHT*60);
    setTitle("MineSweeper");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);

    // Sets the menu bar
    GameBar gb = new GameBar();
    setJMenuBar(gb);
    
    // Adds the game to the JFrame
    MenuPanel menu = new MenuPanel();
    MinesPanel mines = new MinesPanel(diff);
    add(mines);

    setVisible(true);
  }


  public static void main(String[] args) {
    new MineSweeper();
  }
}
