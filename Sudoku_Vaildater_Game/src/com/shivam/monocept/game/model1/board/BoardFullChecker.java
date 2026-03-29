package com.shivam.monocept.game.model1.board;

public class BoardFullChecker {

    private static final int SIZE = 9;

    public boolean isBoardFull(Board board) {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                if (board.getValue(i, j) == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}