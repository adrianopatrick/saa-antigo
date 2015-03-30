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
	


}
