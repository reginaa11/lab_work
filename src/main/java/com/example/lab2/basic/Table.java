package com.example.lab2.basic;

public class Table {
    private final int[][] data;
    private final int rows;
    private final int cols;

    public Table(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Размеры таблицы должны быть положительными");
        }
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }

    public int getValue(int row, int col) {
        checkIndices(row, col);
        return data[row][col];
    }

    public void setValue(int row, int col, int value) {
        checkIndices(row, col);
        data[row][col] = value;
    }

    public int rows() {
        return rows;
    }

    public int cols() {
        return cols;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(data[i][j]);
                if (j < cols - 1) {
                    sb.append("\t");
                }
            }
            if (i < rows - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public double average() {
        if (rows == 0 || cols == 0) {
            return 0.0;
        }

        int sum = 0;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += data[i][j];
                count++;
            }
        }
        return (double) sum / count;
    }

    private void checkIndices(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException(
                    String.format("Неверные индексы: [%d, %d]. Допустимый диапазон: [0-%d, 0-%d]",
                            row, col, rows-1, cols-1)
            );
        }
    }
}