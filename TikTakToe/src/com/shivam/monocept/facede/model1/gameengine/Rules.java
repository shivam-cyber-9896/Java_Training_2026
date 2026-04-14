package com.shivam.monocept.facede.model1.gameengine;

public class Rules {
	 public static void showRules() {

	        System.out.println("========== TIC TAC TOE RULES ==========\n");

	        System.out.println("Game Board:");
	        System.out.println("The game is played on a 3 x 3 grid.");
	        System.out.println("Each cell can contain X, O, or remain empty.\n");

	        System.out.println("Basic Rules:");
	        System.out.println("1. Two symbols are used: X and O.");
	        System.out.println("2. Players take turns placing their symbol in an empty cell.");
	        System.out.println("3. A move is valid only if the selected cell is empty.");
	        System.out.println("4. A player wins if they place three of their symbols in:");
	        System.out.println("   - A horizontal row");
	        System.out.println("   - A vertical column");
	        System.out.println("   - A diagonal line\n");

	        System.out.println("If all 9 cells are filled and no player wins,");
	        System.out.println("the game ends in a DRAW.\n");

	        System.out.println("----- Player vs Player Mode -----");
	        System.out.println("1. Two human players play the game.");
	        System.out.println("2. Player 1 chooses either X or O.");
	        System.out.println("3. Player 2 gets the remaining symbol.");
	        System.out.println("4. Players take turns entering positions (1-9).\n");

	        System.out.println("----- Player vs Computer Mode -----");
	        System.out.println("1. One human player plays against the computer.");
	        System.out.println("2. The player chooses X or O.");
	        System.out.println("3. The computer automatically plays the other symbol.");
	        System.out.println("4. The computer selects its moves automatically.");
	        System.out.println("5. The game continues until someone wins or the board is full.\n");

	        System.out.println("=====================================");
	 }
}
