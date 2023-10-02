package ru.javarush.anhimov.quest.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "RestartServlet", value = "/restart")
public class RestartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession currentSession = req.getSession();
        Integer previousGamesCount = extractGamesCount(currentSession);
        Integer currentGamesCount = previousGamesCount + 1;
        currentSession.setAttribute("gamesCount", currentGamesCount);
        resp.sendRedirect("/start");
    }

    private Integer extractGamesCount(HttpSession currentSession) {
        Object gamesCountAttribute = currentSession.getAttribute("gamesCount");
        if (Integer.class != gamesCountAttribute.getClass()) {
            currentSession.invalidate();
            throw new RuntimeException("Session is broken, try one more time");
        }
        return (Integer) gamesCountAttribute;
    }
}
