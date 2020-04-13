package minesweeper;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class GameBar extends JMenuBar {
    public GameBar() {
        JMenu gameMenu = new JMenu("Game");
        JMenu optMenu = new JMenu("Options");
        add(gameMenu);
        add(optMenu);
    }
}