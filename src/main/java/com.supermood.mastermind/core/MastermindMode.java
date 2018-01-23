package com.supermood.mastermind.core;

/**
 * Interface allowing to create the game mode.
 * Created by mohamedharrouch on 23/01/2018.
 */
public interface MastermindMode {

  /**
   * Define the combinations length.
   *
   * @return the combination mode length.
   */
  int combinationLength();

  /**
   * Define the possible player attempts.
   *
   * @return the maximum player attempts to find the right combination.
   */
  int maxAttempts();

  /**
   * Define the provider that will generate the right combination.
   */
  Combination createRightCombination();


  /**
   * Ask the player for his attempt and convert the provided string to a combination.
   *
   * @return the player Combination.
   */
  Combination provideUserAttempt();

}
