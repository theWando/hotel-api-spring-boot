package com.pana.hotel.controller;

import com.pana.hotel.model.Room;
import com.pana.hotel.repository.RoomRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class RoomControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private RoomRepository roomRepository;

    private Set<Room> rooms = new HashSet<>();

    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

        roomRepository.deleteAllInBatch();

        this.rooms.add(roomRepository.save(new Room(1, true, "El conquistador", new BigDecimal(14.5), new BigDecimal(14.5))));
        this.rooms.add(roomRepository.save(new Room(2, new BigDecimal(10.5))));
        this.rooms.add(roomRepository.save(new Room(1, new BigDecimal(12.2))));
    }

    @Test
    public void returnsThreeRooms() throws Exception {
        mockMvc.perform(get("/room/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.result", hasSize(this.rooms.size())));
    }
}