package br.com.senai.manutencaosenaiapi.entity;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import lombok.Data;



@Data
public class OrdemDeServico {
	
	
	private Integer id;
	
	@NotNull(message = "O cliente da ordem não pode ser nulo")
	private Cliente cliente;
	
	@NotNull(message = "O tecnico da ordem não pode ser nulo")
	private Tecnico tecnico;
	
	@NotNull(message = "A data de abertura é obrigatoria")
	@PastOrPresent(message = "A data de abertura não pode ser porterior a data atual")
	private LocalDate dataDeAbertura;
	
	@PastOrPresent(message = "A data de encerramento não pode ser porterior a data atual")
	private LocalDate dataDeEncerramento;
	
	@NotEmpty(message = "A descrição do problema é obrigatória")
	@NotEmpty(message = "A descrição do problema não foi informada")
	private String descricaoDoProblema;
	
	private String descricaoDoReparo;
	
	@NotEmpty(message = "Deve haver ao menos uma peça de reparo")
	private List<Peca>pecasDoReparo;

	
}
