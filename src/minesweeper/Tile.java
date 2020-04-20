package minesweeper;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Tile extends JButton {
  // Icons available for each Tile
  private static final Icon BLANK = new ImageIcon(
      new ImageIcon("res/cell_blank.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
  private static final Icon MINE = new ImageIcon(
      new ImageIcon("res/cell_mine.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
  private static final Icon FLAG = new ImageIcon(
      new ImageIcon("res/cell_flag.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
  private static final Icon ONE = new ImageIcon(
      new ImageIcon("res/cell_1.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
  private static final Icon TWO = new ImageIcon(
      new ImageIcon("res/cell_2.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
  private static final Icon THREE = new ImageIcon(
      new ImageIcon("res/cell_3.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
  private static final Icon FOUR = new ImageIcon(
      new ImageIcon("res/cell_4.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
  private static final Icon FIVE = new ImageIcon(
      new ImageIcon("res/cell_5.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
  private static final Icon SIX = new ImageIcon(
      new ImageIcon("res/cell_6.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
  private static final Icon SEVEN = new ImageIcon(
      new ImageIcon("res/cell_7.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
  private static final Icon EIGHT = new ImageIcon(
      new ImageIcon("res/cell_8.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
  private boolean flagged;
  private boolean isMine;
  // The number of nearby mines
  private int danger;

  /**
   * Creates a new Tile.
   */
  public Tile() {
    super(BLANK);
    setDisabledIcon(BLANK);
    setVerticalTextPosition(JButton.CENTER);
    setHorizontalTextPosition(JButton.CENTER);
    flagged = false;
    isMine = false;
    danger = 0;
  }

  /**
   * Returns whether the Tile is a mine or not.
   * 
   * @return Whether the Tile is a mine.
   */
  public boolean isMine() {
    return isMine;
  }

  /**
   * Returns whether the Tile is flagged.
   * 
   * @return Whether the Tile is flagged.
   */
  public boolean isFlagged() {
    return flagged;
  }

  /**
   * Returns the number of nearby mines.
   * 
   * @return The number of nearby mines.
   */
  public int danger() {
    return danger;
  }

  /**
   * Sets whether a Tile is a mine or not.
   */
  public void setMineState(boolean isMine) {
    this.isMine = isMine;
    setDisabledIcon(MINE);
  }

  /**
   * Increments the number of mines adjacent to the Tile.
   */
  public void increaseDanger() {
    danger++;
  }

  /**
   * Sets the icon to the flag.
   */
  public void flag() {
    if (!flagged)
      setIcon(FLAG);
    else
      setIcon(BLANK);

    flagged = !flagged;
  }

  // Reveals mine or number, returns the number of nearby mines (if isMine returns
  // -1)
  /**
   * Reveals the number of adjacent Mines.
   * 
   * @return Whether a Tile is a mine.
   */
  public int reveal() {
    setEnabled(false);
    if (!isMine) {
      switch (danger) {
        case 0:
          setDisabledIcon(null);
          break;
        case 1:
          setDisabledIcon(ONE);
          break;
        case 2:
          setDisabledIcon(TWO);
          break;
        case 3:
          setDisabledIcon(THREE);
          break;
        case 4:
          setDisabledIcon(FOUR);
          break;
        case 5:
          setDisabledIcon(FIVE);
          break;
        case 6:
          setDisabledIcon(SIX);
          break;
        case 7:
          setDisabledIcon(SEVEN);
          break;
        case 8:
          setDisabledIcon(EIGHT);
          break;
      }

      return danger;
    }
    return -1;
  }

  /**
   * Returns whether a Tile's status has been revealed.
   * 
   * @return Whether the Tile's status has been revealed.
   */
  public boolean revealed() {
    return !isEnabled();
  }

  /**
   * Resets the tile to its default state.
   */
  public void reset() {
    setIcon(BLANK);
    setDisabledIcon(BLANK);
    flagged = false;
    isMine = false;
    setEnabled(true);
  }
}