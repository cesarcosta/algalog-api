package com.algaworks.algalog.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author César Rangel - cesarrangelfonseca@gmail.com
 * @since 01/08/2022
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Ocorrencia {

	@EqualsAndHashCode.Include
	@Id
	@SequenceGenerator(name = "seqOcorrencia", sequenceName = "public.seq_ocorrencia", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "seqOcorrencia", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_entrega")
	private Entrega entrega;
	
	private String descricao;
	
	private OffsetDateTime dataRegistro;
	
}