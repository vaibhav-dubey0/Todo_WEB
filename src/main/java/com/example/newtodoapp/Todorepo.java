package com.example.newtodoapp;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface Todorepo extends JpaRepository<Todo,Integer>{
    
    List<Todo> findByName(String name);

}
