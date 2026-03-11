package com.shivam.monocept.miniproject.model1;

import java.util.Scanner;

public class StartGame {

	public void start() {

		Board board = new Board();
		BoardPrint printer = new BoardPrint();
		PlayerMove mover = new PlayerMove();
		CheckWinner winner = new CheckWinner();
		BoardFull full = new BoardFull();

		Scanner scanner = new Scanner(System.in);

		try {

			int choice;
			System.out.println("Choose your symbol:");
			System.out.println("1 → X");
			System.out.println("2 → O");

			String choiceIn = scanner.nextLine();

			while (choiceIn == null || choiceIn.trim().isEmpty() 
					|| !choiceIn.trim().matches("^[12]$")) {

				System.out.println("Invalid choice! Please select 1 or 2.");
				choiceIn = scanner.nextLine();
			}

			try {
				choice = Integer.parseInt(choiceIn);
			} catch (NumberFormatException e) {
				System.out.println("Invalid number format. Defaulting to X.");
				choice = 1;
			}

			User player1 = User.PLAYER_O;
			User player2 = User.PLAYER_X;

			if (choice == 1) {
				player1 = User.PLAYER_X;
				player2 = User.PLAYER_O;
			}

			User current = player1;

			while (true) {

				printer.printBoard(board);

				System.out.print("Player " + current + " choose position (1-9): ");
				String input = scanner.nextLine();

				while (input == null || !input.matches("^[1-9]$")) {
					System.out.print("Enter a valid digit (1-9): ");
					input = scanner.nextLine();
				}

				int pos;
				try {
					pos = Integer.parseInt(input);
				} catch (NumberFormatException e) {
					System.out.println("Invalid position format!");
					continue;
				}

				if (!mover.playerMove(board, pos, current)) {
					System.out.println("Position already taken!");
					continue;
				}

				if (winner.checkWinner(board, current)) {
					printer.printBoard(board);
					System.out.println("🎉 Player " + current + " Wins!");
					break;
				}

				if (full.boardFull(board)) {
					printer.printBoard(board);
					System.out.println("It's a Draw!");
					break;
				}

				if (current == player1)
					current = player2;
				else
					current = player1;
			}

		} 
		catch (Exception e) {
			System.out.println("Unexpected error occurred: " + e.getMessage());
		} 
		finally {
			scanner.close();
			System.out.println("Game Closed Safely.");
		}
	}
}