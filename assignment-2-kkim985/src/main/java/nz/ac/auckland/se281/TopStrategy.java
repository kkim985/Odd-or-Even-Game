package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * The TopStrategy class implements the Strategy interface. TopStrategy checks if there are more
 * even numbers than odd numbers or vice versa and check the player's choice of even/odd. AI will
 * return a number which will make the player lose.
 */
public class TopStrategy implements Strategy {

  /**
   * A method which uses top strategy to return the finger number that the AI uses.
   *
   * @param fingerList An arraylist which saves the previous rounds of the finger number input from
   *     the player.
   * @param choice The player's choice of even or odd.
   * @return The number of fingers that the AI uses.
   */
  @Override
  public int aiFingerNum(List<Integer> fingerList, Choice choice) {

    // initialise the variables
    int numOfEven = 0;
    int numOfOdd = 0;
    int topStrategyNum;

    // iterate through the arraylist and count how many even/odd numbers are there
    for (Integer finger : fingerList) {
      if (Utils.isEven(finger)) {
        numOfEven++;
      }
      if (Utils.isOdd(finger)) {
        numOfOdd++;
      }
    }

    // check if there are more even numbers than odd numbers or vice versa and check the player's
    // choice of even/odd. AI will return a number which will make the player lose.
    if (numOfEven > numOfOdd && choice == Choice.EVEN) {
      topStrategyNum = Utils.getRandomOddNumber();
    } else if (numOfEven > numOfOdd && choice == Choice.ODD) {
      topStrategyNum = Utils.getRandomEvenNumber();
    } else if (numOfEven < numOfOdd && choice == Choice.EVEN) {
      topStrategyNum = Utils.getRandomEvenNumber();
    } else if (numOfEven < numOfOdd && choice == Choice.ODD) {
      topStrategyNum = Utils.getRandomOddNumber();
    } else {
      topStrategyNum = Utils.getRandomNumberRange(0, 5);
    }

    return topStrategyNum;
  }
}
