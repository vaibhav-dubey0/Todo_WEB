package com.example.newtodoapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;

//@Controller
public class MyController {
   
    @Autowired
    private final TodoService td;

    private final Authenticate as;

    public MyController(Authenticate as, TodoService td) {
        this.as = as;
        this.td = td;
    }

   

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/submit-user")
    public String submitUser(@ModelAttribute("user") User user, Model model) {

        if (as.check(user.getUsername(), user.getEmail(), user.getPassword())) {
            model.addAttribute("user", user);
            return "submit";
        }
        model.addAttribute("errormsg", "You entered wrong details. Please enter proper details.");
        return "form";
    }

    

    @RequestMapping("/todolist")
    public String listTodo(ModelMap model) {
        String username= getLoggedinUsername(model);
        List<Todo> list = td.findByUserName(username);
        model.addAttribute("todos", list);
        return "todolist";
    }



    private String getLoggedinUsername(ModelMap model) {
        return (String) model.get("name");
    }

    @GetMapping("/addtodo")
    public String showAddTodoPage(Model model) {
        model.addAttribute("todo", new Todo());
        return "addtodo"; // Ensure this returns the correct JSP page name
    }

    @PostMapping("/submitdetail")
    public String NewlistTodo(ModelMap model, @ModelAttribute("todo") @Valid Todo todo, BindingResult result) {
        
        if (result.hasErrors()) {
            return "addtodo";
        }
    
        td.addTodo(todo);
        model.addAttribute("todos", td.getAllTodos());
        return "todolist";
    }
    
    
    //  @GetMapping("/delete")
    // public String deleteTodo(@RequestParam("id") int id) {
    //     this.td.deleteTodo(id);
    //     return "redirect:/todolist";
    // }

    @GetMapping("/delete")
    public String deleteTodo(@RequestParam("id") int id) {
        this.td.deleteTodoSl(id);
        return "delete";
    }

    // @RequestMapping(value = "update", method = RequestMethod.GET)
    // public String showUpdateForm(@RequestParam("id") int id, ModelMap model) {
    //     Todo todo = td.findById(id);
    //     model.addAttribute("todo", todo);
    //     return "todo"; // return the name of the JSP page for updating
    // }
    
    // @RequestMapping(value = "update", method = RequestMethod.POST)
    // public String updateTodo(ModelMap model, @ModelAttribute("todo") @Valid Todo todo, BindingResult result) {
    //     if (result.hasErrors()) {
    //         return "addtodo";
    //     }
    //     td.updateTodo(todo);
    //     model.addAttribute("todos", td.getAllTodos());
    //     return "redirect:todolistt";
    // }


    @RequestMapping(value="update", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = td.findById(id);
		model.addAttribute("todo", todo);
		return "todo";
	}

	 @RequestMapping(value="update", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}

		
		String username = (String)model.get("name");
		todo.setName(username);
		td.updateTodo(todo);
		return "redirect:todolist";
	}
    

    
}




