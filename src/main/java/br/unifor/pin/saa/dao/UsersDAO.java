package br.unifor.pin.saa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.unifor.pin.saa.entity.Users;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class UsersDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(Users user) {
		entityManager.persist(user);
	}
	
	public void atualizar(Users user){
		entityManager.merge(user);
	}
	
	public void excluir(Users user){
		entityManager.remove(user);
	}
	
	public Users buscarPorId(Long id){
		return entityManager.find(Users.class, id);
	}
	
	public Users buscarPorCpf(String cpf) {
		String jpql = "select i from Users i where i.cpf = :cpf";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("cpf", cpf);
		
		return (Users) query.getSingleResult();
	}
	
}
