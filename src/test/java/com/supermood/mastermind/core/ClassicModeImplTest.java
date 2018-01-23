package com.supermood.mastermind.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for ClassicMode implementation.
 * Created by mohamedharrouch on 23/01/2018.
 */
public class ClassicModeImplTest {

  /**
   * Should create combination with the right length mode.
   */
  @Test
  public final void createRightCombinationTest() {
    MastermindMode classic = new ClassicModeImpl();
    Combination random = classic.createRightCombination();
    Assert.assertNotNull(random);
    Assert.assertEquals(classic.combinationLength(), random.getCombinationLength());
  }

}