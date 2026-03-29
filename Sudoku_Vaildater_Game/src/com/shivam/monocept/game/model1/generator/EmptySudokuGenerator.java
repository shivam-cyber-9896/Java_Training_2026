package com.shivam.monocept.game.model1.generator;

import com.shivam.monocept.game.model1.board.Board;

public class EmptySudokuGenerator implements SudokuGenerator {

    @Override
    public void generate(Board board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (!board.isFixed(i, j)) { // safe check
                    board.clearCell(i, j);
                }
            }
        }
    }
}