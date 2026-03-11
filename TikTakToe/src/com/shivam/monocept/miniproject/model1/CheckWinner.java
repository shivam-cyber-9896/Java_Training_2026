package com.shivam.monocept.miniproject.model1;

public class CheckWinner {

    public boolean checkWinner(Board board, User user) {

        int[][] c = board.getCells();
        int v = user.getValue();

        for (int i = 0; i < 3; i++) {

            if (c[i][0] == v && c[i][1] == v && c[i][2] == v)
                return true;

            if (c[0][i] == v && c[1][i] == v && c[2][i] == v)
                return true;
        }

        if (c[0][0] == v && c[1][1] == v && c[2][2] == v)
            return true;

        if (c[0][2] == v && c[1][1] == v && c[2][0] == v)
            return true;

        return false;
    }
}