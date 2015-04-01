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
@Table(name ="aulas")
public class Aulas implements Serializable{
	
	private static final long serialVersionUID = 2229990954383542838L;
	
	@Id
	@SequenceGenerator(name="aulas_seq",sequenceName="aulas_seq",allocationSize=1)
    @GeneratedValue(generator="aulas_seq",strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="turma_id")
	private Turma turma;

	
	public Long getId() {
		return id;
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

	public void setId(Long id) {
		this.id = id;
	}

}
