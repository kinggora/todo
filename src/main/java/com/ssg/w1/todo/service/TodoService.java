package com.ssg.w1.todo.service;
import com.ssg.w1.todo.dao.TodoDAO;
import com.ssg.w1.todo.domain.TodoVO;
import com.ssg.w1.todo.dto.TodoDto;

import java.util.List;

public enum TodoService {

    INSTANCE;

    private final TodoDAO dao = new TodoDAO();

    public void register(TodoDto dto) {
        TodoVO vo = TodoVO.builder()
                .title(dto.getTitle())
                .dueDate(dto.getDueDate())
                .finished(false)
                .build();
        dao.insert(vo);
    }

    public List<TodoVO> getList() {
        return dao.selectAllList();
    }

    public TodoVO get(Long tno) {
        return dao.selectOne(tno);
    }

    public void delete(Long tno) {
        dao.deleteOne(tno);
    }

    public void update(TodoDto dto) {
        TodoVO vo = TodoVO.builder()
                .tno(dto.getTno())
                .title(dto.getTitle())
                .dueDate(dto.getDueDate())
                .finished(dto.isFinished())
                .build();
        dao.updateOne(vo);
    }

}

