package br.unifor.pin.saa.manager.professor;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.saa.bussines.AlunosBO;
import br.unifor.pin.saa.bussines.ProfessoresBO;
import br.unifor.pin.saa.entity.Alunos;
import br.unifor.pin.saa.entity.Professores;
import br.unifor.pin.saa.utils.Navigation;

@RequestScoped
@ManagedBean(name="listProfessor")
@Component(value="listProfessor")
public class ListProfessorManager {

	@Autowired
	private ProfessoresBO professoresBO;
	private String nome;
	private List<Professores> professores;
	
	public void lista(){
		
		professores = professoresBO.listaProfessoresPorNome(nome);
	}
	
	public void excluir(Professores professor){
		professoresBO.excluir(professor);
		professores = professoresBO.listaProfessoresPorNome(nome);
	}
	
	public String preparaAtualizar(Professores professor){
		System.out.println(professor.getNome());
		return null;
	}
	
	public String preparaListar(){
		this.limparDados();
		return Navigation.SUCESSO;
	}
	
	public void limparDados(){
		this.nome = "";
		this.professores = null;
	}
	
	
	public String salvar(){
		return null;
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
	public List<Professores> getProfessores() {
		return professores;
	}

	/**
	 * @param professores the professores to set
	 */
	public void setProfessores(List<Professores> professores) {
		this.professores = professores;
	}

}
