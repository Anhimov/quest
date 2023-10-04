package ru.javarush.anhimov.quest.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestartServletTest {
    @Mock
    HttpSession session;
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    private RestartServlet restartServlet;

    @BeforeEach
    void setUp() {
        restartServlet = new RestartServlet();
    }

    @Test
    void doGet() throws IOException {
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("gamesCount")).thenReturn(5);

        restartServlet.doGet(request, response);

        verify(session).setAttribute("gamesCount", 6);
        verify(response).sendRedirect("/start");
    }
}