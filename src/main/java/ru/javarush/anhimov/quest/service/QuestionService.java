package ru.javarush.anhimov.quest.service;

import ru.javarush.anhimov.quest.entities.Question;
import ru.javarush.anhimov.quest.repository.QuestionRepository;
import ru.javarush.anhimov.quest.repository.QuestionRepositoryImpl;

import java.util.List;
import java.util.Map;

public class QuestionService {
    QuestionRepository questionRepository = new QuestionRepositoryImpl();

    public List<Question> getAllQuestions() {
        return questionRepository.getAllQuestions();
    }

    public Question getQuestionById(Long questionId) {
        return questionRepository.getQuestionById(questionId);
    }

    public Question getStartQuestion() {
        return questionRepository.getStartQuestion();
    }

    public void setWinnerQuestion() {
        int questionsSize = questionRepository.getQuestionsSize();
        questionRepository.setWinnerQuestion(questionsSize);
    }

    public Question updateQuestionById(Long questionId, String questionText, Map<String, Question> buttonsAndLinkedQuestions) {
        questionRepository.updateQuestionById(questionId, questionText, buttonsAndLinkedQuestions);
        return questionRepository.getQuestionById(questionId);
    }
}
