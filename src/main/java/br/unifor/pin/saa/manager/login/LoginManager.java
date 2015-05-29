package br.unifor.pin.saa.manager.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.UsuarioBO;
import br.unifor.pin.saa.entity.Usuarios;
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
	
	public String verificaLogin() {
		System.out.println("clicado");
		
		String jpql = "select u from Usuarios u where u.nome = :nome AND u.senha = :senha";
		Query query = entityManager.createQuery(jpql);
		
		if (query.setParameter("nome", nome) != null){
			return Navigation.SUCESSO;
		}
		return Navigation.SUCESSO;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getValida() {
		return valida;
	}

	public void setValida(String valida) {
		this.valida = valida;
	}
}
