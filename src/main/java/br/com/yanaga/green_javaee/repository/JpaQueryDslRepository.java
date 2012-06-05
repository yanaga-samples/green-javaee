package br.com.yanaga.green_javaee.repository;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;

@ApplicationScoped
public class JpaQueryDslRepository implements QueryDslRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public <T> T save(T entity) {
		return entityManager.merge(entity);
	}

	@Override
	public <T> T remove(T entity) {
		entityManager.remove(entity);
		return entity;
	}

	@Override
	public <T> T findById(Class<T> klazz, Serializable id) {
		return entityManager.find(klazz, id);
	}

	@Override
	public JPQLQuery query() {
		return new JPAQuery(entityManager);
	}

}