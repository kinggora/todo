package com.ssg.w1.todo;

import com.ssg.w1.todo.dto.TodoDto;
import com.ssg.w1.todo.service.TodoService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Slf4j
@WebServlet(name = "todoRegisterController", urlPatterns = "/todo/register")
public class TodoRegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/todo/register.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        if(title == null || title.isBlank() || title.length() > 100) {
            log.error("제목은 빈 값이거나 100자를 초과할 수 없습니다.");
            return;
        }
        String dateString = request.getParameter("dueDate");
        LocalDate dueDate = null;
        try {
            dueDate = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
        } catch (DateTimeParseException e) {
            log.error("날짜 형식이 올바르지 않습니다.");
            return;
        }
        dueDate = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);

        TodoDto dto = new TodoDto();
        dto.setTitle(title);
        dto.setDueDate(dueDate);
        TodoService.INSTANCE.register(dto);
        response.sendRedirect("/todo/list");
    }
}
