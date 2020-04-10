package app;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class App {
  public static void main(String[] args) {
    // Creating frame
    JFrame frame = new JFrame("Minesweeper");

    // Setting up the menu bar
    JMenu gameMenu, helpMenu;
    JMenuBar mb = new JMenuBar();
    gameMenu = new JMenu("Game");
    helpMenu = new JMenu("Options");
    mb.add(gameMenu);
    mb.add(helpMenu);

    // Instantiating menu and mines panels.

    // Creating the game to display.
    frame.setJMenuBar(mb);
    frame.setSize(256, 512);
    // BorderLayout layout = new BorderLayout();
    // frame.setLayout(layout);
    frame.setDefaultCloseOperation(3);
    // frame.add(menuPanel, BorderLayout.NORTH);
    MinesPanel minesPanel = new MinesPanel(0);
    frame.add(minesPanel);
    frame.setVisible(true);
  }
}