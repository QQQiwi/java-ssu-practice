package com.example.controller;

import com.example.model.Tarif;
import com.example.service.TarifService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TarifController.class)
public class TarifControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TarifService tarifService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllTarifs() throws Exception {
        Tarif tarif1 = new Tarif();
        tarif1.setId(1L);
        tarif1.setName("Tarif1");
        tarif1.setRate(10.00);
        tarif1.setLastModified(LocalDateTime.now());

        Tarif tarif2 = new Tarif();
        tarif2.setId(2L);
        tarif2.setName("Tarif2");
        tarif2.setRate(20.00);
        tarif2.setLastModified(LocalDateTime.now());

        Mockito.when(tarifService.getAllTarifs()).thenReturn(Arrays.asList(tarif1, tarif2));

        mockMvc.perform(get("/api/tarifs"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is(tarif1.getName())))
                .andExpect(jsonPath("$[1].name", is(tarif2.getName())));
    }

    @Test
    void testCreateTarif() throws Exception {
        LocalDateTime now = LocalDateTime.now();
    
        Tarif createdTarif = new Tarif();
        createdTarif.setId(1L);
        createdTarif.setName("NewTarif");
        createdTarif.setRate(30.00);
        createdTarif.setLastModified(now);
    
        Mockito.when(tarifService.createTarif(any(Tarif.class))).thenReturn(createdTarif);
    
        MvcResult result = mockMvc.perform(post("/api/tarifs")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createdTarif)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(createdTarif.getId().intValue())))
                .andExpect(jsonPath("$.name", is(createdTarif.getName())))
                .andExpect(jsonPath("$.rate", is(createdTarif.getRate())))
                .andReturn();
    
        String lastModified = JsonPath.read(result.getResponse().getContentAsString(), "$.lastModified");
        LocalDateTime lastModifiedDateTime = LocalDateTime.parse(lastModified, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS"));
        assertEquals(now, lastModifiedDateTime);
    }

    @Test
    void testGetTarifById() throws Exception {
        Tarif tarif = new Tarif();
        tarif.setId(1L);
        tarif.setName("Tarif1");
        tarif.setRate(10.00);
        tarif.setLastModified(LocalDateTime.now());

        Mockito.when(tarifService.getTarifById(anyLong())).thenReturn(Optional.of(tarif));

        mockMvc.perform(get("/api/tarifs/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(tarif.getId().intValue())))
                .andExpect(jsonPath("$.name", is(tarif.getName())))
                .andExpect(jsonPath("$.rate", is(tarif.getRate())));
    }

    @Test
    void testUpdateTarif() throws Exception {
        Tarif tarif = new Tarif();
        tarif.setId(1L);
        tarif.setName("UpdatedTarif");
        tarif.setRate(15.00);
        tarif.setLastModified(LocalDateTime.now());

        Mockito.when(tarifService.updateTarif(anyLong(), anyDouble(), any(LocalDateTime.class))).thenReturn(tarif);

        String lastModifiedStr = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        mockMvc.perform(put("/api/tarifs/1")
                .param("rate", "15.00")
                .param("lastModified", lastModifiedStr))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(tarif.getId().intValue())))
                .andExpect(jsonPath("$.name", is(tarif.getName())))
                .andExpect(jsonPath("$.rate", is(tarif.getRate())));
    }

    @Test
    void testDeleteTarif() throws Exception {
        Mockito.when(tarifService.deleteTarif(anyLong())).thenReturn(true);

        mockMvc.perform(delete("/api/tarifs/1"))
                .andExpect(status().isNoContent());
    }
}
