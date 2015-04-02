package br.unifor.pin.saa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Aulas;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class AulasDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Aulas aulas) {
		entityManager.persist(aulas);
	}
	
	public void atualizar(Aulas aulas){
		entityManager.merge(aulas);
	}
	
	public void excluir(Aulas aulas){
		entityManager.remove(aulas);
	}
	
	public Aulas buscarPorId(Long id){
		return entityManager.find(Aulas.class, id);
	}
	
}
