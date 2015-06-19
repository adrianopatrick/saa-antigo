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
@ManagedBean(name = "atualizaProfessor")
@Component(value = "atualizaProfessor")
public class AtualizaProfessorManager {

	@Autowired
	private ProfessoresBO professoresBO;
	private Professores professorSelecionado;

	public String atualizar() {
		professoresBO.atualizar(professorSelecionado);
		MessagesUtils.info("Professor atualizado com sucesso!");

		return Navigation.SUCESSO;
	}

	public String preparaAtualizar(Professores professor) {
		professorSelecionado = professoresBO.buscarPorId(professor.getId());

		return Navigation.ATUALIZA;
	}
	
	public void limparDados(){
		professorSelecionado.setNome("");
		
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
	 * @return the professorSelecionado
	 */
	public Professores getProfessorSelecionado() {
		return professorSelecionado;
	}

	/**
	 * @param professorSelecionado the professorSelecionado to set
	 */
	public void setProfessorSelecionado(Professores professorSelecionado) {
		this.professorSelecionado = professorSelecionado;
	}

	
}
