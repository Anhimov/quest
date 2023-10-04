package ru.javarush.anhimov.quest.controller;

import jakarta.servlet.RequestDispatcher;
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
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InitServletTest {
    private final static String questJSP = "/index.jsp";
    @Mock
    HttpSession session;
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    RequestDispatcher dispatcher;
    private InitServlet initServlet;

    @BeforeEach
    void setUp() {
        initServlet = new InitServlet();
    }

    @Test
    void doGet() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(questJSP)).thenReturn(dispatcher);

        initServlet.doGet(request, response);

        verify(request).getRequestDispatcher(questJSP);
    }

    @Test
    void doPost() throws ServletException, IOException {
        String[] strings = {"SomePlayerName"};
        Map<String, String[]> parameterMap = new HashMap<>();
        parameterMap.put("player_name", strings);

        when(request.getSession()).thenReturn(session);
        when(request.getParameterMap()).thenReturn(parameterMap);
        when(request.getRequestDispatcher("/index.jsp")).thenReturn(dispatcher);

        initServlet.doPost(request, response);

        verify(session).setAttribute("playerName", "SomePlayerName");
        verify(dispatcher).forward(request, response);
    }
}