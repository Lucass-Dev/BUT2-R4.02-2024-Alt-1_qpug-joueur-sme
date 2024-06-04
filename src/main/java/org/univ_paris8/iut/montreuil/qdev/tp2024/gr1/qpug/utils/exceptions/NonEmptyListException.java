package org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.dto.PlayerStatDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.dto.ProfileDTO;

import java.util.List;

public class NonEmptyListException extends Exception{
    public NonEmptyListException(List<PlayerStatDTO> list){
        super(NonEmptyListException.class + " thrown because " + list + " is not empty");
    }
}
