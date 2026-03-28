package com.shivam.monocept.game.model1.controller;

public class Rules {
 static void showRules() {
	 
	 System.out.println("====== SUDOKU RULES ======\n");
	 System.out.println("1. The Sudoku grid is 9 x 9.");
     System.out.println("2. It is divided into 9 smaller 3 x 3 boxes.\n");

     System.out.println("3. You must fill numbers from 1 to 9 only.\n");

     System.out.println("4. Each number must appear only once in:");
     System.out.println("   - Each Row");
     System.out.println("   - Each Column");
     System.out.println("   - Each 3 x 3 Box\n");

     System.out.println("5. Pre-filled numbers cannot be changed.\n");

     System.out.println("6. Use logic to fill the empty cells.\n");

     System.out.println("7. Goal: Complete the grid correctly.\n");

   
     System.out.println("====== GAME MODES ======\n");

     System.out.println("1. EMPTY MODE:");
     System.out.println("   - Provides a blank 9 x 9 board.");
     System.out.println("   - User fills all values manually.\n");

     System.out.println("2. COMPUTER FILLED MODE:");
     System.out.println("   - Some cells are already filled.");
     System.out.println("   - Complete the remaining cells.\n");

     System.out.println("==========================\n");
}
}