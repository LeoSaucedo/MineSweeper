package minesweeper;

public enum Difficulty {
  EASY(0), MEDIUM(1), HARD(2);

  public final int VALUE; // The value representing the difficulty.
  public final int WIDTH; // The width, in Tiles, of the game space.
  public final int HEIGHT; // The height, in Tiles, of the game space.
  public final int MINES; // The number of Mines in the game space.

  private Difficulty(int val) {
    VALUE = val;
    if (val == 0) {
      WIDTH = 9;
      HEIGHT = 9;
      MINES = 10;
    } else if (val == 1) {
      WIDTH = 16;
      HEIGHT = 16;
      MINES = 40;
    } else {
      WIDTH = 30;
      HEIGHT = 16;
      MINES = 99;
    }
  }
}
