package com.example.demo.repository;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.config.BeanDefinition;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class IdGenerator {

	private AtomicLong nextId = new AtomicLong(1);

	public long getNextId() {
		return nextId.getAndIncrement();
	}

}
