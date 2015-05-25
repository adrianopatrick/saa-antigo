package br.unifor.pin.saa.manager.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.AlunosBO;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name = "verLogin")
@Component(value = "verLogin")
public class LoginManager {

	@Autowired
	private AlunosBO alunosBO;
	
	public String verificaLogin(){
		System.out.println("clicado");
		return Navigation.SUCESSO;
	}
}
