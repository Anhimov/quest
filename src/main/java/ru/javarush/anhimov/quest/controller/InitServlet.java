package ru.javarush.anhimov.quest.controller;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ru.javarush.anhimov.quest.entities.Question;
import ru.javarush.anhimov.quest.service.QuestionService;

@WebServlet(name = "initServlet", value = "/start")
public class InitServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // Создание новой сессии
        HttpSession currentSession = req.getSession(true);

        QuestionService questionService = new QuestionService();
        Question question = questionService.getStartQuestion();
        questionService.setWinnerQuestion();
        List<String> buttons = question.getButtons();

        //  Сохранение в сессию текущего вопроса квеста
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