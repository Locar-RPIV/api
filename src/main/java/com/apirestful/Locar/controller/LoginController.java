package com.apirestful.Locar.controller;

import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpClient.Redirect;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.apirestful.Locar.model.Cliente;
import com.apirestful.Locar.model.Funcionario;
import com.apirestful.Locar.repository.ClienteRepository;
import com.apirestful.Locar.repository.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer.RedirectionEndpointConfig;
import org.springframework.security.web.util.RedirectUrlBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(value = "/api")
public class LoginController {
    
    @Autowired
    private FuncionarioRepository funcionariosRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/funcionarios")
    public List<Funcionario> listFuncionarios() {
        return funcionariosRepository.findAll();
    }

    @PostMapping(value="/login/funcionario")
    public ResponseEntity<String> loginFuncionario(Funcionario funcionario, HttpSession session) {
        
        funcionario = this.funcionariosRepository.findByCpfAndNumeroPis(funcionario.getCpf(), funcionario.getNumeroPis());

        if (funcionario != null) {
            session.setAttribute("funcionarioLogado", funcionario);
            return new ResponseEntity<String>(HttpStatus.ACCEPTED);            
        } else {
            return new ResponseEntity<String>(HttpStatus.NON_AUTHORITATIVE_INFORMATION); 
        } 
    }
    
    @PostMapping(value="/login/cliente")
    public String loginCliente(Cliente cliente, HttpSession session) {
        
        cliente = this.clienteRepository.findByCpfAndCnh(cliente.getCpf(), cliente.getCnh());

        if (cliente != null ) {
            session.setAttribute("clienteLogado", cliente);
            return "redirect:/cliente";            
        } else {
            return "redirect:/login/cliente";
        }
    }
    

}
