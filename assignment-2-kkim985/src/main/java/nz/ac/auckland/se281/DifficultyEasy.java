package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * The DifficultyEasy class represents the easy difficulty level in the game. It implements the
 * DifficultyLevel interface, providing a hard level of difficulty for the game. The AI uses a
 * random strategy to determine the it's move.
 */
public class DifficultyEasy implements DifficultyLevel {

  // AI uses random strategy to return finger number

  /**
   * Returns an instance of random strategy.
   *
   * @param fingerList An arraylist which saves the previous rounds of the finger number input from
   *     the player.
   * @param choice The player's choice of even or odd.
   * @param humanWonLastGame A boolean value which defines if the human won the last round.
   * @return instance of a random strategy
   */
  @Override
  public int fingerNum(List<Integer> fingerList, Choice choice, Boolean humanWonLastGame) {
    FingerNumber easy = new FingerNumber(new RandomStrategy(), fingerList, choice);

    return easy.process();
  }
}
