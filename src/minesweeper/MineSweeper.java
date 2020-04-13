package minesweeper;

import javax.swing.JFrame;

// Sets up the JFrame
public class MineSweeper extends JFrame{

  public MineSweeper() {
    setSize(900, 480);
    setTitle("MineSweeper");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    //setResizable(false);

    // Sets the menu bar
    GameBar gb = new GameBar();
    setJMenuBar(gb);
    
    // Adds the game to the JFrame
    MenuPanel menu = new MenuPanel();
    MinesPanel mines = new MinesPanel(2);
    add(mines);

    setVisible(true);
  }


  public static void main(String[] args) {
    new MineSweeper();
  }
}