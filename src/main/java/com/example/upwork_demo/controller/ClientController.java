package com.example.upwork_demo.controller;

import com.example.upwork_demo.model.Client;
import com.example.upwork_demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Optional<Client> client = clientService.getClientById(id);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<Client>> createClients(@RequestBody List<Client> clients) {
        List<Client> createdClients = clientService.saveAllClients(clients);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClients);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
        Optional<Client> clientOptional = clientService.getClientById(id);

        if (!clientOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Client client = clientOptional.get();
        client.setName(clientDetails.getName());
        client.setBackground(clientDetails.getBackground());
        Client updatedClient = clientService.saveClient(client);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        if (!clientService.getClientById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
