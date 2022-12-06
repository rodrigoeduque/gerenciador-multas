package br.com.rodrigoeduque.gerenciadorMultas.controller;

import br.com.rodrigoeduque.gerenciadorMultas.controller.dto.AcidenteRequest;
import br.com.rodrigoeduque.gerenciadorMultas.model.Acidente;
import br.com.rodrigoeduque.gerenciadorMultas.model.Carro;
import br.com.rodrigoeduque.gerenciadorMultas.repository.AcidenteRepository;
import br.com.rodrigoeduque.gerenciadorMultas.repository.CarroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/carros/{id}/acidente")
public class AcidenteController {

    @Autowired
    AcidenteRepository acidenteRepository;

    @Autowired
    CarroRepository carroRepository;

    @PostMapping
    public ResponseEntity<Void> novoAcidente(@PathVariable Long id, @RequestBody @Valid AcidenteRequest request) {

        Carro carro = carroRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Identificador para carro inexistente na base de dados"));
        Acidente acidente = request.toAcidente(carro);

        Acidente novoAcidente = acidenteRepository.save(acidente);
        URI uri = UriComponentsBuilder.fromPath("/carros/{idCarro}/acidente/{id}").buildAndExpand(carro.getId(),novoAcidente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
