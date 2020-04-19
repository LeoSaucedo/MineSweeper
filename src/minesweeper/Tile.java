package minesweeper;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Tile extends JButton {
  // Icons available for each Tile
  static final Icon BLANK = new ImageIcon(
      new ImageIcon("res/cell_blank.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
  static final Icon MINE = new ImageIcon(
      new ImageIcon("res/cell_mine.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
  static final Icon FLAG = new ImageIcon(
      new ImageIcon("res/cell_flag.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
  private boolean flagged = false;
  private boolean isMine;

  // Creates a new Tile
  public Tile() {
    super(BLANK);
  }

  // Whether a Tile is a mine or not
  public boolean isMine() {
    return isMine;
  }

  // Sets the state of the mine
  public void setMineState(boolean isMine) {
    this.isMine = isMine;
  }

  // Sets the icon to the flag; unflags if already flagged
  public void flag() {
    if (!flagged)
      setIcon(FLAG);
    else
      setIcon(BLANK);

    flagged = !flagged;
  }

  // Resets the tile To default
  public void reset() {
    setIcon(BLANK);
    flagged = false;
    isMine = false;
  }
}