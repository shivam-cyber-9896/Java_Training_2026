package com.shivam.monocept.facede.model1.board;


public class BoardFull {

    public boolean boardFull(Board board) {

        for (int[] row : board.getCells())
            for (int cell : row)
                if (cell == 0)
                    return false;

        return true;
    }
}