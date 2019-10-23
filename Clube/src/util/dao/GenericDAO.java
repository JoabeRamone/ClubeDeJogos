package util.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import clube.model.IBaseEntity;
import util.JPAUtil;

public abstract class GenericDAO<T extends IBaseEntity, I extends Serializable> {

	protected EntityManager entityManager;

	private Class<T> persistedClass;

	protected GenericDAO() {
		entityManager = JPAUtil.getEntityManager();
	}

	protected GenericDAO(Class<T> persistedClass) {
		this();
		this.persistedClass = persistedClass;
	}

	// +++
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public T salvar(T entity)  {
		
		if (entity.getId() == null) {
		
			EntityTransaction t = entityManager.getTransaction();
			t.begin();
			entityManager.persist(entity);
			entityManager.flush();
			t.commit();
			return entity;
		}
		else 
			return atualizar(entity);
			
	}

	public T atualizar(T entity) {
		EntityTransaction t = entityManager.getTransaction();
		t.begin();
		entity = entityManager.merge(entity);
		entityManager.flush();
		t.commit();
		return entity;
	}

	public void remover(I id) {
		T entity = encontrar(id);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		T mergedEntity = entityManager.merge(entity);
		entityManager.remove(mergedEntity);
		entityManager.flush();
		tx.commit();
	}
	
	
	

	public T encontrar(I id) {
		return entityManager.find(persistedClass, id);
	}
	
	/**
	 * retorna objeto gerenciado apenas com o id populado (não vai no banco de dados)
	 * @param id
	 * @return
	 */
	public T referencia(I id) {
		//objeto gerenciado apenas com o id populado (não vai no banco de dados)
		// --- retorna exception se não existir a entidade com o id especificado
		return entityManager.getReference(persistedClass, id);
	}
	
	
	
		
	// +++
	@SuppressWarnings("unchecked")
	public List<T> listarTudo() {
		return entityManager.createQuery("Select t from " + persistedClass.getSimpleName() + " t order by 1").getResultList();
	}

	
}