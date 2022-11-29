package br.com.rodrigoeduque.gerenciadorMultas.controller;

import br.com.rodrigoeduque.gerenciadorMultas.controller.dto.ClienteRequest;
import br.com.rodrigoeduque.gerenciadorMultas.model.Cliente;
import br.com.rodrigoeduque.gerenciadorMultas.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid ClienteRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Cliente novoCliente = request.toCliente();

        clienteRepository.save(novoCliente);

        URI uri = uriComponentsBuilder.path("/clientes/{id}").buildAndExpand(novoCliente.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
