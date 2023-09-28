package ru.javarush.anhimov.quest.entities;

import jakarta.servlet.http.HttpSession;

import java.util.*;
import java.util.stream.Collectors;

public class QuestionImpl implements Question {
    private Long questionId;
    private String questionText;
    private Map<String, Question> ButtonsAndLinkedQuestions;
    private boolean isWinner;

    public QuestionImpl(Long questionId, String questionText) {
        this.questionId = questionId;
        this.questionText = questionText;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setButtonsAndLinkedQuestions(Map<String, Question> buttonsAndLinkedQuestions) {
        ButtonsAndLinkedQuestions = buttonsAndLinkedQuestions;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public Map<String, Question> addButtonsAndLinkedQuestions() {
        return ButtonsAndLinkedQuestions;
    }

    @Override
    public void addButtonsAndLinkedQuestions(Map<String, Question> ButtonsAndLinkedQuestions) {
        this.ButtonsAndLinkedQuestions = ButtonsAndLinkedQuestions;
    }

    public Map<String, Question> getButtonsAndLinkedQuestions() {
        return ButtonsAndLinkedQuestions;
    }

    public List<String> getButtons() {
        return this.getButtonsAndLinkedQuestions().entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public boolean checkWin() {
        return isWinner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionImpl question = (QuestionImpl) o;
        return Objects.equals(questionId, question.questionId) && Objects.equals(questionText, question.questionText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, questionText);
    }
}
