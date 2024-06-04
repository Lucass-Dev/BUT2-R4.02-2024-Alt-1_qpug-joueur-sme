package org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions;

public class IllegalLangArgumentException extends Exception{
    public IllegalLangArgumentException(String s){
        super(IllegalLangArgumentException.class + " thrown because " + s + " is not an enum of LangEnum");
    }
}
