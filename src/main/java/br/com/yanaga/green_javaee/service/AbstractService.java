package br.com.yanaga.green_javaee.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.yanaga.green_javaee.repository.JpaQueryDslRepository;

public class AbstractService {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	protected JpaQueryDslRepository repository;

	public <T> T save(T entity) {
		return repository.save(entity);
	}

	public <T> T remove(T entity) {
		return repository.remove(entity);
	}

}