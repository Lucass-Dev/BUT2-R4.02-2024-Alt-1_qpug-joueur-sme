package org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions;

public class EmptyInterestsException extends Exception{

    public EmptyInterestsException(){
        super(EmptyInterestsException.class + " thrown because interests is null or empty.");
    }
}
