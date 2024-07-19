package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * The DifficultyMedium class represents the medium difficulty level in the game. It implements the
 * DifficultyLevel interface, providing a medium level of difficulty for the game. In this
 * difficulty level, the AI uses random strategy for the first 3 rounds and switches to top strategy
 * after 3 rounds.
 */
public class DifficultyMedium implements DifficultyLevel {

  /**
   * For the first 3 rounds, it will use a random strategy to generate a number. After the 3 rounds,
   * it will return a instance of top strategy.
   *
   * @param fingerList An arraylist which saves the previous rounds of the finger number input from
   *     the player.
   * @param choice The player's choice of even or odd.
   * @param humanWonLastGame A boolean value which defines if the human won the last round.
   * @return instance of a random strategy for the first 3 rounds and then return a instance of top
   *     strategy after the 3 rounds.
   */
  @Override
  public int fingerNum(List<Integer> fingerList, Choice choice, Boolean humanWonLastGame) {
    FingerNumber medium = new FingerNumber(new RandomStrategy(), fingerList, choice);

    // AI uses random strategy until third round
    if (fingerList.size() < 3) {
      return medium.process();
    }

    // After 3 rounds, AI uses top strategy
    medium.setStrategy(new TopStrategy());

    return medium.process();
  }
}
