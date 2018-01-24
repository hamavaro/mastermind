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

  /**
   * Should compare the two combinations that can contains redundant colors.
   */
  @Test
  public void compareCombinationRedundantColorTest() {
    Combination original = new Combination(4, Pawn.GREEN, Pawn.ORANGE, Pawn.ORANGE, Pawn.GREEN);
    Combination combinationAttempted = new Combination(4, Pawn.ORANGE, Pawn.ORANGE, Pawn.ORANGE, Pawn.GREEN);
    MastermindComparator classic = new MastermindClassicComparator();
    RoundResult result = classic.compare(original, combinationAttempted);
    Assert.assertFalse(result.isSuccess());
    final int expectedRightColors = 0;
    Assert.assertEquals(expectedRightColors, result.getCorrectColor());
    final int expectedRightPosition = 3;
    Assert.assertEquals(expectedRightPosition, result.getCorrectPosition());
  }

  /**
   * Should compare the two combinations that can contains redundant colors.
   */
  @Test
  public void compareCombinationWithOccurrenceTest() {
    Combination original = new Combination(4, Pawn.RED, Pawn.ORANGE, Pawn.ORANGE, Pawn.YELLOW);
    Combination combinationAttempted = new Combination(4, Pawn.YELLOW, Pawn.YELLOW, Pawn.ORANGE, Pawn.RED);
    MastermindComparator classic = new MastermindClassicComparator();
    RoundResult result = classic.compare(original, combinationAttempted);
    Assert.assertFalse(result.isSuccess());
    final int expectedRightColors = 2;
    Assert.assertEquals(expectedRightColors, result.getCorrectColor());
    final int expectedRightPosition = 1;
    Assert.assertEquals(expectedRightPosition, result.getCorrectPosition());
  }

  /**
   * Should compare the two combinations that can contains redundant colors.
   */
  @Test
  public void compareCombinationWithNoOccurrenceTest() {
    Combination original = new Combination(4, Pawn.GREEN, Pawn.ORANGE, Pawn.ORANGE, Pawn.GREEN);
    Combination combinationAttempted = new Combination(4, Pawn.BLUE, Pawn.BLUE, Pawn.BLUE, Pawn.BLUE);
    MastermindComparator classic = new MastermindClassicComparator();
    RoundResult result = classic.compare(original, combinationAttempted);
    Assert.assertFalse(result.isSuccess());
    final int expectedRightColors = 0;
    Assert.assertEquals(expectedRightColors, result.getCorrectColor());
    final int expectedRightPosition = 0;
    Assert.assertEquals(expectedRightPosition, result.getCorrectPosition());
  }

  /**
   * Should compare the two combinations that can contains redundant colors.
   */
  @Test
  public void compareCombinationWithAllColorOnlyCorrectsTest() {
    Combination original = new Combination(4, Pawn.RED, Pawn.ORANGE, Pawn.ORANGE, Pawn.YELLOW);
    Combination combinationAttempted = new Combination(4, Pawn.ORANGE, Pawn.RED, Pawn.YELLOW, Pawn.ORANGE);
    MastermindComparator classic = new MastermindClassicComparator();
    RoundResult result = classic.compare(original, combinationAttempted);
    Assert.assertFalse(result.isSuccess());
    final int expectedRightColors = 4;
    Assert.assertEquals(expectedRightColors, result.getCorrectColor());
    final int expectedRightPosition = 0;
    Assert.assertEquals(expectedRightPosition, result.getCorrectPosition());
  }
}
