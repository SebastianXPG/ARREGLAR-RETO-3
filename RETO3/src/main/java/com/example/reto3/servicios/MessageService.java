package com.example.reto3.servicios;

import com.example.reto3.entidad.Message;
import com.example.reto3.repositorio.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;

    //get
    public List<Message> getMessages(){
        return repository.findAll();
    }

    public Message saveMessage(Message message){
        return repository.save(message);
    }
}
