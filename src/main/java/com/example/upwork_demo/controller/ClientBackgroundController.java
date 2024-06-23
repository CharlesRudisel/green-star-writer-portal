package com.example.upwork_demo.controller;

import com.example.upwork_demo.model.ClientBackground;
import com.example.upwork_demo.service.ClientBackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientBackgrounds")
public class ClientBackgroundController {

    @Autowired
    private ClientBackgroundService clientBackgroundService;

    @GetMapping
    public List<ClientBackground> getAllClientBackgrounds() {
        return clientBackgroundService.getAllClientBackgrounds();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientBackground> getClientBackgroundById(@PathVariable Long id) {
        Optional<ClientBackground> clientBackground = clientBackgroundService.getClientBackgroundById(id);
        return clientBackground.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ClientBackground createClientBackground(@RequestBody ClientBackground clientBackground) {
        return clientBackgroundService.saveClientBackground(clientBackground);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<ClientBackground>> createClientBackgrounds(@RequestBody List<ClientBackground> clientBackgrounds) {
        List<ClientBackground> createdClientBackgrounds = clientBackgroundService.saveAllClientBackgrounds(clientBackgrounds);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClientBackgrounds);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientBackground> updateClientBackground(@PathVariable Long id, @RequestBody ClientBackground clientBackgroundDetails) {
        Optional<ClientBackground> clientBackgroundOptional = clientBackgroundService.getClientBackgroundById(id);

        if (!clientBackgroundOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        ClientBackground clientBackground = clientBackgroundOptional.get();
        clientBackground.setDetails(clientBackgroundDetails.getDetails());
        ClientBackground updatedClientBackground = clientBackgroundService.saveClientBackground(clientBackground);
        return ResponseEntity.ok(updatedClientBackground);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClientBackground(@PathVariable Long id) {
        if (!clientBackgroundService.getClientBackgroundById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        clientBackgroundService.deleteClientBackground(id);
        return ResponseEntity.noContent().build();
    }
}
