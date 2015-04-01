package br.unifor.pin.saa.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Cursa")
public class Cursa implements Serializable {
	
	
	private static final long serialVersionUID = -8584366456871655303L;


	@Id
	@SequenceGenerator(name="cursa_seq", sequenceName="cursa_seq", allocationSize=1)
	@GeneratedValue(generator="cursa_seq", strategy=GenerationType.SEQUENCE)
	private Long id;
	
		
	@ManyToOne
	@JoinColumn(name="aluno_id")
	private Alunos aluno;
	
	@ManyToOne
	@JoinColumn(name="turma_id")
	private Turma turma;

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
	 * @return the turma
	 */
	public Turma getTurma() {
		return turma;
	}

	/**
	 * @param turma the turma to set
	 */
	public void setTurma(Turma turma) {
		this.turma = turma;
	}



}
