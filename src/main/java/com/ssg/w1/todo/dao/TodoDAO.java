package com.ssg.w1.todo.dao;

import com.ssg.w1.todo.domain.TodoVO;
import com.ssg.w1.todo.dto.TodoDto;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TodoDAO {

    public void insert(TodoVO vo) {
        String sql = "INSERT INTO tbl_todo (tno, title, due_date, finished) values (null,?,?,?)";
        try {
            @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, vo.getTitle());
            pstmt.setDate(2, Date.valueOf(vo.getDueDate()));
            pstmt.setBoolean(3, vo.isFinished());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            log.error("TodoDAO.insert", e);
        }
    }

    public List<TodoVO> selectAllList() {
        String sql = "SELECT * FROM tbl_todo";
        List<TodoVO> list = new ArrayList<>();

        try {
            @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
            @Cleanup ResultSet rs = pstmt.executeQuery();


            while(rs != null && rs.next()) {
                TodoVO vo = TodoVO.builder()
                        .tno(rs.getLong("tno"))
                        .title(rs.getString("title"))
                        .finished(rs.getBoolean("finished"))
                        .dueDate(rs.getDate("due_date").toLocalDate())
                        .build();
                list.add(vo);
            }
        } catch (SQLException e) {
            log.error("TodoDAO.selectAllList", e);
        }
        return list;
    }

    public TodoVO selectOne(Long tno) {
        String sql = "SELECT * FROM tbl_todo WHERE tno=?";

        TodoVO vo = null;
        try {
            @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, tno);

            @Cleanup ResultSet rs = pstmt.executeQuery();

            if(rs != null && rs.next()) {
                vo = TodoVO.builder()
                        .tno(rs.getLong("tno"))
                        .title(rs.getString("title"))
                        .finished(rs.getBoolean("finished"))
                        .dueDate(rs.getDate("due_date").toLocalDate())
                        .build();
            }
        } catch (SQLException e) {
            log.error("TodoDAO.selectOne", e);
        }
        return vo;
    }

    public void deleteOne(Long tno) {
        String sql = "DELETE FROM tbl_todo WHERE tno=?";
        try {
            @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setLong(1, tno);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            log.error("TodoDAO.deleteOne", e);
        }
    }

    public void updateOne(TodoVO vo) {
        String sql = "UPDATE tbl_todo SET title=?, due_date=?, finished=? WHERE tno=?";
        try {
            @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
            @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, vo.getTitle());
            pstmt.setDate(2, Date.valueOf(vo.getDueDate()));
            pstmt.setBoolean(3, vo.isFinished());
            pstmt.setLong(4, vo.getTno());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            log.error("TodoDAO.updateOne", e);
        }
    }
}
