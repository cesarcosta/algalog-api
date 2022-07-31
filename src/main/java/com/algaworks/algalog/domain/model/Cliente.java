package com.algaworks.algalog.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.algaworks.algalog.domain.validations.ValidationGroups;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author César Rangel - cesarrangelfonseca@gmail.com
 * @since 30/07/2022
 */
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cliente {

	@EqualsAndHashCode.Include
	@Id
	@NotNull(groups = ValidationGroups.ClienteId.class)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seqCliente")
	@SequenceGenerator(name = "seqCliente", sequenceName = "public.seq_cliente", allocationSize = 1)
	private Long id;

	@NotBlank
	@Size(max = 100)
	@Column
	private String nome;

	@NotBlank
	@Email
	@Size(max = 100)
	@Column
	private String email;

	@NotBlank
	@Size(max = 15)
	@Column
	private String telefone;

}