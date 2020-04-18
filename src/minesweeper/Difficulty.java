package minesweeper;

public enum Difficulty {
    EASY(0), MEDIUM(1), HARD(2);

    public final int VALUE;
    public final int WIDTH;
    public final int HEIGHT;
    public final int MINES;

    private Difficulty(int val) {
      VALUE = val;
      if(val == 0) {
        WIDTH = 9;
        HEIGHT = 9;
        MINES = 10;
      }
      else if(val == 1) {
        WIDTH = 16;
        HEIGHT = 16;
        MINES = 40;
      }
      else {
        WIDTH = 30;
        HEIGHT = 16;
        MINES = 99;
      }
    }
  }
