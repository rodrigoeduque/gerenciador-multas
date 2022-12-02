package br.com.rodrigoeduque.gerenciadorMultas.controller;

import br.com.rodrigoeduque.gerenciadorMultas.controller.dto.CarroRequest;
import br.com.rodrigoeduque.gerenciadorMultas.model.Carro;
import br.com.rodrigoeduque.gerenciadorMultas.model.Cliente;
import br.com.rodrigoeduque.gerenciadorMultas.repository.CarroRepository;
import br.com.rodrigoeduque.gerenciadorMultas.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clientes/{idCliente}/carros")
public class CarroController {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    CarroRepository carroRepository;

    @PostMapping
    public ResponseEntity<Void> novoCarro(@PathVariable Long idCliente, @RequestBody @Valid CarroRequest request) {
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe cadastro para o cliente informado"));
        Carro carro = request.toCarro(cliente);

        carroRepository.save(carro);

        URI uri = UriComponentsBuilder.fromPath("/clientes/{idCliente}/carros/{id}").buildAndExpand(cliente.getId(),carro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
