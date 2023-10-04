package ru.javarush.anhimov.quest.repository;


import ru.javarush.anhimov.quest.entity.Question;

public interface QuestionRepository {
    Question getStartQuestion();

    void setWinnerQuestion(int winnerQuestion);

    public int getQuestionsSize();
}
