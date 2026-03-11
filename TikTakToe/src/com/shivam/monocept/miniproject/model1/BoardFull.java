package com.shivam.monocept.miniproject.model1;

public class BoardFull {

    public boolean boardFull(Board board) {

        int[][] cells = board.getCells();

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (cells[i][j] == 0)
                    return false;

        return true;
    }
}
