package com.ssg.w1.todo;

import com.ssg.w1.todo.domain.TodoVO;
import com.ssg.w1.todo.dto.TodoDto;
import com.ssg.w1.todo.service.TodoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "todoModifyController", urlPatterns = "/todo/modify")
public class TodoModifyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long tno = Long.parseLong(request.getParameter("tno"));
        TodoVO vo = TodoService.INSTANCE.get(tno);
        request.setAttribute("vo", vo);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/todo/modify.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TodoDto dto = new TodoDto();
        dto.setTno(Long.parseLong(request.getParameter("tno")));
        dto.setTitle(request.getParameter("title"));
        dto.setDueDate(LocalDate.parse(request.getParameter("dueDate"), DateTimeFormatter.ISO_DATE));
        String finished = request.getParameter("finished");
        dto.setFinished(finished != null && finished.equals("on"));
        TodoService.INSTANCE.update(dto);
        response.sendRedirect("/todo/read?tno=" + dto.getTno());
    }
}
