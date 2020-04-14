package minesweeper;

import javax.swing.JFrame;
import java.awt.FlowLayout;

// Sets up the JFrame
public class MineSweeper extends JFrame{

  public MineSweeper() {
    setSize(950, 600);
    setTitle("MineSweeper");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    //setResizable(false);
    setLayout(new FlowLayout());


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