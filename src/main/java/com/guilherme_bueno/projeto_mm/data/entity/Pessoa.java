package com.guilherme_bueno.projeto_mm.data.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "pessoas")
@NoArgsConstructor
@Data
@Getter
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 3864849643872006254L;

	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	@NotBlank(message = "Nome é obrigatório")
	@Size(min = 3, max = 60, message = "O tamanho do nome deve ser de 3 a 60 caracteres")
	@Column(length = 60, nullable = false)
	private String nome;

	@NonNull
	@NotBlank(message = "Telefone é obrigatório")
	@Column(length = 16, nullable = false)
	private String telefone;

	@NonNull
	@NotBlank(message = "E-mail é obrigatório")
	@Size(min = 5, max = 45, message = "O tamanho do E-mail deve ser de 5 a 45 caracteres")
	@Column(length = 45, nullable = false)
	private String eMail;
}
