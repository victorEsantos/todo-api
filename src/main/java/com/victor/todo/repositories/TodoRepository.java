package com.victor.todo.repositories;

import com.victor.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{

    @Query(value = "SELECT obj from Todo obj WHERE obj.done = false order by obj.createdDate")
    List<Todo> findAllOpen();

    @Query(value = "SELECT obj from Todo obj WHERE obj.done = true order by obj.createdDate")
    List<Todo> findAllClose();
}
