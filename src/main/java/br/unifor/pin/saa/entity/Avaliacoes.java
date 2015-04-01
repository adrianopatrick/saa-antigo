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
@Table(name ="avaliacoes")
public class Avaliacoes implements Serializable{
	
	private static final long serialVersionUID = 9045460114396877875L;

	@Id
	@SequenceGenerator(name="avaliacoes_seq",sequenceName="avaliacoes_seq",allocationSize=1)
    @GeneratedValue(generator="avaliacoes_seq",strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable=false)
	private Double nota;
	
	@Column(nullable=false)
	private Boolean aprovado;
	
	@ManyToOne
	@JoinColumn(name="aluno_id")
	private Alunos aluno;

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
	 * @return the nota
	 */
	public Double getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(Double nota) {
		this.nota = nota;
	}

	/**
	 * @return the aprovado
	 */
	public Boolean getAprovado() {
		return aprovado;
	}

	/**
	 * @param aprovado the aprovado to set
	 */
	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}

	/**
	 * @return the aluno
	 */
	public Alunos getAluno() {
		return aluno;
	}

	/**
	 * @param aluno the aluno to set
	 */
	public void setAluno(Alunos aluno) {
		this.aluno = aluno;
	}

	/**
	 * @return the aulas
	 */
	public Aulas getAulas() {
		return aulas;
	}

	/**
	 * @param aulas the aulas to set
	 */
	public void setAulas(Aulas aulas) {
		this.aulas = aulas;
	}

	@ManyToOne
	@JoinColumn(name="aulas_id")
	private Aulas aulas;


}
