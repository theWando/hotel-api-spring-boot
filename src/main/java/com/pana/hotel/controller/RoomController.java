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
        final Room room = new Room();
        room.setName("El conquistador");
        room.setNumber(1);
        room.setNumberOfBeds(1);
        room.setPrice(new BigDecimal(173));
        room.setWithAView(false);
        rooms.add(room);
        return buildOkStatusResponse(rooms);
    }

}
