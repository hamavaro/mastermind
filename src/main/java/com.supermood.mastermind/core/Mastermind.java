package com.supermood.mastermind.core;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class allowing to construct and start a game.
 * Created by mohamedharrouch on 23/01/2018.
 */
public class Mastermind {

  /**
   * The game mode.
   */
  private MastermindMode mode;

  /**
   * Comparator used to compare the player attempt with the original combination.
   */
  private MastermindComparator comparator;

  /**
   * The right combination that should be found by the player.
   */
  private Combination rightCombination;

  /**
   * Answers attempted by the player.
   */
  private Map<Combination, RoundResult> playerResponse;

  /**
   * Boolean indicating if the player has succeed.
   */
  private boolean playerSucceeded;

  /**
   * Public constructor.
   *
   * @param gameMode tha game mode that will be used.
   * @param pComparator Comparator implementation that will be used.
   */
  public Mastermind(final MastermindMode gameMode, final MastermindComparator pComparator) {
    mode = gameMode;
    playerSucceeded = false;
    comparator = pComparator;
    rightCombination = mode.createRightCombination();
    playerResponse = new LinkedHashMap<>(mode.maxAttempts());
  }

  /**
   * Function allowing the game to start.
   */
  public void start() {
    RoundResult result;
    int tour = 0;
    System.out.println(
        "Ordinateur > J’ai choisit ma combinaison, à vous de deviner ! Les couleurs possibles sont R J B O V et N."
            + "Tapez (RJBO) pour tenter les couleurs R,J,B et O dans l’ordre. Voici la grille actuelle");
    while ((playerResponse.size() < mode.maxAttempts()) && !playerSucceeded) {
      System.out.println(displayResult());
      Combination attempt = mode.provideUserAttempt();
      result = comparator.compare(rightCombination, attempt);
      playerResponse.put(attempt, result);
      if (result.isSuccess()) {
        playerSucceeded = true;
      }
      tour++;
    }
    System.out.println(displayResult());
    if (playerSucceeded) {
      System.out.println(String.format("Bravo vous avez gagné en %d tours !", tour));
    } else {
      System.out.println(String.format("Vous avez malheureusement perdu !"));
    }
    System.out.println(String.format("La bonne réponse est %s", rightCombination.toString()));
  }

  /**
   * Display result method.
   *
   * @return Readable combinations result.
   */
  private String displayResult() {
    StringBuilder builder = new StringBuilder();
    builder = builder.append("|-------------------|\n");
    final int maxAttempts = mode.maxAttempts();
    int index = 0;
    RoundResult result = null;
    if (playerResponse != null && !playerResponse.isEmpty()) {
      playerResponse.forEach((k, v) -> {

      });
      for (Map.Entry<Combination, RoundResult> entry : playerResponse.entrySet()) {
        index++;
        builder = builder.append("|")
            .append(entry.getKey().toString())
            .append("| ")
            .append(entry.getValue().getCorrectPosition())
            .append(" | ")
            .append(entry.getValue().getCorrectColor())
            .append(" | ")
            .append(index)
            .append("/")
            .append(maxAttempts)
            .append(" |")
            .append("\n");
      }
    }
    if (index < maxAttempts) {
      builder = builder.append("|....| . | . | ")
          .append(index + 1)
          .append("/")
          .append(maxAttempts)
          .append(" |")
          .append("\n");
    }
    builder = builder.append("|-------------------|");
    return builder.toString();
  }
}
