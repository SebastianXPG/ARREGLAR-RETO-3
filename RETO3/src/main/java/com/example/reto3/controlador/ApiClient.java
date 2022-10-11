package com.example.reto3.controlador;

import com.example.reto3.entidad.Client;
import com.example.reto3.servicios.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/Client/")
@RestController
@CrossOrigin(origins = "*")
public class ApiClient {

    @Autowired
    private ClientService service;

    @GetMapping("/all")
    public List<Client> findAllClients(){
        return service.getClient();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable long id){
        return service.getClient(id);
    }

    @PostMapping("/save")
    public ResponseEntity saveClient(@RequestBody Client client){
        service.saveClient(client);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateClient(@RequestBody Client client){
        service.updateClient(client);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable long id){
        service.deleteClient(id);
        return ResponseEntity.status(204).build();
    }
}
