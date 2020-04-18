package minesweeper;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Tile extends JButton {
  // Icons available for each Tile
  static final Icon BLANK = new ImageIcon(new ImageIcon("res/cell_blank.png").getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH));
  static final Icon MINE = new ImageIcon(new ImageIcon("res/cell_mine.png").getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH));
  static final Icon FLAG = new ImageIcon(new ImageIcon("res/cell_flag.png").getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH));
  private boolean flagged;
  private boolean isMine;

  
  // Creates a new Tile
  public Tile() {
    super(BLANK);
    setVerticalTextPosition(JButton.CENTER);
    setHorizontalTextPosition(JButton.CENTER);
  }

  // Whether a Tile is a mine or not
  public boolean isMine() {
    return isMine;
  }

  // Sets the state of the mine
  public void setMineState(boolean isMine) {
    this.isMine = isMine;
    setDisabledIcon(MINE);
  }
 
  // Sets the icon to the flag; unflags if already flagged
  public void flag() {
    if(!flagged)
      setIcon(FLAG);
    else
      setIcon(BLANK);

    flagged = !flagged;
  }

  // Reveals bomb or number
  public boolean reveal(int num) {
    if(!isMine)
      setText(Integer.toString(num));
    setIcon(BLANK);
    setEnabled(false);
    return isMine;
  }

  // Resets the tile To default
  public void reset() {
    setIcon(BLANK);
    setDisabledIcon(BLANK);
    flagged = false;
    isMine = false;
    setEnabled(true);
  }
}