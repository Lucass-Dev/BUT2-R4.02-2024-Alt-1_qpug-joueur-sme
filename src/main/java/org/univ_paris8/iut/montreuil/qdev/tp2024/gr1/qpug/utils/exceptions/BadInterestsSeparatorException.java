package org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions;

public class BadInterestsSeparatorException extends Exception{
    public BadInterestsSeparatorException(String s){
        super(BadInterestsSeparatorException.class + " thrown by " + s + " because it hasn't rigth separator (',' or ';')");
    }
}
