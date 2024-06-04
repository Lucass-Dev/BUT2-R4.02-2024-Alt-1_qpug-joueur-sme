package org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.Mock;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.dto.PlayerStatDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.dto.ProfileDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.enums.LangEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.services.interfaces.ServicePlayerInterface;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions.*;

import java.util.List;


public class PseudoPlayerVideMock implements ServicePlayerInterface {

  public ProfileDTO createNewProfile(String name, String pseudo, int birthYear, String interests, String langChoice, List<PlayerStatDTO> playerStats) throws IllegalLangArgumentException, IllegalYearArgumentException, NonUniquePseudoException, NonEmptyListException, EmptyPseudoException {
    throw new EmptyPseudoException();
  }
}
