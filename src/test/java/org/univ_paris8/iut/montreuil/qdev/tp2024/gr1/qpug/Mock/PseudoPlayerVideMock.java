import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.dto.PlayerStatDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.dto.ProfileDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.enums.LangEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions.IllegalLangArgumentException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions.IllegalYearArgumentException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions.NonEmptyListException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions.NonUniquePseudoException;


public class PseudoPlayerVideMock implements ServicePlayerInterface {

  public PlayerDTO createNewProfile(String name, String pseudo, int birthYear, String interests, LangEnum langChoice, List<PlayerStatDTO> playerStats) throws IllegalLangArgumentException, IllegalYearArgumentException, NonUniquePseudoException, NonEmptyListException{
    throw new IllegalArgumentException("Pseudo vide");
  }
}
