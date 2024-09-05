package com.ssg.w1.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoDto {

    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

}
