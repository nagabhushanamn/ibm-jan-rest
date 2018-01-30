package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.domain.Identifiable;

public abstract class InMemoryRepository<T extends Identifiable> {

	@Autowired
	private IdGenerator idGenerator;

	private List<T> elements = Collections.synchronizedList(new ArrayList<>());

	public T create(T element) {
		element.setId(idGenerator.getNextId());
		elements.add(element);
		return element;
	}

	public boolean delete(Long id) {
		return elements.removeIf(element -> element.getId().equals(id));
	}

	public List<T> findAll() {
		return elements;
	}

	public Optional<T> findById(Long id) {
		return elements.stream().filter(e -> e.getId().equals(id)).findFirst();
	}

	public int getCount() {
		return elements.size();
	}

	public void clear() {
		elements.clear();
	}

	public boolean update(Long id, T updated) {
		if (updated == null) {
			return false;
		} else {
			Optional<T> element = findById(id);
			element.ifPresent(original -> updateIfExists(original, updated));
			return element.isPresent();
		}
	}

	protected abstract void updateIfExists(T original, T desired);

}
