package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * The RandomStrategy class implements the Strategy interface, providing a strategy where the AI
 * uses random strategy to choose the number of fingers to display.
 */
public class RandomStrategy implements Strategy {

  /**
   * The method which uses random strategy to return a random finger number.
   *
   * @param fingerList An arraylist which saves the previous rounds of the finger number input from
   *     the player.
   * @param choice The player's choice of even or odd.
   * @return The number of fingers that the AI uses.
   */
  @Override
  public int aiFingerNum(List<Integer> fingerList, Choice choice) {
    return Utils.getRandomNumberRange(0, 5);
  }
}
