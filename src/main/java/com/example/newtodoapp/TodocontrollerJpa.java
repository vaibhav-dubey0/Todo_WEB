package com.example.newtodoapp;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodocontrollerJpa {

    private final Authenticate as;
    private final Todorepo todorepo;

    public TodocontrollerJpa(Authenticate as, Todorepo todorepo) {
        this.as = as;
        this.todorepo = todorepo;
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/form")
    public String showForm(ModelMap model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/submit-user")
    public String submitUser(@ModelAttribute("user") User user, ModelMap model) {
        if (as.check(user.getUsername(), user.getEmail(), user.getPassword())) {
            model.addAttribute("user", user);
            return "submit";
        }
        model.addAttribute("errormsg", "You entered wrong details. Please enter proper details.");
        return "form";
    }

    @RequestMapping("/todolist")
    public String listTodo(ModelMap model) {
        String username = getLoggedinUsername(model);
        List<Todo> list = todorepo.findByName(username);
        model.addAttribute("todos", list);
        return "todolist";
    }

    @GetMapping("/addtodo")
    public String showAddTodoPage(ModelMap model) {
        model.addAttribute("todo", new Todo());
        return "addtodo";
    }

    @PostMapping("/addtodo")
    public String addTodo(ModelMap model, @ModelAttribute("todo") @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "addtodo";
        }
        String username = getLoggedinUsername(model);
        todo.setName(username);
        todorepo.save(todo);
        return "redirect:/todolist"; // Corrected the redirect URL
    }

    @GetMapping("/delete")
    public String deleteTodo(@RequestParam("id") int id) {
        todorepo.deleteById(id);
        return "redirect:/todolist"; // Corrected the redirect URL
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Todo todo = todorepo.findById(id).get();
        model.addAttribute("todo", todo);
        return "addtodo"; // Use the same form for adding and updating
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "addtodo"; // Show the same form on validation errors
        }
        String username = getLoggedinUsername(model);
        todo.setName(username);
        todorepo.save(todo);
        return "redirect:/todolist"; // Corrected the redirect URL
    }

    private String getLoggedinUsername(ModelMap model) {
        return (String) model.get("name");
    }
}

