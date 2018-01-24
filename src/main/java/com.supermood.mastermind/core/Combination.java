package com.supermood.mastermind.core;

import com.supermood.mastermind.constant.Pawn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class representing a combination of color.
 * Created by mohamedharrouch on 23/01/2018.
 */
public class Combination {

  /**
   * The max combination length that can be provided.
   */
  private static final int MAX_COMBINATION_LENGTH = 10;

  /**
   * The min combination length that can be provided.
   */
  private static final int MIN_COMBINATION_LENGTH = 2;

  /**
   * Combination pawns count (usually 4).
   */
  private int combinationLength;

  /**
   * Ordered pawns.
   */
  private List<Pawn> combinationSuite;

  /**
   * Public constructor.
   *
   * @param length combination length.
   * @param pawns suite containing ordered combination.
   */
  public Combination(final int length, final Pawn... pawns) {
    if (length > MAX_COMBINATION_LENGTH || length < MIN_COMBINATION_LENGTH) {
      throw new IllegalArgumentException(
          String.format("invalid combination length provided, should be between %s and %s.", MIN_COMBINATION_LENGTH,
              MAX_COMBINATION_LENGTH));
    }
    if (pawns == null || pawns.length != length) {
      throw new IllegalArgumentException(String.format("No pawns combination was found."));
    }
    combinationLength = length;
    combinationSuite = new ArrayList<>(Arrays.asList(pawns));
  }

  /**
   * Getter method.
   *
   * @return the combination length.
   */
  public int getCombinationLength() {
    return combinationLength;
  }

  /**
   * Getter method.
   *
   * @return the ordered combination suite.
   */
  public List<Pawn> getCombinationSuite() {
    return combinationSuite;
  }

  /**
   * ToString method.
   *
   * @return String readable combination.
   */
  public String toString() {
    String readableCombination = "";
    if (combinationSuite != null) {
      readableCombination = combinationSuite.stream().map(Pawn::getReadableColor).collect(Collectors.joining());
    }
    return readableCombination;
  }

}
