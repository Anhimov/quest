package ru.javarush.anhimov.quest.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.javarush.anhimov.quest.entity.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LogicServlet", value = "/logic")
public class LogicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession currentSession = req.getSession(true);

        String selectedButton = getSelectedButton(req, currentSession);

        Question currentQuestion = extractQuestion(currentSession);

        Question selectedQuestion = currentQuestion.getButtonsAndLinkedQuestions().get(selectedButton);

        currentSession.setAttribute("question", selectedQuestion);
        currentSession.setAttribute("buttons", selectedQuestion.getButtons());

        resp.sendRedirect("/index.jsp");
    }

    private String getSelectedButton(HttpServletRequest request, HttpSession currentSession) {
        Object buttonsAttribute = currentSession.getAttribute("buttons");
        if (ArrayList.class != buttonsAttribute.getClass()) {
            currentSession.invalidate();
            throw new RuntimeException("Session is broken, try one more time");
        }
        List<String> buttons = (List<String>) buttonsAttribute;

        String button = request.getParameter("button");
        boolean isNumeric = button.chars().allMatch(Character::isDigit);
        int i = isNumeric ? Integer.parseInt(button) : 0;
        return buttons.get(i);
    }

    private Question extractQuestion(HttpSession currentSession) {
        Object questionAttribute = currentSession.getAttribute("question");
        if (Question.class != questionAttribute.getClass()) {
            currentSession.invalidate();
            throw new RuntimeException("Session is broken, try one more time");
        }
        return (Question) questionAttribute;
    }
}
