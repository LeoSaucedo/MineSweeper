package minesweeper;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Tile extends JButton {
  // Icons available for each Tile
  static final Icon BLANK = new ImageIcon(
      new ImageIcon("res/cell_blank.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_FAST));
  static final Icon MINE = new ImageIcon(
      new ImageIcon("res/cell_mine.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_FAST));
  static final Icon FLAG = new ImageIcon(
      new ImageIcon("res/cell_flag.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_FAST));
  static final Icon ONE = new ImageIcon(
      new ImageIcon("res/cell_1.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_FAST));
  static final Icon TWO = new ImageIcon(
      new ImageIcon("res/cell_2.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_FAST));
  static final Icon THREE = new ImageIcon(
      new ImageIcon("res/cell_3.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_FAST));
  static final Icon FOUR = new ImageIcon(
      new ImageIcon("res/cell_4.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_FAST));
  static final Icon FIVE = new ImageIcon(
      new ImageIcon("res/cell_5.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_FAST));
  static final Icon SIX = new ImageIcon(
      new ImageIcon("res/cell_6.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_FAST));
  static final Icon SEVEN = new ImageIcon(
      new ImageIcon("res/cell_7.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_FAST));
  static final Icon EIGHT = new ImageIcon(
      new ImageIcon("res/cell_8.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_FAST));
  private boolean flagged;
  private boolean isMine;

  /**
   * Creates a new Tile.
   */
  public Tile() {
    super(BLANK);
    setVerticalTextPosition(JButton.CENTER);
    setHorizontalTextPosition(JButton.CENTER);
  }

  /**
   * Whether the Tile is a mine or not.
   */
  public boolean isMine() {
    return isMine;
  }

  /**
   * Sets the state of the Tile.
   * 
   * @param isMine Whether the Tile is a mine or not.
   */
  public void setMineState(boolean isMine) {
    this.isMine = isMine;
    setDisabledIcon(MINE);
  }

  /**
   * Sets the icon to the flag; unflags if already flagged
   */
  public void flag() {
    if (!flagged)
      setIcon(FLAG);
    else
      setIcon(BLANK);

    flagged = !flagged;
  }

  /**
   * Reveals the number of adjacent mines, and whether it is a mine.
   * 
   * @param num The number of mines adjacent to it.
   * @return Whether the Tile is a mine.
   * @throws IllegalArgumentException If the number of adjacent mines is
   *                                  incorrect.
   */
  public boolean reveal(int num) {
    if (!isMine)
      setText(Integer.toString(num));
    setIcon(BLANK);
    setEnabled(false);
    return isMine;
  }

  /**
   * Resets the tile to default.
   */
  public void reset() {
    setIcon(BLANK);
    setDisabledIcon(BLANK);
    flagged = false;
    isMine = false;
    setEnabled(true);
  }
}