package com.pana.hotel.service;

import com.pana.hotel.model.Room;
import com.pana.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Transactional
    public Set<Room> getAllRooms() {
        try (Stream<Room> allRooms = roomRepository.findAllRooms()) {
            return allRooms.collect(Collectors.toSet());
        }
    }
}
