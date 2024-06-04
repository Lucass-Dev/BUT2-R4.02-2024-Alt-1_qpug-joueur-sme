package org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.services.interfaces;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.dto.PlayerStatDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.dto.ProfileDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.enums.LangEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions.*;

import java.util.List;

public interface ServicePlayerInterface {

    ProfileDTO createNewProfile(String name, String pseudo, int birthYear, String interests, String langChoice, List<PlayerStatDTO> playerStats) throws IllegalLangArgumentException, IllegalYearArgumentException, NonUniquePseudoException, NonEmptyListException, EmptyInterestsException, BadInterestsSeparatorException, EmptyPseudoException;


}
