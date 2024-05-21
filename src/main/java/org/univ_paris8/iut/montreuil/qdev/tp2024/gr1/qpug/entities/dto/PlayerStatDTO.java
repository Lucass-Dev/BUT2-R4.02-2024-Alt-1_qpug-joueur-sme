package org.univ_paris8.iut.montreuil.qdev.tp2024.gr1.qpug.entities.dto;

import java.util.Objects;

public class PlayerStatDTO {
    private int questionCount;
    private int validAnswers;
    private int timeElapsed;

    public PlayerStatDTO(int questionCount, int validAnswers, int timeElapsed) {
        this.questionCount = questionCount;
        this.validAnswers = validAnswers;
        this.timeElapsed = timeElapsed;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    public int getValidAnswers() {
        return validAnswers;
    }

    public void setValidAnswers(int validAnswers) {
        this.validAnswers = validAnswers;
    }

    public int getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(int timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerStatDTO that = (PlayerStatDTO) o;
        return questionCount == that.questionCount && validAnswers == that.validAnswers && timeElapsed == that.timeElapsed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionCount, validAnswers, timeElapsed);
    }
}
