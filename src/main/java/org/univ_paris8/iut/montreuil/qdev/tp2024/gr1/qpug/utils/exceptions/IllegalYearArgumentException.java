package org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions;

public class IllegalYearArgumentException extends Exception{
    public IllegalYearArgumentException(int i){
        super(IllegalYearArgumentException.class + " thrown because " + i + " must be between 1924 and 2019");
    }
}
