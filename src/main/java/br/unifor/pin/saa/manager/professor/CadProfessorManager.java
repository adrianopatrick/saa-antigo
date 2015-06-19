package br.unifor.pin.saa.manager.professor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.unifor.pin.saa.bussines.ProfessoresBO;
import br.unifor.pin.saa.entity.Professores;
import br.unifor.pin.saa.utils.MessagesUtils;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name="cadProfessor")
@Component(value="cadProfessor")
public class CadProfessorManager {

	@Autowired
	private ProfessoresBO professoresBO;
	
	@Autowired
	private ListProfessorManager listProfessor;
	

	private String nome;
	private Professores professores;
	
	public String salvar(){
		Professores professores = new Professores();
		
		professores.setNome(nome);
		professoresBO.salvar(professores);
		MessagesUtils.info("Professor salvo com sucesso!");
		//listProfessor.lista();
		
		return Navigation.SUCESSO;
	}
	
	public String preparaSalvar(){
		this.limpaDados();
		
		return Navigation.SUCESSO;
	}
			
	public void limpaDados(){
		
		this.nome = "";
		
	}

	/**
	 * @return the professoresBO
	 */
	public ProfessoresBO getProfessoresBO() {
		return professoresBO;
	}

	/**
	 * @param professoresBO the professoresBO to set
	 */
	public void setProfessoresBO(ProfessoresBO professoresBO) {
		this.professoresBO = professoresBO;
	}

	/**
	 * @return the listProfessor
	 */
	public ListProfessorManager getListProfessor() {
		return listProfessor;
	}

	/**
	 * @param listProfessor the listProfessor to set
	 */
	public void setListProfessor(ListProfessorManager listProfessor) {
		this.listProfessor = listProfessor;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the professores
	 */
	public Professores getProfessores() {
		return professores;
	}

	/**
	 * @param professores the professores to set
	 */
	public void setProfessores(Professores professores) {
		this.professores = professores;
	}
	
}
