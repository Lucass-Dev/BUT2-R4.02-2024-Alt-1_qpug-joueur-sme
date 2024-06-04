package org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.services.impl;

import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.dto.PlayerStatDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.dto.ProfileDTO;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.enums.LangEnum;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.services.interfaces.ServicePlayerInterface;
import org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.utils.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class ServicePlayerInterfaceImpl implements ServicePlayerInterface {
    private static ServicePlayerInterfaceImpl instance;

    private List<ProfileDTO> listeProfiles;

    private ServicePlayerInterfaceImpl(){
        listeProfiles = new ArrayList<>();
    }

    @Override
    public ProfileDTO createNewProfile(String name, String pseudo, int birthYear, String interests, String langChoice, List<PlayerStatDTO> playerStats) throws IllegalLangArgumentException, IllegalYearArgumentException, NonUniquePseudoException, NonEmptyListException, EmptyInterestsException, BadInterestsSeparatorException, EmptyPseudoException {

        if (pseudo.isEmpty()){
            throw new EmptyPseudoException();
        }

        for (ProfileDTO p:
             getListeProfiles()) {
            if (pseudo.equals(p.getPseudo()))
                throw new NonUniquePseudoException(pseudo);
        }

        try{
            LangEnum.valueOf(langChoice);
        }catch (IllegalArgumentException e){
            throw new IllegalLangArgumentException(langChoice);
        }

        if (!playerStats.isEmpty()){
            throw new NonEmptyListException(playerStats);
        }

        if (birthYear < 1924 || birthYear > 2019){
            throw new IllegalYearArgumentException(birthYear);
        }

        if (interests.isEmpty()){
            throw new EmptyInterestsException();
        }

        if (interests.split(",").length  < 1 || interests.split(";").length < 1){
            throw new BadInterestsSeparatorException(interests);
        }
        ProfileDTO p = new ProfileDTO(name, pseudo, birthYear, interests, LangEnum.valueOf(langChoice), playerStats);
        this.listeProfiles.add(p);
        return p;
    }

    public static ServicePlayerInterfaceImpl getInstance() {
        if (instance == null){
            return new ServicePlayerInterfaceImpl();
        }else{
            return instance;
        }
    }

    public List<ProfileDTO> getListeProfiles() {
        return listeProfiles;
    }

    public void clearProfiles(){
        this.listeProfiles.clear();
    }
}