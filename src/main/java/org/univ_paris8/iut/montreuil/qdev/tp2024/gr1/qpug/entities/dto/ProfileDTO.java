package org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.dto;

import java.util.List;
import java.util.Objects;

public class ProfileDTO {
    private String name;
    private String pseudo;
    private int birthYear;
    private String interests;
    private int languageChoice;
    private List<Object> playerStats;

    public ProfileDTO(String name, String pseudo, int birthYear, String interests, int languageChoice, List<Object> playerStats) {
        this.name = name;
        this.pseudo = pseudo;
        this.birthYear = birthYear;
        this.interests = interests;
        this.languageChoice = languageChoice;
        this.playerStats = playerStats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public int getLanguageChoice() {
        return languageChoice;
    }

    public void setLanguageChoice(int languageChoice) {
        this.languageChoice = languageChoice;
    }

    public List<Object> getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(List<Object> playerStats) {
        this.playerStats = playerStats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileDTO profile = (ProfileDTO) o;
        return birthYear == profile.birthYear && languageChoice == profile.languageChoice && name.equals(profile.name) && pseudo.equals(profile.pseudo) && interests.equals(profile.interests) && playerStats.equals(profile.playerStats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pseudo, birthYear, interests, languageChoice, playerStats);
    }
}
