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
import ru.javarush.anhimov.quest.entity.Question;
import ru.javarush.anhimov.quest.repository.QuestionRepositoryImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LogicServletTest {
    private final static String questJSP = "/index.jsp";
    @Mock
    HttpSession session;
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    RequestDispatcher dispatcher;
    @Mock
    Question question;
    private LogicServlet logicServlet;
    private QuestionRepositoryImpl questionRepository;
    private ArrayList<String> buttons;

    @BeforeEach
    void setUp() {
        logicServlet = new LogicServlet();
        questionRepository = new QuestionRepositoryImpl();
        buttons = new ArrayList<>(Arrays.asList("в гостиную", "в ванную", "в туалет", "на улицу"));
    }

    @Test
    void doGet() throws ServletException, IOException {
        when(request.getSession(true)).thenReturn(session);
        when(session.getAttribute("buttons")).thenReturn(buttons);
        when(request.getParameter("button")).thenReturn("1");
        when(session.getAttribute("question")).thenReturn(questionRepository.getStartQuestion());
        logicServlet.doGet(request, response);

        verify(response).sendRedirect(questJSP);
    }
}