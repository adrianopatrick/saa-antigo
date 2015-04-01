package br.unifor.pin.saa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	//@ManyToMany
	//@JoinTable(name ="cursa",
	//joinColumns=@JoinColumn(name="t_id"),
	//inverseJoinColumns=@JoinColumn(name="a_id"))
	//private Alunos aluno;

	/*
	 *  Getters e setters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public Professores getProfessor() {
		return professor;
	}

	public void setProfessor(Professores professor) {
		this.professor = professor;
	}

	public Instituicoes getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicoes instituicao) {
		this.instituicao = instituicao;
	}

}
