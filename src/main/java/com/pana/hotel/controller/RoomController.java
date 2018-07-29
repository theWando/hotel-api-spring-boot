package com.pana.hotel.controller;

import com.pana.hotel.controller.model.Response;
import com.pana.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.pana.hotel.controller.util.ResponseUtil.buildOkStatusResponse;

@RestController
@RequestMapping("/room")
public class RoomController {

    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Response> listAllRooms() {
        return buildOkStatusResponse(roomService.getAllRooms());
    }

    @GetMapping(path = "/all/available")
    public ResponseEntity<Response> listAllAvailableRooms() {
        return null;
    }

}
