package br.unifor.pin.saa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="turma")
public class Turma implements Serializable {

	private static final long serialVersionUID = -1203019308743583974L;

	@Id
	@SequenceGenerator(name="turma_seq", sequenceName="turma_seq", allocationSize=1)
	@GeneratedValue(generator="turma_seq", strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable=false)
	private String disciplina;
	
	@Column(nullable=false)
	private Integer semestre;
	
	@ManyToOne
	@JoinColumn(name="professor_id")
	private Professores professor;
	
	@ManyToOne
	@JoinColumn(name="instituicao_id")
	private Instituicoes instituicao;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the disciplina
	 */
	public String getDisciplina() {
		return disciplina;
	}

	/**
	 * @param disciplina the disciplina to set
	 */
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	/**
	 * @return the semestre
	 */
	public Integer getSemestre() {
		return semestre;
	}

	/**
	 * @param semestre the semestre to set
	 */
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	/**
	 * @return the professor
	 */
	public Professores getProfessor() {
		return professor;
	}

	/**
	 * @param professor the professor to set
	 */
	public void setProfessor(Professores professor) {
		this.professor = professor;
	}

	/**
	 * @return the instituicao
	 */
	public Instituicoes getInstituicao() {
		return instituicao;
	}

	/**
	 * @param instituicao the instituicao to set
	 */
	public void setInstituicao(Instituicoes instituicao) {
		this.instituicao = instituicao;
	}
	


}
