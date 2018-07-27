package com.pana.hotel.controller;

import static com.pana.hotel.controller.util.ResponseUtil.buildOkStatusResponse;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.pana.hotel.controller.model.Response;
import com.pana.hotel.model.Room;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {

    @GetMapping(path = "/all")
    public ResponseEntity<Response> listAllRooms() {
        Set<Room> rooms = new HashSet<>();
        Room room = new Room();
        room.setName("El conquistador");
        room.setNumber(1);
        room.setNumberOfBeds(1);
        room.setPrice(new BigDecimal(173));
        room.setWithAView(false);
        Room room2 = new Room();
        room2.setNumber(2);
        room2.setNumberOfBeds(1);
        room2.setPrice(new BigDecimal(173));
        room2.setWithAView(false);
        rooms.add(room2);
        return buildOkStatusResponse(rooms);
    }

    @GetMapping(path = "/all/available")
    public ResponseEntity<Response> listAllAvailableRooms() {
        return null;
    }

}
