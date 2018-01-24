package com.supermood.mastermind.core;

import com.supermood.mastermind.constant.Pawn;
import java.util.ArrayList;
import java.util.List;
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
    final RoundResult result = new RoundResult(original.getCombinationLength());
    final AtomicInteger index = new AtomicInteger(0);
    final List<Pawn> providedCopy = new ArrayList<>(provided.getCombinationSuite());
    final List<Pawn> originalCopy = new ArrayList<>(original.getCombinationSuite());
    providedCopy.removeIf(pawn -> {
      boolean found = false;
      if (pawn == originalCopy.get(index.get())) {
        result.incrementCorrectPosition();
        originalCopy.remove(index.get());
        index.getAndDecrement();
        found = true;
      }
      index.getAndIncrement();
      return found;
    });
    providedCopy.removeIf(pawn -> originalCopy.removeIf(pawn1 -> {
      boolean found = false;
      if (pawn == pawn1) {
        found = true;
        result.incrementCorrectColor();
      }
      return found;
    }));
    return result;
  }
}
