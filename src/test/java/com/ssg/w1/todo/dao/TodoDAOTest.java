package com.ssg.w1.todo.dao;

import com.ssg.w1.todo.domain.TodoVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.core.Local;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Slf4j
class TodoDAOTest {

    private TodoDAO dao = new TodoDAO();

    @Test
    void testInsert() throws SQLException {
        TodoVO vo = TodoVO.builder()
                .title("Sample Title....")
                .dueDate(LocalDate.of(2024, 9, 5))
                .finished(false)
                .build();
        dao.insert(vo);
    }

    @Test
    void testList() throws SQLException {
        List<TodoVO> list = dao.selectAllList();
        list.forEach(System.out::println);
    }

    @Test
    void testSelectOne() throws SQLException {
        TodoVO vo = dao.selectOne(1L);
        System.out.println(vo);
    }

    @Test
    void testUpdateOne() throws SQLException {
        TodoVO updateVO = TodoVO.builder()
                .tno(1L)
                .title("Update test....")
                .finished(true)
                .dueDate(LocalDate.of(2024, 12, 25))
                .build();
        dao.updateOne(updateVO);

        TodoVO findVO = dao.selectOne(updateVO.getTno());
        Assertions.assertEquals(updateVO.getTitle(), findVO.getTitle());
        Assertions.assertEquals(updateVO.getDueDate(), findVO.getDueDate());
        Assertions.assertEquals(updateVO.isFinished(), findVO.isFinished());
    }
}
