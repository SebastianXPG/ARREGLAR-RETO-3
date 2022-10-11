package com.example.reto3.servicios;


import com.example.reto3.entidad.Room;
import com.example.reto3.repositorio.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository repository;

    public List<Room> getRooms(){
        return repository.findAll();
    }

    public Room saveRoom(Room room){
        return repository.save(room);
    }

    public Room getRoom(long id){
        return  repository.findById(id).orElse(null);
    }

    public Room updateRoom(Room roomUpd){
        Room roomOld = getRoom(roomUpd.getId());
        roomOld.setName(roomUpd.getName());
        roomOld.setHotel(roomUpd.getHotel());
        roomOld.setStars(roomUpd.getStars());
        roomOld.setDescription(roomUpd.getDescription());
        roomOld.setCategory(roomUpd.getCategory());
        return repository.save(roomOld);
    }

    public  void deleteRoom(long id){
        repository.deleteById(id);
    }
}
