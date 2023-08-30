package com.comp301.a09nonograms.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {
  private List<Puzzle> puzzles;
  private int puzzleIndex;
  private List<Clues> clues;
  private List<ModelObserver> modelObservers;

  public ModelImpl(List<Clues> clues) {
    if (clues == null) {
      throw new IllegalArgumentException();
    }
    this.puzzles = new ArrayList<>();
    this.puzzleIndex = 0;
    this.modelObservers = new ArrayList<>();
    for (Clues clue : clues) {
      puzzles.add(new Puzzle(clue));
    }
  }

  @Override
  public boolean isShaded(int row, int col) {
    return puzzles.get(puzzleIndex).getBoard().isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return puzzles.get(puzzleIndex).getBoard().isEliminated(row, col);
  }

  @Override
  public boolean isSpace(int row, int col) {
    return puzzles.get(puzzleIndex).getBoard().isSpace(row, col);
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    puzzles.get(puzzleIndex).getBoard().toggleCellShaded(row, col);
    notifyObservers();
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    puzzles.get(puzzleIndex).getBoard().toggleCellEliminated(row, col);
    notifyObservers();
  }

  @Override
  public void clear() {
    puzzles.get(puzzleIndex).getBoard().clear();
    notifyObservers();
  }

  @Override
  public int getWidth() {
    return puzzles.get(puzzleIndex).getClues().getWidth();
  }

  @Override
  public int getHeight() {
    return puzzles.get(puzzleIndex).getClues().getHeight();
  }

  @Override
  public int[] getRowClues(int index) {
    return puzzles.get(puzzleIndex).getClues().getRowClues(index);
  }

  @Override
  public int[] getColClues(int index) {
    return puzzles.get(puzzleIndex).getClues().getColClues(index);
  }

  @Override
  public int getRowCluesLength() {
    return puzzles.get(puzzleIndex).getClues().getRowCluesLength();
  }

  @Override
  public int getColCluesLength() {
    return puzzles.get(puzzleIndex).getClues().getColCluesLength();
  }

  @Override
  public int getPuzzleCount() {
    return puzzles.size();
  }

  @Override
  public int getPuzzleIndex() {
    return puzzleIndex;
  }

  @Override
  public void setPuzzleIndex(int index) {
    if (index < 0 || index > getPuzzleCount()) {
      throw new IllegalArgumentException();
    } else {
      this.puzzleIndex = index;
      notifyObservers();
    }
  }

  @Override
  public void addObserver(ModelObserver observer) {
    if (observer == null) {
      throw new IllegalArgumentException();
    } else {
      this.modelObservers.add(observer);
    }
  }

  @Override
  public void removeObserver(ModelObserver observer) {
    if (observer == null) {
      throw new IllegalArgumentException();
    } else {
      this.modelObservers.remove(observer);
    }
  }

  @Override
  public boolean isSolved() {
    boolean rowSumSolved = true;
    boolean rowSpaceSolved = true;
    boolean columnSumSolved = true;
    boolean columnSpaceSolved = true;
    Board board = puzzles.get(puzzleIndex).getBoard();
    Clues clues = puzzles.get(puzzleIndex).getClues();
    int rowSum = 0;
    int rowShadeSum = 0;
    int columnSum = 0;
    int columnShadeSum = 0;
    for (int i = 0; i < clues.getHeight(); i++) {
      int[] row = clues.getRowClues(i);
      int expectedSpace = -1;
      for (int x : row) {
        rowSum += x;
        if (x != 0) {
          expectedSpace += 1;
        }
      }
      if (expectedSpace == -1) {
        expectedSpace = 0;
      }
      boolean firstShaded = false;
      int spaces = 0;
      for (int j = 0; j < clues.getWidth(); j++) {
        if (firstShaded) {
          if (board.isShaded(i, j) && !board.isShaded(i, j - 1)) {
            spaces += 1;
          }
        }
        if (board.isShaded(i, j)) {
          rowShadeSum += 1;
          firstShaded = true;
        }
        if (j == clues.getWidth() - 1 && spaces != expectedSpace) {
          rowSpaceSolved = false;
        }
      }
    }
    for (int i = 0; i < clues.getWidth(); i++) {
      int[] col = clues.getColClues(i);
      int expectedSpaces = -1;
      for (int x : col) {
        columnSum += x;
        if (x != 0) {
          expectedSpaces += 1;
        }
      }
      if (expectedSpaces == -1) {
        expectedSpaces = 0;
      }
      boolean firstShaded = false;
      int spaces = 0;
      for (int j = 0; j < clues.getHeight(); j++) {
        if (firstShaded) {
          if (board.isShaded(j, i) && !board.isShaded(j - 1, i)) {
            spaces += 1;
          }
        }
        if (board.isShaded(j, i)) {
          columnShadeSum += 1;
          firstShaded = true;
        }
        if (j == clues.getHeight() - 1 && spaces != expectedSpaces) {
          columnSpaceSolved = false;
        }
      }
    }
    if (rowSum != rowShadeSum) {
      rowSumSolved = false;
    }
    if (columnSum != columnShadeSum) {
      columnSumSolved = false;
    }
    return rowSumSolved && columnSumSolved && rowSpaceSolved && columnSpaceSolved;
  }

  private void notifyObservers() {
    for (ModelObserver o : modelObservers) {
      o.update(this);
    }
  }

  public Puzzle getPuzzle() {
    return this.puzzles.get(puzzleIndex);
  }
}
