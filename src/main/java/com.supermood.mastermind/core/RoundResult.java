package com.supermood.mastermind.core;

/**
 * Result of each comparison.
 * Created by mohamedharrouch on 23/01/2018.
 */
public class RoundResult {

  /**
   * Pawns with the right color in the correct position.
   */
  private int correctPosition;

  /**
   * Pawns with the right colors.
   */
  private int correctColor;

  /**
   * original combination length.
   */
  private int originalCombinationLength;

  /**
   * Original combination length.
   *
   * @param poriginalCombinationLength the original combination length (used only to determine if it's the right
   * combination).
   */
  public RoundResult(final int poriginalCombinationLength) {
    originalCombinationLength = poriginalCombinationLength;
  }

  /**
   * Determine if it's a correct answer.
   *
   * @return boolean true if it's the correct answer.
   */
  public boolean isSuccess() {
    return correctPosition == originalCombinationLength;
  }

  /**
   * Increment the correct position count.
   */
  public void incrementCorrectPosition() {
    correctPosition++;
  }

  /**
   * Correct position getter.
   *
   * @return correct pawns position count.
   */
  public final int getCorrectPosition() {
    return correctPosition;
  }

  /**
   * Correct color position getter.
   *
   * @return correct pawns color count.
   */
  public final int getCorrectColor() {
    return correctColor;
  }

  /**
   * Getter for the original combination length.
   *
   * @return original combination length.
   */
  public final int getOriginalCombinationLength() {
    return originalCombinationLength;
  }

  /**
   * Increment the correct colors count.
   */
  public void incrementCorrectColor() {
    correctColor++;
  }


}
