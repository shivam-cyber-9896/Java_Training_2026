package com.shivam.monocept.game.model1.input;

import com.shivam.monocept.game.model1.exception.InvaildSudokuExcption;

public class InputChecker {

    public boolean isValidNumber(int number) throws InvaildSudokuExcption {

        if(number>=1 && number<=9)
       return true;
        throw new InvaildSudokuExcption("Invaild Input"); 

    }
}