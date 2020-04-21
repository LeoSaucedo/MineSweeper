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

public class MenuPanel extends JPanel implements ActionListener {

  // Final variables
  private static final Icon HAPPY = new ImageIcon(
      new ImageIcon("res/face_happy.png").getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_FAST));
  private static final Icon DEAD = new ImageIcon(
      new ImageIcon("res/face_dead.png").getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_FAST));
  static final int GAME_OVER = 0;
  static final int GAME_ONGOING = 1;

  // Instance variables
  private Font segment;
  private Timer timer;
  private int totalMines;
  private int minesLeft;
  private int seconds;
  private MinesPanel minesPanel;
  private JButton menuButton;
  private JLabel numMines;
  private JLabel time;

  /**
   * Creates a new MenuPanel.
   * 
   * @param mines The number of mines in the field.
   */
  public MenuPanel(int mines) {
    super();
    seconds = 0;
    totalMines = minesLeft = mines;
    // Adding custom font.
    try {
      segment = Font.createFont(Font.TRUETYPE_FONT, new File("res/segment.ttf")).deriveFont(48f);
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/segment.ttf")).deriveFont(48f));
    } catch (FontFormatException | IOException e) {
      e.printStackTrace();
    }
    BorderLayout layout = new BorderLayout();
    setLayout(layout);
    menuButton = new JButton(HAPPY);
    menuButton.setPreferredSize(new Dimension(50, 50));
    menuButton.addActionListener(this);
    // menuButton.setActionCommand("Test");

    // Label representing the number of remaining mines.
    numMines = new JLabel(getFormattedNumber(minesLeft));
    numMines.setOpaque(true);
    numMines.setBackground(Color.BLACK);
    numMines.setForeground(Color.RED);
    numMines.setFont(segment);

    // Label representing the alotted time.
    time = new JLabel(getFormattedNumber(seconds));
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

    timer = new Timer(1000, actionListener);
    timer.start();

    // Adding all the elements to the panel.
    add(numMines, BorderLayout.WEST);
    add(btnPanel, BorderLayout.CENTER);
    add(time, BorderLayout.EAST);
  }

  /**
   * Stops the currently running timer.
   */
  public void stopTimer() {
    timer.stop();
  }

  /**
   * Sets the minesPanel variable.
   * 
   * @param mp The MinesPanel in the current game.
   */
  public void setMinesPanel(MinesPanel mp) {
    minesPanel = mp;
  }

  /**
   * Reduces the mines left counter by 1.
   * 
   * @return Whether the user has flagged all existing mines.
   */
  public boolean addFlaggedMine() {
    minesLeft--;
    numMines.setText(getFormattedNumber(minesLeft));
    return minesLeft == 0;
  }

  public boolean removeFlaggedMine() {
    minesLeft++;
    numMines.setText(getFormattedNumber(minesLeft));
    return minesLeft == 0;
  }

  /**
   * Set the game status for the face button.
   */
  public void setGameStatus(int status) {
    switch (status) {
      case 0:
        menuButton.setIcon(DEAD);
        break;
      case 1:
        menuButton.setIcon(HAPPY);
    }
  }

  /**
   * Restarts the game state.
   */
  public void newGame() {
    setGameStatus(GAME_ONGOING);
    minesPanel.newGame();
    minesLeft = totalMines;
    seconds = 0;
    time.setText(getFormattedNumber(seconds));
    timer.start();
    numMines.setText(getFormattedNumber(minesLeft));
  }

  /**
   * Retrieves a formatted version of the number for the displays.
   * 
   * @param num The number to format.
   * @return The formatted string.
   */
  private String getFormattedNumber(int num) {
    if (num > 999)
      return "999";
    String out = "";
    if (num < 10) {
      out += "00";
    } else if (num < 100) {
      out += "0";
    }
    out += num;
    return out;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    newGame();
  }
}