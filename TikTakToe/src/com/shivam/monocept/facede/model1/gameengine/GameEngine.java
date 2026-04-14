package com.shivam.monocept.facede.model1.gameengine;


import java.util.Scanner;

import com.shivam.monocept.facede.model1.board.Board;
import com.shivam.monocept.facede.model1.board.BoardFull;
import com.shivam.monocept.facede.model1.board.BoardPrint;
import com.shivam.monocept.facede.model1.checker.CheckWinner;
import com.shivam.monocept.facede.model1.checker.PlayerMove;
import com.shivam.monocept.facede.model1.exception.InvalidInputException;
import com.shivam.monocept.facede.model1.exception.InvalidMoveException;
import com.shivam.monocept.facede.model1.move.AiMoveStrategy;
import com.shivam.monocept.facede.model1.move.HumanMove;
import com.shivam.monocept.facede.model1.move.MoveStrategy;
import com.shivam.monocept.facede.model1.move.User;

public class GameEngine {

    private final Board board = new Board();
    private final BoardPrint printer = new BoardPrint();
    private final PlayerMove mover = new PlayerMove();
    private final CheckWinner winner = new CheckWinner();
    private final BoardFull full = new BoardFull();

    private MoveStrategy playerStrategy;
    private MoveStrategy computerStrategy;

    private final Scanner scanner = new Scanner(System.in);

    public void start() {

        int mode = chooseMode();
        User player = chooseSymbol();
        User opponent = player.next();

        if (mode == 1) {
            playerStrategy = new HumanMove(scanner);
            computerStrategy = new AiMoveStrategy(opponent, player);
        } else {
            playerStrategy = new HumanMove(scanner);
            computerStrategy = new HumanMove(scanner);
        }

        runGame(player, opponent);
    }

    private int chooseMode() {
        System.out.println("1 → Player vs AI");
        System.out.println("2 → Player vs Player");
             
        String input = scanner.nextLine();

        while (!input.matches("^[12]$")) {
            System.out.print("Enter 1 or 2: ");
            input = scanner.nextLine();
        }

        return Integer.parseInt(input);
    }

    private User chooseSymbol() {
        System.out.println("1 → X");
        System.out.println("2 → O");

        String input = scanner.nextLine();

        while (!input.matches("^[12]$")) {
            System.out.print("Enter 1 or 2: ");
            input = scanner.nextLine();
        }

        return input.equals("1") ? User.PLAYER_X : User.PLAYER_O;
    }

    private void runGame(User player, User opponent) {

        User current = player;

        while (true) {

            printer.printBoard(board);
               try {
            int pos;

            if (current == player) {
                pos = playerStrategy.makeMove(board);
            } else {
                System.out.println("Computer thinking...");
                pos = computerStrategy.makeMove(board);
            }

            if (!mover.playerMove(board, pos, current)) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            if (winner.checkWinner(board, current)) {
                printer.printBoard(board);
                System.out.println("winner winner chicken Dinner" + current + " Wins!");
                break;
            }

            if (full.boardFull(board)) {
                printer.printBoard(board);
                System.out.println("Draw!");
                break;
            }

            current = current.next();
               }
               catch (InvalidInputException | InvalidMoveException e) {
                   System.out.println("Exception " + e.getMessage());
               } catch (Exception e) {
                   System.out.println("Unexpected error: " + e.getMessage());
               }
        }
    }
}