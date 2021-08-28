package com.victor.todo.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.victor.todo.domain.Todo;
import com.victor.todo.services.exceptions.ObjectNotFoundException;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.todo.repositories.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;

	public List<Todo> findAll() {
		return repository.findAll();
	}

	public Todo findById(Integer id) {
		Optional<Todo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Todo.class.getName()));
	}

	public Todo insert(Todo obj) {
		obj.setId(null);
		obj.setCreatedDate(new Date());
		return repository.save(obj);

	}

	public Todo update(Todo obj) {
		var date = findById(obj.getId()).getCreatedDate();
		Todo newObj = new Todo(obj.getId(),obj.getTitle(), obj.getDescription(), date, obj.getDone(), obj.getFinishedDate());
		return repository.save(newObj);
	}

	public void deleteById(Integer id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			throw new NotYetImplementedException("Método ainda não implementado");
		}
	}

	public Todo markAsDone(Integer id) {
		Todo obj = findById(id);
		obj.setDone(true);
		obj.setFinishedDate(new Date());
		return repository.save(obj);
	}

	public List<Todo> findAllOpen() {
		List<Todo> list = repository.findAllOpen();

		return list;
	}

	public List<Todo> findAllClose() {
		List<Todo> list = repository.findAllClose();

		return list;
	}
}
