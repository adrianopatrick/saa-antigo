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
	private Usuarios usuario;
	
	@Autowired
	private UsuarioBO usuarioBO;
	
	public String verificaLogin() {
		
		try {
			usuario = usuarioBO.buscaLogin(nome);
			if(nome.equalsIgnoreCase(usuario.getNome())
					&&senha.equals(usuario.getSenha())
					&&( usuario.isAtivo() || usuario.isPrimeiroAcesso()) ){
				return Navigation.SUCESSO;
			}
		} catch(NullPointerException e){
			e.printStackTrace();
		}
		return null;
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

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public UsuarioBO getUsuarioBO() {
		return usuarioBO;
	}

	public void setUsuarioBO(UsuarioBO usuarioBO) {
		this.usuarioBO = usuarioBO;
	}


}
