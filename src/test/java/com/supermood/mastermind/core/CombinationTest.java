package com.supermood.mastermind.core;

import com.supermood.mastermind.constant.Pawn;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for Combination bean using Junit4.
 * Created by mohamedharrouch on 23/01/2018.
 */
public class CombinationTest {

  /**
   * Should return Return a readable string corresponding to the entered colors.
   *
   * @throws IllegalArgumentException on invalid params provided to the constructor.
   */
  @Test
  public void toStringWithCorrectCombinationTest() throws IllegalArgumentException {
    final int combinationLength = 4;
    Combination combination = new Combination(combinationLength, Pawn.BLACK, Pawn.GREEN, Pawn.ORANGE, Pawn.BLUE);
    final String expectedString = "NVOB";
    Assert.assertEquals(expectedString, combination.toString());
  }

}