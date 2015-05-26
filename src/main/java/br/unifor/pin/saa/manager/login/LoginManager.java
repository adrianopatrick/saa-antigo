package br.unifor.pin.saa.manager.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.AlunosBO;
import br.unifor.pin.saa.bussines.UsuarioBO;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name = "verLogin")
@Component(value = "verLogin")
public class LoginManager {

	private String nome;
	private String senha;
	private String valida;
	
	@Autowired
	private UsuarioBO usuarioBO;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public String verificaLogin(){
		System.out.println("clicado");
		String jpql = "select a from Alunos a where a.nome = :nome";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("nome", nome);
		
		if(valida != null){
			return Navigation.SUCESSO;
		} else {
			return Navigation.FALHA;
		}
	}
}
