package br.unifor.pin.saa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

}
