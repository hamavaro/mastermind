package com.supermood.mastermind.core;

import com.supermood.mastermind.constant.Pawn;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Classic mode implementation for Mastermind Game.
 * Created by mohamedharrouch on 23/01/2018.
 */
public class ClassicModeImpl implements MastermindMode {

  /**
   * Classic mode length is 4.
   */
  private static final int COMBINATION_LENGTH = 4;

  /**
   * Classic mode max attempts is 10;
   */
  private static final int MAX_ATTEMPTS = 10;

  @Override
  public final int combinationLength() {
    return COMBINATION_LENGTH;
  }

  @Override
  public final int maxAttempts() {
    return MAX_ATTEMPTS;
  }

  @Override
  public final Combination createRightCombination() {
    // Generate random combination.
    Pawn[] allPawns = Pawn.class.getEnumConstants();
    List<Pawn> randomPawns = new ArrayList<>(COMBINATION_LENGTH);
    for (int i = 0; i < COMBINATION_LENGTH; i++) {
      int randomInt = new Random().nextInt(allPawns.length);
      randomPawns.add(allPawns[randomInt]);
    }
    return new Combination(COMBINATION_LENGTH, randomPawns.toArray(new Pawn[randomPawns.size()]));
  }

  @Override
  public final Combination provideUserAttempt() {
    // Ask user to provide Combination from command line.
    Scanner scanner = new Scanner(System.in);
    System.out.println("VOUS > ");
    String input = scanner.nextLine();
    int inputLength = input.length();
    if (inputLength != COMBINATION_LENGTH) {
      throw new IllegalArgumentException("The input should have the same length as the game mode.");
    }
    List<Pawn> providedPawns = null;
    for (int i = 0; i < inputLength; i++) {
      if (providedPawns == null) {
        providedPawns = new ArrayList<>();
      }
      Pawn currentPawn = Pawn.getPawnByReadableColor(String.valueOf(input.charAt(i)));
      providedPawns.add(currentPawn);
    }
    return new Combination(COMBINATION_LENGTH, providedPawns.toArray(new Pawn[providedPawns.size()]));
  }
}
