package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

/**
 * The DifficultyFactory class creates instances of DifficultyLevel based on the chosen difficulty
 * level. Each difficulty level corresponds to a specific subclass of DifficultyLevel:
 * DifficultyEasy, DifficultyMedium, and DifficultyHard.
 */
public class DifficultyFactory {

  /**
   * Creates a new instance of DifficultyLevel based on the specified difficulty.
   *
   * @param difficulty The chosen difficulty level.
   * @return A new instance of DifficultyLevel based on the specified difficulty.
   */
  public static DifficultyLevel createDifficultyLevel(Difficulty difficulty) {
    // according to the difficulty, it will return the correct AI finger number based on what
    // difficulty the player has chosen
    switch (difficulty) {
      case EASY:
        return new DifficultyEasy();
      case MEDIUM:
        return new DifficultyMedium();
      case HARD:
        return new DifficultyHard();
      default:
        MessageCli.INVALID_DIFFICULTY.printMessage();
        System.exit(0);
    }
    return null;
  }
}
