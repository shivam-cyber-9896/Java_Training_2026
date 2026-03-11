package com.shivam.monocept.miniproject.model1;

import java.util.Random;

public class AiMove {

	    public int makeMove(Board board, PlayerMove mover, User computer, User player) {

	        int[][] cells = board.getCells();

	        // 1️⃣ Try to win
	        int winMove = findWinningMove(board, computer);
	        if (winMove != -1) {
	            mover.playerMove(board, winMove, computer);
	            return winMove;
	        }

	        // 2️⃣ Block player win
	        int blockMove = findWinningMove(board, player);
	        if (blockMove != -1) {
	            mover.playerMove(board, blockMove, computer);
	            return blockMove;
	        }

	        // 3️⃣ Take center
	        if (cells[1][1] == 0) {
	            mover.playerMove(board, 5, computer);
	            return 5;
	        }

	        // 4️⃣ Take corners
	        int[] corners = {1, 3, 7, 9};
	        for (int pos : corners) {
	            int r = (pos - 1) / 3;
	            int c = (pos - 1) % 3;

	            if (cells[r][c] == 0) {
	                mover.playerMove(board, pos, computer);
	                return pos;
	            }
	        }

	        // 5️⃣ Take any empty space
	        for (int pos = 1; pos <= 9; pos++) {
	            int r = (pos - 1) / 3;
	            int c = (pos - 1) % 3;

	            if (cells[r][c] == 0) {
	                mover.playerMove(board, pos, computer);
	                return pos;
	            }
	        }

	        return -1;
	    }


	    private int findWinningMove(Board board, User user) {

	        int[][] cells = board.getCells();
	        int symbol = user.getValue();

	        for (int pos = 1; pos <= 9; pos++) {

	            int r = (pos - 1) / 3;
	            int c = (pos - 1) % 3;

	            if (cells[r][c] == 0) {

	                cells[r][c] = symbol;

	                CheckWinner check = new CheckWinner();
	                if (check.checkWinner(board, user)) {
	                    cells[r][c] = 0;
	                    return pos;
	                }

	                cells[r][c] = 0;
	            }
	        }

	        return -1;
	    }
	
	//private Random random = new Random();

    //public int makeMove(Board board, PlayerMove mover, User computer) {

        //int pos;

        //while (true) {

          //  pos = random.nextInt(9) + 1;

          //  if (mover.playerMove(board, pos, computer))
                //return pos;
       // }
   // }

}
