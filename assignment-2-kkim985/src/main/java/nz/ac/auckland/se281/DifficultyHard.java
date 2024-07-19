package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * The DifficultyHard class represents the hard difficulty level in the game. It implements the
 * DifficultyLevel interface, providing a hard level of difficulty for the game. In this difficulty
 * level, the AI uses a random strategy for the first 3 rounds and then chooses other strategy based
 * on the outcome of the previous rounds.
 */
public class DifficultyHard implements DifficultyLevel {

  // initialises the variables
  private Strategy lastUsedStrategy;
  private FingerNumber chosenStrategy;

  /**
   * For the first 3 rounds, it returns an instance of random strategy. After the 3 rounds, if the
   * human won the previous round, it will return the other instance of the strategy from the
   * previous round.
   *
   * @param fingerList An arraylist which saves the previous rounds of the finger number input from
   *     the player.
   * @param choice The player's choice of even or odd.
   * @param humanWonLastGame A boolean value which defines if the human won the last round.
   * @return instance of a random or top strategy.
   */
  @Override
  public int fingerNum(List<Integer> fingerList, Choice choice, Boolean humanWonLastGame) {

    chosenStrategy = new FingerNumber(new RandomStrategy(), fingerList, choice);

    if (fingerList.size() < 3) { // AI uses random strategy for the first 3 rounds
      chosenStrategy.setStrategy(new RandomStrategy());
      lastUsedStrategy = chosenStrategy.getStrategy();
    } else if (humanWonLastGame) { // After the 3 rounds, if human won the last round, it will
      // change the strategy from the last round
      if (lastUsedStrategy instanceof RandomStrategy) {
        chosenStrategy.setStrategy(new TopStrategy());
        lastUsedStrategy = chosenStrategy.getStrategy();
      } else {
        chosenStrategy.setStrategy(new RandomStrategy());
        lastUsedStrategy = chosenStrategy.getStrategy();
      }
    } else { // After the 3 rounds, if AI won the last round, it will remain using the same strategy
      // from the last round
      chosenStrategy.setStrategy(lastUsedStrategy);
    }

    return chosenStrategy.process();
  }
}
