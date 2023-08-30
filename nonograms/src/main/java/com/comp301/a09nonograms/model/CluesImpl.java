package com.comp301.a09nonograms.model;

import java.lang.reflect.Array;

public class CluesImpl implements Clues {
  private int height;
  private int width;
  private int[][] row;
  private int[][] column;

  public CluesImpl(int[][] rowClues, int[][] colClues) {
    if (rowClues == null || colClues == null) {
      throw new IllegalArgumentException();
    }
    this.height = rowClues.length;
    this.width = colClues.length;
    this.row = rowClues;
    this.column = colClues;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public int[] getRowClues(int index) {
    if (index < 0 || index > height) {
      throw new IllegalArgumentException();
    }
    return row[index];
  }

  @Override
  public int[] getColClues(int index) {
    if (index < 0 || index > width) {
      throw new IllegalArgumentException();
    }
    return column[index];
  }

  @Override
  public int getRowCluesLength() {
    return row[0].length;
  }

  @Override
  public int getColCluesLength() {
    return column[0].length;
  }
}
