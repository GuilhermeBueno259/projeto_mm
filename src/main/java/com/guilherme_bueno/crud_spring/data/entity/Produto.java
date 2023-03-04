package com.guilherme_bueno.crud_spring.data.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produtos") // nome da tabela (opcional)
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Produto implements Serializable {

	private static final long serialVersionUID = 1948263887314040596L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/*
	 * AUTO = o banco de dados escolhe a estratégia IDENTITY = valor gerado pela
	 * coluna de auto incremento do banco, nem todos os bancos de dados suportam
	 * esta opção. SEQUENCE = valor gerado por uma sequência, que se não for
	 * especificada, será global gerada pelo banco, para todas as entidades. TABLE =
	 * é necessário criar uma tabela para gerenciar as chaves primárias. Essa opção
	 * não é recomendada.
	 */
	private Long id;

	@NonNull
	@NotBlank(message = "Nome é obrigatório")
	@Size(min = 1, max = 30, message = "O tamanho deve estar entre 1 e 30 caracteres")
	@Column(length = 30, nullable = false)
	private String nome;

	@NonNull
	@NotNull(message = "Quantidade é obrigatório")
	@Min(1)
	@Max(9999)
	@Column(nullable = false)
	private Integer quantidade;

}
