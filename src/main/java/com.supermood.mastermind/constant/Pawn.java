package com.supermood.mastermind.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Possible pawns in the game.
 * Created by mohamedharrouch on 23/01/2018.
 */
public enum Pawn {

  /**
   * Red Color.
   */
  RED("R"),

  /**
   * Yellow color.
   */
  YELLOW("J"),

  /**
   * Blue color.
   */
  BLUE("B"),

  /**
   * Orange color.
   */
  ORANGE("O"),

  /**
   * Green color.
   */
  GREEN("V"),

  /**
   * Black color.
   */
  BLACK("N");

  /**
   * Pawns readable color.
   */
  private final String readableColor;

  /**
   * Used for reverse-lookup.
   */
  private static final Map<String, Pawn> LOOKUP = new HashMap<>();

  static {
    for (Pawn pawn : Pawn.values()) {
      LOOKUP.put(pawn.getReadableColor(), pawn);
    }
  }

  /**
   * Private constructor.
   *
   * @param color readable color on display.
   */
  Pawn(final String color) {
    readableColor = color;
  }

  /**
   * Getter for readable color field.
   *
   * @return String.
   */
  public final String getReadableColor() {
    return readableColor;
  }

  /**
   * Return the pawn based on the readable color.
   *
   * @param color color.
   * @return The pawn if exists, null if any.
   */
  public static final Pawn getPawnByReadableColor(final String color) {
    return LOOKUP.get(color);
  }
}
