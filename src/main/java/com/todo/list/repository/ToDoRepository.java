package com.todo.list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.list.entity.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {

}
