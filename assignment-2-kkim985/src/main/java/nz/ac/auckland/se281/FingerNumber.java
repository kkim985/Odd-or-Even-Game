package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * The FingerNumber class represents the AI's finger number determination. It encapsulates the
 * strategy for choosing the number of fingers to display based on the opponent's previous finger
 * counts and their choice (even or odd).
 */
public class FingerNumber {
  // initialise the variables
  private Strategy strategy;
  private List<Integer> fingerList;
  private Choice choice;

  /**
   * Constructs a new FingerNumber instance with the specified strategy, finger list, and choice.
   *
   * @param strategy the strategy used for the AI to determine the number of fingers to display
   * @param fingerList list of the player's previous finger counts
   * @param choice the player's choice of even or odd
   */
  public FingerNumber(Strategy strategy, List<Integer> fingerList, Choice choice) {
    this.strategy = strategy;
    this.fingerList = fingerList;
    this.choice = choice;
  }

  // create a getter method for the strategy
  public Strategy getStrategy() {
    return strategy;
  }

  // create a setter method to update the strategy
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int process() {
    return strategy.aiFingerNum(fingerList, choice);
  }
}
