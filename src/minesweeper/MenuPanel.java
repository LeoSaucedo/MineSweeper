package minesweeper;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MenuPanel extends JPanel {
  static final Icon HAPPY = new ImageIcon(
      new ImageIcon("res/cell_happy.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_FAST));
  static final Icon DEAD = new ImageIcon(
      new ImageIcon("res/cell_dead.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_FAST));

  public MenuPanel() {
    super();
    BorderLayout layout = new BorderLayout();
    setLayout(layout);

    JButton menuButton = new JButton("THIS\nIsatest");
    menuButton.setSize(30, 30);
    JLabel numMines = new JLabel("000");
    JLabel time = new JLabel("000");

    add(numMines, BorderLayout.WEST);
    add(menuButton, BorderLayout.CENTER);
    add(time, BorderLayout.EAST);
  }
}