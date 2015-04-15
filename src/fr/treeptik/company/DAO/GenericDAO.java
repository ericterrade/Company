package fr.treeptik.company.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class GenericDAO<T,PK> {
	
	protected EntityManager entityManager = Persistence.createEntityManagerFactory(
			"company").createEntityManager();
	
	private Class<T> entityClass;
	
	public GenericDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public void create(T entity) {
		entityManager.persist(entity);
	}

	public void delete(T entity) {
		T entityToBeRemoved = entityManager.merge(entity);
		entityManager.remove(entityToBeRemoved);
	}
	public void refresh(T entity){
		entityManager.refresh(entity);
	}

	public T update(T entity) {
		return entityManager.merge(entity);
	}
}
