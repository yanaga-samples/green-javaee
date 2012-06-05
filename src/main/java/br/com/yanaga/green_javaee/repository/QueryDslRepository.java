package br.com.yanaga.green_javaee.repository;

import java.io.Serializable;

import com.mysema.query.jpa.JPQLQuery;

public interface QueryDslRepository {

	public <T> T save(T entity);

	public <T> T remove(T entity);

	public <T> T findById(Class<T> klazz, Serializable id);

	public JPQLQuery query();

}