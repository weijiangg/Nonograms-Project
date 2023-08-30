package com.comp301.a09nonograms.model;

public class BoardImpl implements Board {
  private int height;
  private int width;
  private int[][] board;

  public BoardImpl(int height, int width) {
    if (height < 0 || width < 0) {
      throw new IllegalArgumentException();
    } else {
      this.height = height;
      this.width = width;
      this.board = new int[height][width];
    }
  }

  @Override
  public boolean isShaded(int row, int col) {
    if (row < 0 || row > height || col < 0 || col > width) {
      throw new IllegalArgumentException();
    } else if (board[row][col] == 1) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean isEliminated(int row, int col) {
    if (row < 0 || row > height || col < 0 || col > width) {
      throw new IllegalArgumentException();
    } else if (board[row][col] == 2) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean isSpace(int row, int col) {
    if (row < 0 || row > height || col < 0 || col > width) {
      throw new IllegalArgumentException();
    } else if (board[row][col] == 0) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    if (row < 0 || row > height || col < 0 || col > width) {
      throw new IllegalArgumentException();
    } else if (isShaded(row, col)) {
      board[row][col] = 0;
    } else {
      board[row][col] = 1;
    }
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    if (row < 0 || row > height || col < 0 || col > width) {
      throw new IllegalArgumentException();
    } else if (isEliminated(row, col)) {
      board[row][col] = 0;
    } else {
      board[row][col] = 2;
    }
  }

  @Override
  public void clear() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        board[i][j] = 0;
      }
    }
  }
}
