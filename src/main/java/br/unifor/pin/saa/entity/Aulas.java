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
@Table(name ="aulas")
public class Aulas implements Serializable{
	
	private static final long serialVersionUID = 2229990954383542838L;
	
	@Id
	@SequenceGenerator(name="aulas_seq",sequenceName="aulas_seq",allocationSize=1)
    @GeneratedValue(generator="aulas_seq",strategy=GenerationType.SEQUENCE)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
