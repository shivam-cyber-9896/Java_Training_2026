package com.shivam.monocept.miniproject.model1;

public class PlayerMove {

    public boolean playerMove(Board board, int position, User user) {

        if (position < 1 || position > 9)
            return false;

        int[][] cells = board.getCells();

        int row = (position - 1) / 3;
        int col = (position - 1) % 3;

        if (cells[row][col] != 0)
            return false;

        cells[row][col] = user.getValue();
        return true;
    }

	
}