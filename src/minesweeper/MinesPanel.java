package minesweeper;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.util.Random;

public class MinesPanel extends JPanel {
  final int BEGINNER = 0;
  final int INTERMEDIATE = 1;
  final int EXPERT = 2;

  public MinesPanel(int difficulty) throws IllegalArgumentException {
    super();
    int width, height, mines;
    // Set difficulty of game
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
      // If the difficulty is invalid
      throw new IllegalArgumentException("Invalid difficulty: " + difficulty);
    }
    
    // Create layout of tiles
    setPreferredSize(new Dimension(width*30, height*30));;
    setLayout(new GridLayout(height, width));
    Tile[][] minesList = new Tile[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        minesList[i][j] = new Tile();
        add(minesList[i][j]);
      }
    }

    // Add mines
    Random rand = new Random();
    int mineX, mineY;
    for(int i = 0; i < mines; i++) {
      do {
        mineX = rand.nextInt(width);
        mineY = rand.nextInt(height);
      } while(minesList[mineY][mineX].isMine());
      minesList[mineY][mineX].setMineState(true);
    }
  }
}