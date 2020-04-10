package app;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

public class MinesPanel extends JPanel {
  final int BEGINNER = 0;
  final int INTERMEDIATE = 1;
  final int EXPERT = 2;

  public MinesPanel(int difficulty) throws IllegalArgumentException {
    super();
    int width, height, mines;
    // Set difficulty of game.
    if (difficulty == BEGINNER) {
      width = 9;
      height = 9;
      mines = 10;
    } else if (difficulty == INTERMEDIATE) {
      width = 16;
      height = 16;
      mines = 40;
    } else if (difficulty == EXPERT) {
      width = 30;
      height = 16;
      mines = 99;
    } else {
      // If the difficulty is invalid.
      throw new IllegalArgumentException("Invalid difficulty: " + difficulty);
    }
    // Create layout of mines.
    GridLayout layout = new GridLayout(width, height);
    // 2D array of mines.
    Tile[][] minesList = new Tile[width][height];
    // Populating array with blank Tiles.
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        minesList[i][j] = new Tile();
        this.add(minesList[i][j]);
      }
    }

    // Adding mines.
    int minesPlaced = 0;
    Random rand = new Random();
    while (minesPlaced < mines) {
      int mineX = rand.nextInt(width);
      int mineY = rand.nextInt(height);
      if (!minesList[mineX][mineY].isMine()) {
        minesList[mineX][mineY].setMineState(true);
        minesPlaced++;
      }
    }
    this.setLayout(layout);
  }
}