package com.shivam.monocept.game.model1.vaildator;

import com.shivam.monocept.game.model1.board.Board;

public class RowValidator implements Validator {

    private static final int SIZE = 9;

    @Override
    public boolean isValid(Board board, int row, int col, int number) {

        for (int i = 0; i < SIZE; i++) {

            if (board.getValue(row, i) == number) {
                return false;
            }
        }

        return true;
    }
}