package org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions;

public class EmptyPseudoException extends Exception{
    public EmptyPseudoException(){
        super(EmptyPseudoException.class + " thrown because pseudo is null or empty");
    }
}
