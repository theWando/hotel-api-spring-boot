package com.pana.hotel.repository;

import com.pana.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query("SELECT r FROM Room AS r")
    Stream<Room> findAllRooms();
}
