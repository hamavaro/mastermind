package com.supermood.mastermind.core;

/**
 * Main class to launch the game.
 * Created by mohamedharrouch on 23/01/2018.
 */
public final class Main {

  /**
   * Private constructor.
   */
  private Main() {
  }

  /**
   * Main function.
   *
   * @param args program args.
   */
  public static void main(final String[] args) {
    MastermindMode classicMode = new ClassicModeImpl();
    MastermindComparator classicComparator = new MastermindClassicComparator();
    Mastermind mastermind = new Mastermind(classicMode, classicComparator);
    mastermind.start();
  }

}
