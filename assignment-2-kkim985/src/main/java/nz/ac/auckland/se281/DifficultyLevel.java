package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * The DifficultyLevel interface represents a specific level of difficulty in the game. It defines a
 * method for the AI to use when displaying finger number based on the current difficulty of the
 * game.
 */
public interface DifficultyLevel {

  /**
   * Method which is going to be overrided by other classes which implements this interface.
   *
   * @param fingerList An arraylist which saves the previous rounds of the finger number input from
   *     the player.
   * @param choice The player's choice of even or odd.
   * @param humanWonLastGame A boolean value which defines if the human won the last round.
   * @return The number of fingers that the AI uses.
   */
  public int fingerNum(List<Integer> fingerList, Choice choice, Boolean humanWonLastGame);
}
