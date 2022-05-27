package br.com.senai.manutencaosenaiapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.google.common.base.Preconditions;

import br.com.senai.manutencaosenaiapi.entity.Login;
import br.com.senai.manutencaosenaiapi.repository.LoginRepository;

@Service
@Validated
public class LoginService {
	
	@Autowired
	private LoginRepository repository;
	
	public Login logar(String login, String senha, String perfil) {
		
		Login loginEncontrado = repository.buscarPor(login, senha, perfil);
		Preconditions.checkNotNull(loginEncontrado, "Usuário e/ou senha invalidos "
				+ "verifique os dados e tente novamente");
		
		return loginEncontrado;
	}
	
	

}
