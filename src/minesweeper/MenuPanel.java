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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class MenuPanel extends JPanel {
  Font segment;
  static final Icon HAPPY = new ImageIcon(
      new ImageIcon("res/face_happy.png").getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_FAST));
  static final Icon DEAD = new ImageIcon(
      new ImageIcon("res/face_dead.png").getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_FAST));
  int seconds; // Number of seconds since the game has started.

  /**
   * Creates a new MenuPanel.
   * 
   * @param mines The number of mines in the field.
   */
  public MenuPanel(int mines) {
    super();
    seconds = 0;
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
    JLabel numMines = new JLabel(getFormattedNumber(mines));
    numMines.setOpaque(true);
    numMines.setBackground(Color.BLACK);
    numMines.setForeground(Color.RED);
    numMines.setFont(segment);

    // Label representing the alotted time.
    JLabel time = new JLabel(getFormattedNumber(seconds));
    time.setOpaque(true);
    time.setBackground(Color.BLACK);
    time.setForeground(Color.RED);
    time.setFont(segment);
    JPanel btnPanel = new JPanel();
    btnPanel.add(menuButton);

    // Handling the timer value changes.
    ActionListener actionListener = new ActionListener() {
      public void actionPerformed(ActionEvent actionEvent) {
        time.setText(getFormattedNumber(++seconds));
      }
    };

    Timer timer = new Timer(1000, actionListener);
    timer.start();

    // Adding all the elements to the panel.
    add(numMines, BorderLayout.WEST);
    add(btnPanel, BorderLayout.CENTER);
    add(time, BorderLayout.EAST);
  }

  /**
   * Retrieves a formatted version of the number for the displays.
   * 
   * @param num The number to format.
   * @return The formatted string.
   */
  private String getFormattedNumber(int num) {
    String out = "";
    if (num < 10) {
      out += "00";
    } else if (num < 100) {
      out += "0";
    }
    out += num;
    return out;
  }
}