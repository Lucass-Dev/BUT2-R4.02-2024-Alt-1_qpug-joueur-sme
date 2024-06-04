package org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions;

public class NonUniquePseudoException extends Exception{
    public NonUniquePseudoException(String s){
        super(NonUniquePseudoException.class + " thrown by " + s + " because it is already used");
    }
}
