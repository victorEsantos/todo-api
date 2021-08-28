package com.victor.todo.services;

import com.victor.todo.domain.Todo;
import com.victor.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class DBService {
    @Autowired
    TodoRepository todoRepository;

    public void instantiateDataBase() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        var todo = new Todo(null, "titulo", "Estudar Estudar Estudar Estudar Estudar Estudar",
                new Date(), false, new Date());
        var todo2 = new Todo(null, "titulo", "Estudar Estudar Estudar Estudar Estudar Estudar",
                new Date(), false, new Date());

        var todo3 = new Todo(null, "titulo", "done",
                new Date(), true, new Date());
        var todo4 = new Todo(null, "titulo", "done2",
                new Date(), true, new Date());

        todoRepository.saveAll(List.of(todo, todo2, todo3, todo4));
    }
}
