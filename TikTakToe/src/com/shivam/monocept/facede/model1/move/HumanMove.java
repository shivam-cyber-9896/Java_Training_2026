package com.shivam.monocept.facede.model1.move;



import java.util.Scanner;

import com.shivam.monocept.facede.model1.board.Board;
import com.shivam.monocept.facede.model1.exception.InvalidInputException;

public   class HumanMove implements MoveStrategy {

    private final Scanner scanner;

    public HumanMove(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int makeMove(Board board) {

        System.out.print("Enter position (1-9): ");
        String input = scanner.nextLine();

        while (!input.matches("^[1-9]$")) {
            System.out.print("Invalid! Enter 1-9: ");
            input = scanner.nextLine();
        }
        int inputValue=Integer.parseInt(input);
         if(inputValue<=0||inputValue>9)
        	 throw new InvalidInputException("Invalid input! Enter number 1-9");
       
         return inputValue;
    }
}