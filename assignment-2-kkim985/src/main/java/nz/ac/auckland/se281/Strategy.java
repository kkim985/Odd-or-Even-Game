package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/**
 * The Strategy interface can be implemented to determine the number of fingers an AI display in a
 * game.
 */
public interface Strategy {

  /**
   * Method which is used to be overrided by other classes which implements this interface.
   *
   * @param fingerList An arraylist which saves the previous rounds of the finger number input from
   *     the player.
   * @param choice The player's choice of even or odd.
   * @return The number of fingers that the AI uses.
   */
  public int aiFingerNum(List<Integer> fingerList, Choice choice);
}
