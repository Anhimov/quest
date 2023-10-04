package ru.javarush.anhimov.quest.service;


import ru.javarush.anhimov.quest.entity.Question;
import ru.javarush.anhimov.quest.repository.QuestionRepository;
import ru.javarush.anhimov.quest.repository.QuestionRepositoryImpl;

public class QuestionService {
    QuestionRepository questionRepository = new QuestionRepositoryImpl();

    public Question getStartQuestion() {
        return questionRepository.getStartQuestion();
    }

    public void setWinnerQuestion() {
        int questionsSize = questionRepository.getQuestionsSize();
        questionRepository.setWinnerQuestion(questionsSize - 1);
    }
}
