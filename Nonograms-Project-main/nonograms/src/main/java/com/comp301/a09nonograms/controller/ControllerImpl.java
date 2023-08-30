package com.comp301.a09nonograms.controller;

import com.comp301.a09nonograms.model.Clues;
import com.comp301.a09nonograms.model.Model;
import com.comp301.a09nonograms.model.ModelImpl;

import java.util.concurrent.ThreadLocalRandom;

public class ControllerImpl implements Controller {
  private Model model;

  public ControllerImpl(Model model) {
    if (model == null) {
      throw new IllegalArgumentException();
    } else {
      this.model = model;
    }
  }

  @Override
  public Clues getClues() {
    return ((ModelImpl) model).getPuzzle().getClues();
  }

  @Override
  public boolean isSolved() {
    return model.isSolved();
  }

  @Override
  public boolean isShaded(int row, int col) {
    return model.isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return model.isEliminated(row, col);
  }

  @Override
  public void toggleShaded(int row, int col) {
    model.toggleCellShaded(row, col);
  }

  @Override
  public void toggleEliminated(int row, int col) {
    model.toggleCellEliminated(row, col);
  }

  @Override
  public void nextPuzzle() {
    int currentPuzzle = model.getPuzzleIndex();
    if (currentPuzzle == model.getPuzzleCount() - 1) {
      model.setPuzzleIndex(0);
    } else {
      model.setPuzzleIndex(currentPuzzle + 1);
    }
  }

  @Override
  public void prevPuzzle() {
    int currentPuzzle = model.getPuzzleIndex();
    if (currentPuzzle == 0) {
      model.setPuzzleIndex(model.getPuzzleCount() - 1);
    } else {
      model.setPuzzleIndex(currentPuzzle - 1);
    }
  }

  @Override
  public void randPuzzle() {
    int currentPuzzle = model.getPuzzleIndex();
    int random = ThreadLocalRandom.current().nextInt(0, getPuzzleCount());
    while (currentPuzzle == random) {
      random = ThreadLocalRandom.current().nextInt(0, getPuzzleCount());
    }
    model.setPuzzleIndex(random);
  }

  @Override
  public void clearBoard() {
    model.clear();
  }

  @Override
  public int getPuzzleIndex() {
    return model.getPuzzleIndex();
  }

  @Override
  public int getPuzzleCount() {
    return model.getPuzzleCount();
  }
}
