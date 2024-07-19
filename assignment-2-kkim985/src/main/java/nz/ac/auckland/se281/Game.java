package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  // initialise the variables
  private String aiName = "HAL-9000";
  private String numberType;
  private String fingerInput;
  private String player;
  private int fingerAi;
  private int numOfHumanWin = 0;
  private int numOfAiWin = 0;
  private int numOfRound;
  private int sum;
  private boolean humanWonLastGame;
  private Choice playerChoice;
  private DifficultyLevel difficultyLevel;
  private List<Integer> fingerList = new ArrayList<>();

  /**
   * Starts a new game with the specified difficulty, player choice, and player name.
   *
   * @param difficulty The difficulty level of the game that the player chooses.
   * @param choice The player's choice of even or odd.
   * @param options An array containing the player's name.
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    numOfRound = 1;
    player = options[0];
    difficultyLevel = DifficultyFactory.createDifficultyLevel(difficulty);
    playerChoice = choice;
    fingerList.clear();
  }

  /** Plays one round of the game. */
  public void play() {

    // if there are no games, print out message which says the game has not started
    if (numOfRound == 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.START_ROUND.printMessage(Integer.toString(numOfRound));

    MessageCli.ASK_INPUT.printMessage();
    fingerInput = Utils.scanner.nextLine();

    // if the input from the player is invalid, it asks back the player to put in a correct input
    while (!Utils.isInteger(fingerInput)
        || Integer.parseInt(fingerInput) < 0
        || Integer.parseInt(fingerInput) > 5) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();
      fingerInput = Utils.scanner.nextLine();
    }

    MessageCli.PRINT_INFO_HAND.printMessage(player, fingerInput);

    fingerAi = difficultyLevel.fingerNum(fingerList, playerChoice, humanWonLastGame);
    MessageCli.PRINT_INFO_HAND.printMessage(aiName, Integer.toString(fingerAi));

    sum = Integer.parseInt(fingerInput) + fingerAi;

    // checks if the sum of the player's number and the AI's number even or odd. If the player's
    // choice of even/odd is the same as the sum, the player wins. If not, AI wins.
    if (Utils.isEven(sum) && playerChoice == Choice.EVEN) {
      numberType = "EVEN";
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), numberType, player);
      humanWonLastGame = true;
      numOfHumanWin++;
    } else if (Utils.isEven(sum) && playerChoice == Choice.ODD) {
      numberType = "EVEN";
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), numberType, aiName);
      humanWonLastGame = false;
      numOfAiWin++;
    } else if (Utils.isOdd(sum) && playerChoice == Choice.ODD) {
      numberType = "ODD";
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), numberType, player);
      humanWonLastGame = true;
      numOfHumanWin++;
    } else if (Utils.isOdd(sum) && playerChoice == Choice.EVEN) {
      numberType = "ODD";
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), numberType, aiName);
      humanWonLastGame = false;
      numOfAiWin++;
    }

    // increments the number of round
    numOfRound++;

    // add the number of finger input into the arraylist
    fingerList.add(Integer.parseInt(fingerInput));
  }

  /** Ends the current on-going game. */
  public void endGame() {

    // if there are no games, print out message which says the game has not started
    if (numOfRound == 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    showStats();

    // check whether human won more than AI or AI won more than human and print out a message
    // congratulating the winner
    if (numOfHumanWin > numOfAiWin) {
      MessageCli.PRINT_END_GAME.printMessage(player);
    } else if (numOfHumanWin < numOfAiWin) {
      MessageCli.PRINT_END_GAME.printMessage(aiName);
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }

    // reset the variables as the game ended
    numOfRound = 0;
    numOfHumanWin = 0;
    numOfAiWin = 0;
  }

  /** Displays the statistics of the current on-going game. */
  public void showStats() {

    // if there are no games, print out message which says the game has not started
    if (numOfRound == 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // prints out the current stats of how many times the human/AI won/lost
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        player, Integer.toString(numOfHumanWin), Integer.toString(numOfAiWin));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        aiName, Integer.toString(numOfAiWin), Integer.toString(numOfHumanWin));
  }
}
