package com.supermood.mastermind.core;

/**
 * Interface defining the method used to compare combinations.
 * Created by mohamedharrouch on 23/01/2018.
 */
public interface MastermindComparator {

  /**
   * Compare two combinations.
   *
   * @param original the original combination that should be found by the player.
   * @param provided the combination provided by the user.
   * @return Comparison result.
   */
  RoundResult compare(Combination original, Combination provided);

}
