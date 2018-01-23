package com.supermood.mastermind.core;

import com.supermood.mastermind.constant.Pawn;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mohamedharrouch on 23/01/2018.
 */
public class MastermindClassicComparatorTest {

  /**
   * Should compare the two combinations that can contains redundant colors.
   */
  @Test
  public void compareCombinationWithRedundantColorsTest() {
    Combination original = new Combination(4, Pawn.ORANGE, Pawn.ORANGE, Pawn.GREEN, Pawn.BLACK);
    Combination combinationAttempted = new Combination(4, Pawn.GREEN, Pawn.BLUE, Pawn.YELLOW, Pawn.YELLOW);
    MastermindComparator classic = new MastermindClassicComparator();
    RoundResult result = classic.compare(original, combinationAttempted);
    Assert.assertFalse(result.isSuccess());
    final int expectedRightColors = 1;
    Assert.assertEquals(expectedRightColors, result.getCorrectColor());
    final int expectedRightPosition = 0;
    Assert.assertEquals(expectedRightPosition, result.getCorrectPosition());
  }

  /**
   * Should compare the two combinations that can contains redundant colors.
   */
  @Test
  public void compareCombinationRightAttemptTest() {
    Combination original = new Combination(4, Pawn.ORANGE, Pawn.ORANGE, Pawn.GREEN, Pawn.BLACK);
    Combination combinationAttempted = new Combination(4, Pawn.ORANGE, Pawn.ORANGE, Pawn.GREEN, Pawn.BLACK);
    MastermindComparator classic = new MastermindClassicComparator();
    RoundResult result = classic.compare(original, combinationAttempted);
    Assert.assertTrue(result.isSuccess());
    final int expectedRightColors = 0;
    Assert.assertEquals(expectedRightColors, result.getCorrectColor());
    final int expectedRightPosition = 4;
    Assert.assertEquals(expectedRightPosition, result.getCorrectPosition());
  }

}