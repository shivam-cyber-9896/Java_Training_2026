package com.shivam.monocept.game.model1.input;

import com.shivam.monocept.game.model1.exception.InvaildSudokuException;

public class InputChecker {

    public boolean isValidNumber(int number) throws InvaildSudokuException {

        if(number>=1 && number<=9)
       return true;
        throw new InvaildSudokuException("Invaild Input"); 

    }
}