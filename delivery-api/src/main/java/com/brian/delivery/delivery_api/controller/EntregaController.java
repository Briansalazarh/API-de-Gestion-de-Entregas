package com.brian.delivery.delivery_api.controller;


import com.brian.delivery.delivery_api.model.Destinatario;
import com.brian.delivery.delivery_api.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("entregas")
public class EntregaController {

    private final EntregaService entregaService;

    public EntregaController(EntregaService entregaService){
        this.entregaService = entregaService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Destinatario>> buscarTodas() {
        return ResponseEntity.ok(entregaService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Destinatario> registrar(@RequestBody Destinatario destinatario) {
        entregaService.registrarEntrega(destinatario);
        return ResponseEntity.ok(destinatario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Destinatario> atualizar(@PathVariable Long id, @RequestBody Destinatario destinatario) {
        entregaService.atualizarEntrega(id, destinatario);
        return ResponseEntity.ok(destinatario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelar(@PathVariable Long id) {
        entregaService.cancelarEntrega(id);
        return ResponseEntity.ok().build();
    }
}
