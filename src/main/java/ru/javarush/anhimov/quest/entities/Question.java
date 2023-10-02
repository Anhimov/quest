package ru.javarush.anhimov.quest.entities;

import java.util.List;
import java.util.Map;

public interface Question{
    void addButtonsAndLinkedQuestions(Map<String, Question> ButtonsAndLinkedQuestions);

    String getQuestionText();

    Map<String, Question> getButtonsAndLinkedQuestions();

    List<String> getButtons();

    boolean checkWin();

    void setWinner(boolean winner);
}
