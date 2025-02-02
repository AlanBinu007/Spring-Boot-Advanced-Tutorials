package com.todo.list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todo.list.entity.ToDo;
import com.todo.list.repository.ToDoRepository;

//@RestController
@Controller
public class ToDoController {

	@Autowired
	private ToDoRepository toDoRepository;
	
	@GetMapping("")
	public String index() {
		return "index";
	}
	
	@GetMapping("/logout")
	public String logoutPage() {
		return "logout";
	}
	
	
	  @GetMapping("/todos")
	    public String todos(Model model){
	        model.addAttribute("todos", toDoRepository.findAll());
	        return "todos";
	    }
	
	
	
	@PostMapping("/todo")
	public String add(@RequestParam String todoItem,@RequestParam String  status,Model model) {
		
		ToDo toDo=new ToDo();
		toDo.setTodoItem(todoItem);
		toDo.setCompleted(status);
		toDoRepository.save(toDo);
		model.addAttribute("todos", toDoRepository.findAll());
		return "redirect:/todos";
		
	}
	  @PostMapping("/todoDelete/{id}")
	    public String delete(@PathVariable long id, Model model){
	       toDoRepository.deleteById(id);
	       model.addAttribute("todos", toDoRepository.findAll());

	        return "redirect:/todos";
	    }

	    @PostMapping("/todoUpdate/{id}")
	    public String update(@PathVariable long id, Model model){
	        ToDo toDo = toDoRepository.findById(id).get();
	        if("Yes".equals(toDo.getCompleted())){
	            toDo.setCompleted("No");
	        } else {
	            toDo.setCompleted("Yes");
	        }
	        toDoRepository.save(toDo);
	        model.addAttribute("todos", toDoRepository.findAll());
	        return "redirect:/todos";
	    }
	
	
	
}
