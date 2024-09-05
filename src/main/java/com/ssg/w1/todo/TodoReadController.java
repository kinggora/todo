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

@WebServlet(name = "todoReadController", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long tno = Long.parseLong(request.getParameter("tno"));
        TodoVO vo = TodoService.INSTANCE.get(tno);

        request.setAttribute("vo", vo);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/todo/read.jsp");
        requestDispatcher.forward(request, response);
    }

}
