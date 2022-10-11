package com.example.reto3.controlador;

import com.example.reto3.entidad.Message;
import com.example.reto3.servicios.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/Message")
public class ApiMessage {

    @Autowired
    private MessageService service;

    @GetMapping("/all")
    public List<Message> findAllMessages(){
        return service.getMessages();
    }

    @PostMapping("/save")
    public ResponseEntity saveMessage(@RequestBody Message message){
        service.saveMessage(message);
        return ResponseEntity.status(201).build();
    }
}
