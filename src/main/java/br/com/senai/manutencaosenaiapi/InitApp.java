package br.com.senai.manutencaosenaiapi;

import java.time.LocalDate;

import javax.swing.plaf.synth.SynthScrollPaneUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.manutencaosenaiapi.entity.Cliente;
import br.com.senai.manutencaosenaiapi.entity.Peca;
import br.com.senai.manutencaosenaiapi.entity.Tecnico;
import br.com.senai.manutencaosenaiapi.enums.Sexo;
import br.com.senai.manutencaosenaiapi.service.ClienteService;
import br.com.senai.manutencaosenaiapi.service.PecaService;
import br.com.senai.manutencaosenaiapi.service.TecnicoService;

@SpringBootApplication
public class InitApp {

	public static void main(String[] args) {
		SpringApplication.run(InitApp.class, args);
		
	}
	@Autowired
	private TecnicoService service;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private PecaService pecaService;
	
	@Bean
	public CommandLineRunner commandLineRunner (ApplicationContext ac) {
	
		return args -> {
			
			try {
				/*Tecnico novoTecnico = new Tecnico();
				novoTecnico.setNomeCompleto("Josevildo Soares");
				LocalDate dataDeAdmissao = LocalDate.of(2022, 4, 7);
				novoTecnico.setDataDeAdmissao(dataDeAdmissao);
				this.service.inserir(novoTecnico); */
				
				/*Tecnico tecnicoSalvo = new Tecnico();
				tecnicoSalvo.setId(1);
				tecnicoSalvo.setNomeCompleto("Joanecleidson");
				tecnicoSalvo.setDataDeAdmissao(LocalDate.now());
				
				this.service.alterar(tecnicoSalvo);
				
				System.out.println("Técnico salvo com sucesso");*/
				
				/*this.service.listarPor("José");
				this.service.removerPor(0);*/
				
				/*Cliente novoCliente = new Cliente();
				novoCliente.setNome("Joao");
				novoCliente.setSobrenome("Da Silva");
				novoCliente.setCpf("338.138.290-14");
				novoCliente.setSexo(Sexo.MASCULINO);
				novoCliente.setEndereco("Rua das couves");
				novoCliente.setDataDeNascimento(LocalDate.of(2018, 9, 14));
				this.clienteService.inserir(novoCliente);
				System.out.println("Cliente salvo com sucesso");*/
				Peca novaPeca = new Peca();
				novaPeca.setDescricao("Teclado");
				novaPeca.setQtdEmEstoque(10);
				this.pecaService.inserir(null);
				System.out.println(novaPeca);
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
				
			}

	};
	
	}
	
}
