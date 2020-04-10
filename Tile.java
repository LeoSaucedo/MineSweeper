import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Tile extends JButton {
  final ImageIcon BLANK = new ImageIcon("Sprites/cell_blank.png");
  final ImageIcon MINE = new ImageIcon("Sprites/cell_mine.png");
  final ImageIcon FLAG = new ImageIcon("Sprites/cell_flag.png");
  private boolean isMine = false;

  /**
   * Creates a new Tile.
   */
  public Tile() {
    super(new ImageIcon("Sprites/cell_blank.png"));
  }

  /**
   * Whether a Tile is a mine or not.
   * 
   * @return Whether the tile is a mine.
   */
  public boolean isMine() {
    return isMine;
  }

  /**
   * Flags the tile. Sets the icon to be the flag icon.
   */
  public void Flag() {
    this.setIcon(FLAG);
  }

  /**
   * Unflags the icon. Returns the tile to blank.
   */
  public void UnFlag() {
    this.setIcon(BLANK);
  }

  /**
   * Sets the state of the mine.
   * 
   * @param isMine Whether the Tile is a mine or not.
   */
  void setMineState(boolean isMine) {
    this.isMine = isMine;
  }
}