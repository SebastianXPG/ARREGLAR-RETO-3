package com.example.reto3.controlador;

import com.example.reto3.entidad.Room;
import com.example.reto3.servicios.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/Room/")
public class ApiRoom {

    @Autowired
    private RoomService service;

    @GetMapping("/all")
    public List<Room> findAllRooms(){
        return service.getRooms();
    }

    @PostMapping("/save")
    public ResponseEntity saveRooms(@RequestBody Room room){
        service.saveRoom(room);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateRoom(@PathVariable Room room){
        service.updateRoom(room);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRoom(@PathVariable long id){
        service.deleteRoom(id);
        return ResponseEntity.status(204).build();
    }

}
