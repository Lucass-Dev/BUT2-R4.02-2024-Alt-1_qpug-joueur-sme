package org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.services.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.dto.PlayerStatDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.dto.ProfileDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.enums.LangEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.services.interfaces.ServicePlayerInterface;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions.IllegalLangArgumentException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions.IllegalYearArgumentException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions.NonEmptyListException;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions.NonUniquePseudoException;

import java.util.ArrayList;
import java.util.List;

public class ServicePlayerInterfaceImpl implements ServicePlayerInterface {
    private static final ServicePlayerInterfaceImpl instance = new ServicePlayerInterfaceImpl();

    private List<ProfileDTO> listeProfiles;

    private ServicePlayerInterfaceImpl(){
        listeProfiles = new ArrayList<>();
    }

    @Override
    public ProfileDTO createNewProfile(String name, String pseudo, int birthYear, String interests, String langChoice, List<PlayerStatDTO> playerStats) throws IllegalLangArgumentException, IllegalYearArgumentException, NonUniquePseudoException, NonEmptyListException {
        for (ProfileDTO p:
             getListeProfiles()) {
            if (pseudo.equals(p.getPseudo()))
                throw new NonUniquePseudoException();
        }

        try{
            LangEnum.valueOf(langChoice);
        }catch (IllegalArgumentException e){
            throw new IllegalLangArgumentException();
        }

        if (!playerStats.isEmpty()){
            throw new NonEmptyListException();
        }

        if (birthYear < 1924 || birthYear > 2019){
            throw new IllegalYearArgumentException();
        }

        return new ProfileDTO(name, pseudo, birthYear, interests, LangEnum.valueOf(langChoice), playerStats);
    }

    public static ServicePlayerInterfaceImpl getInstance() {
        return instance;
    }

    public List<ProfileDTO> getListeProfiles() {
        return listeProfiles;
    }
}