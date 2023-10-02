package ru.javarush.anhimov.quest.repository;


import ru.javarush.anhimov.quest.entities.Question;

import java.util.List;
import java.util.Map;

public interface QuestionRepository {
    Question getStartQuestion();

    void setWinnerQuestion(int winnerQuestion);

    public int getQuestionsSize();
}
