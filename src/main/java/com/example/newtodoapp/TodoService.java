package com.example.newtodoapp;

// import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
// import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
    private static List<Todo> list = new ArrayList<>();

    // static {
    //     list.add(new Todo(1, "Vaibhav", "Spring", LocalDate.now().plusYears(2)));
    //     list.add(new Todo(2, "Vaibhav Dubey", "React", LocalDate.now().plusYears(1)));
    //     list.add(new Todo(3, "Vaibhav ji", "Spring Boot", LocalDate.now().plusYears(2)));
    //     list.add(new Todo(4, "Vaibhav sir", "AWS", LocalDate.now().plusYears(3)));
    // }

    public List<Todo> findByUserName(String name) {

        return list.stream().filter(e -> e.getName().equalsIgnoreCase(name)).toList();

    }

    // Method to add a new Todo
    public void addTodo(Todo todo) {
        list.add(todo);
    }

    // Method to get all Todos
    public List<Todo> getAllTodos() {
        return list;
    }

//    public void deleteTodo(int id) {
   
//     list = list.stream()
//                .filter(todo -> todo.getId() != id)
//                .collect(Collectors.toList());
// }



public void deleteTodoSl(int id) {

    // Predicate<? super Todo> filter   if i write condition      delete mathod new  learn 
    list.removeIf(todo -> todo.getId() == id);

} 


public Todo findById(int id) {
    Predicate<? super Todo> predicate = todo -> todo.getId() == id ;
    return list.stream().filter( predicate).findFirst().get();
}

public void updateTodo(@Valid Todo updatedTodo) {
   
    Todo existingTodo = findById(updatedTodo.getId());
    
    if (existingTodo != null) {
        existingTodo.setName(updatedTodo.getName());
        existingTodo.setComplete(updatedTodo.getComplete());
        existingTodo.setDate(updatedTodo.getDate());
    }
    
}





}



