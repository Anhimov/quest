package ru.javarush.anhimov.quest.repository;

import ru.javarush.anhimov.quest.entities.Question;

import java.util.List;
import java.util.Map;

public interface QuestionRepository {

    List<Question> getAllQuestions();

    Question getQuestionById(Long questionId);

    Question updateQuestionById(Long questionId, String questionText, Map<String, Question> buttonsAndLinkedQuestions);

    Question getStartQuestion();

    int getWinnerQuestion();

    void setWinnerQuestion(int winnerQuestion);

    public int getQuestionsSize();
}
