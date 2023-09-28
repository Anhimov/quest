package ru.javarush.anhimov.quest.entities;

import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Map;

public interface Question {
    void addButtonsAndLinkedQuestions(Map<String, Question> ButtonsAndLinkedQuestions);

    void setQuestionText(String questionText);

    void setButtonsAndLinkedQuestions(Map<String, Question> buttonsAndLinkedQuestions);

    Long getQuestionId();

    String getQuestionText();

    Map<String, Question> getButtonsAndLinkedQuestions();

    List<String> getButtons();

    boolean checkWin();
}
