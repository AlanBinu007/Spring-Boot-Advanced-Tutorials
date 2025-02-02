package com.todo.list.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String todoItem;
	private String 	completed;
	
	
	
}
