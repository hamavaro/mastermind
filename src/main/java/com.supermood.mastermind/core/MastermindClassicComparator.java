package com.supermood.mastermind.core;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Classic implementation of the mastermind game.
 * Created by mohamedharrouch on 23/01/2018.
 */
public class MastermindClassicComparator implements MastermindComparator {

  @Override
  public final RoundResult compare(final Combination original, final Combination provided) {
    if (provided == null || original == null) {
      throw new IllegalArgumentException("Null combinations cannot be compared.");
    }
    if (provided.getCombinationLength() != original.getCombinationLength()) {
      throw new IllegalArgumentException("Combinations with different lengths cannot be compared.");
    }
    RoundResult result = new RoundResult(original.getCombinationLength());
    final AtomicInteger index = new AtomicInteger(0);
    provided.getCombinationSuite().stream().forEachOrdered(pawn -> {
      if (pawn == original.getCombinationSuite().get(index.get())) {
        result.incrementCorrectPosition();
      } else if (original.getCombinationSuite().contains(pawn)) {
        result.incrementCorrectColor();
      }
      index.getAndIncrement();
    });
    return result;
  }
}
