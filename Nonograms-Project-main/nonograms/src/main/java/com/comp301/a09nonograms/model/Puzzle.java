package com.comp301.a09nonograms.model;

public class Puzzle {
  private Clues clues;
  private Board board;

  public Puzzle(Clues clues) {
    if (clues == null) {
      throw new IllegalArgumentException();
    }
    this.clues = clues;
    this.board = new BoardImpl(clues.getHeight(), clues.getWidth());
  }

  public Board getBoard() {
    return board;
  }

  public Clues getClues() {
    return clues;
  }
}
