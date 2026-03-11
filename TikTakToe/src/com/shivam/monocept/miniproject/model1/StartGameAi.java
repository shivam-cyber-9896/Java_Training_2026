package com.shivam.monocept.miniproject.model1;

import java.util.Random;
import java.util.Scanner;

public class StartGameAi {
	public void start() {

		Board board = new Board();
		BoardPrint printer = new BoardPrint();
		PlayerMove mover = new PlayerMove();
		CheckWinner winner = new CheckWinner();
		BoardFull full = new BoardFull();
		AiMove ai = new AiMove();   // ⭐ AI class

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

			User player = User.PLAYER_X;
			User computer = User.PLAYER_O;

			if (choice == 2) {
				player = User.PLAYER_O;
				computer = User.PLAYER_X;
			}

			User current = player;

			while (true) {

				printer.printBoard(board);

				int pos;

				if (current == player) {

					System.out.print("Player " + current + " choose position (1-9): ");
					String input = scanner.nextLine();

					while (input == null || !input.matches("^[1-9]$")) {
						System.out.print("Enter a valid digit (1-9): ");
						input = scanner.nextLine();
					}

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

				} else {

					System.out.println("Computer is making a move...");
					pos = ai.makeMove(board, mover, computer, current);
					System.out.println("Computer chose position: " + pos);
				}

				if (winner.checkWinner(board, current)) {
					printer.printBoard(board);
					System.out.println("🎉 " + current + " Wins!");
					break;
				}

				if (full.boardFull(board)) {
					printer.printBoard(board);
					System.out.println("It's a Draw!");
					break;
				}

				if (current == player)
					current = computer;
				else
					current = player;
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
