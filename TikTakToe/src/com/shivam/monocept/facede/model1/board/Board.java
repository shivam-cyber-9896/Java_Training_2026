package com.shivam.monocept.facede.model1.board;


public class Board {
	private final int size=3;

    private final int[][] cells = new int[size][size];

    public int[][] getCells() {
        return cells;
    }
}