package minesweeper;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

public class MenuPanel extends JPanel {
  Font segment;
  static final Icon HAPPY = new ImageIcon(
      new ImageIcon("res/face_happy.png").getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_FAST));
  static final Icon DEAD = new ImageIcon(
      new ImageIcon("res/face_dead.png").getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_FAST));

  public MenuPanel() {
    super();

    // Adding custom font.
    try {
      segment = Font.createFont(Font.TRUETYPE_FONT, new File("res/segment.ttf")).deriveFont(48f);
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/segment.ttf")).deriveFont(48f));
    } catch (FontFormatException | IOException e) {
      System.out.println("This is an error.");
      e.printStackTrace();
    }
    BorderLayout layout = new BorderLayout();
    setLayout(layout);
    JButton menuButton = new JButton(HAPPY);
    menuButton.setPreferredSize(new Dimension(50, 50));

    // Label representing the number of remaining mines.
    JLabel numMines = new JLabel("000");
    numMines.setOpaque(true);
    numMines.setBackground(Color.BLACK);
    numMines.setForeground(Color.RED);
    numMines.setFont(segment);

    // Label representing the alotted time.
    JLabel time = new JLabel("000");
    time.setOpaque(true);
    time.setBackground(Color.BLACK);
    time.setForeground(Color.RED);
    time.setFont(segment);
    JPanel btnPanel = new JPanel();
    btnPanel.add(menuButton);

    // Adding all the elements to the panel.
    add(numMines, BorderLayout.WEST);
    add(btnPanel, BorderLayout.CENTER);
    add(time, BorderLayout.EAST);
    setBackground(new Color(179, 179, 179));
  }
}