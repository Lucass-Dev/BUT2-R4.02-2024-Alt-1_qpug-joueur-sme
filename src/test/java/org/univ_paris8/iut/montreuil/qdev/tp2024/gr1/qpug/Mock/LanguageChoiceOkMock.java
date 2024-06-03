package org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.Mock;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.dto.PlayerStatDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.dto.ProfileDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.enums.LangEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.services.interfaces.ServicePlayerInterface;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions.IllegalLangArgumentException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions.IllegalYearArgumentException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions.NonEmptyListException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions.NonUniquePseudoException;

import java.util.List;


public class LanguageChoiceOkMock implements ServicePlayerInterface {

  public ProfileDTO createNewProfile(String name, String pseudo, int birthYear, String interests, LangEnum langChoice, List<PlayerStatDTO> playerStats) throws IllegalLangArgumentException, IllegalYearArgumentException, NonUniquePseudoException, NonEmptyListException{
    return new ProfileDTO(name, pseudo, birthYear,  interests, langChoice, playerStats);
  }
}
