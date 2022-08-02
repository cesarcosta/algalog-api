package com.algaworks.algalog.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
 * @since 31/07/2022
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seqEntrega")
	@SequenceGenerator(name = "seqEntrega", sequenceName = "public.seq_entrega", allocationSize = 1)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@Embedded
	private Destinatario destinatario;
	
	@Column
	private BigDecimal taxa;
	
	@Enumerated(EnumType.STRING)
	@Column
	private StatusEntrega status;
	
	@Column
	private OffsetDateTime dataPedido;
	
	@Column
	private OffsetDateTime dataFinalizacao;
}
