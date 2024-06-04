package org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions;

public class EmptyNameException extends Exception{

    public EmptyNameException(){
        super(EmptyNameException.class + " thrown because name is null or empty");
    }
}

