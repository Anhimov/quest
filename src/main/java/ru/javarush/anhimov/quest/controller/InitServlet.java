package ru.javarush.anhimov.quest.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.javarush.anhimov.quest.entities.Question;
import ru.javarush.anhimov.quest.service.QuestionService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "initServlet", value = "/start")
public class InitServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // Создание новой сессии
        HttpSession currentSession = req.getSession();

        QuestionService questionService = new QuestionService();
        Question question = questionService.getStartQuestion();
        questionService.setWinnerQuestion();
        List<String> buttons = question.getButtons();

        //  Сохранение в сессию текущего вопроса квеста
        if (currentSession.isNew()) {
            currentSession.setAttribute("gamesCount", 0);
        }
        currentSession.setAttribute("question", question);
        currentSession.setAttribute("buttons", buttons);
        currentSession.setAttribute("questionService", questionService);

        // Перенаправление запроса на страницу index.jsp через сервер
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String playerName = req.getParameterMap().get("player_name")[0];

        if (playerName != null) {
            HttpSession currentSession = req.getSession();
            currentSession.setAttribute("playerName", playerName);
        }

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}