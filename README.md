# MineSweeper

By Carlos Saucedo and David Risi

## Rules of the Game (From [Wikipedia](https://en.wikipedia.org/wiki/Microsoft_Minesweeper))

The goal of Minesweeper is to uncover all the squares on a grid that do not contain mines without being "blown up" by clicking on a square with a mine underneath. The location of the mines is discovered through a logical process (but that sometimes results in ambiguity). Clicking on the game board will reveal what is hidden underneath the chosen square or squares (a large number of blank squares [bordering 0 mines] may be revealed in one go if they are adjacent to each other). Some squares are blank while others contain numbers (from 1 to 8), with each number being the number of mines adjacent to the uncovered square.

To help the player avoid hitting a mine, the location of a suspected mine can be marked by flagging it with the right mouse button. The game is won once all blank or numbered squares have been uncovered by the player without hitting a mine; any remaining mines not identified by flags are automatically flagged by the computer. The game board comes in three set sizes with a predetermined number of mines: "beginner", "intermediate", and "expert".

## Acknowledgments

- [Segment7 Font](https://fontlibrary.org/en/font/segment7) (Used with permission, SIL Open Font License (OFL))
- [Tile Sprites](https://www.dropbox.com/sh/i4vvggjag9jlnbv/AAAS7A4yI5fAGryuvYfnPYqwa?dl=0) by [Let's Clone](https://www.youtube.com/channel/UC09fDF0UwNmUBcyje0MBehA) (Open Source)
- [Sound assets](https://github.com/logalex96/Minesweeper/tree/master/sounds) from logalex96 on [GitHub](https://github.com/logalex96/Minesweeper/tree/master/sounds) (Open Source)
- Victory Sound from [SoundBible](http://soundbible.com/1003-Ta-Da.html) (Used with permission, Attributtion 3.0 Unported (CC BY 3.0))
- Explosion sound from [SoundBible](http://soundbible.com/538-Blast.html) (Used with permission, Attributtion 3.0 Unported (CC BY 3.0))

## Special Features

- Sound bytes for different user actions
- Option for chagning difficulty settings

## Work Divison

### Carlos Saucedo

Carlos generated the class structure and created the array of tiles, and developed the sound system and the Menu Panel.

### David Risi

David directly embedded most of the logical functions for flagging, unflagging, revealing tiles, and checking game states.
