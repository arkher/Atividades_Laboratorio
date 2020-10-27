package com.example.calculadora.ControllerTest;

import com.example.calculadora.Services.OperationService;
import javax.ws.rs.core.MediaType;

import com.example.calculadora.Controller.OperationController;
import org.junit.jupiter.api.Test;
import com.example.calculadora.dto.EquationDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = OperationController.class)
@AutoConfigureMockMvc
public class OperationControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean   
    OperationService service;

    @Test
    public void shouldSum() throws Exception{
        EquationDTO dto = EquationDTO.builder().x(10).y(20).build();
        String result = "30";

        Mockito.when(service.sum(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(result);

        String json = new ObjectMapper().writeValueAsString(dto);
        
        MockHttpServletRequestBuilder request = 
                        MockMvcRequestBuilders.post("/calculator/sum")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json);

        mvc.perform(request)
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldSub() throws Exception{
        EquationDTO dto = EquationDTO.builder().x(10).y(8).build();
        String result = "2";

        Mockito.when(service.sub(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(result);

        String json = new ObjectMapper().writeValueAsString(dto);
        
        MockHttpServletRequestBuilder request = 
                        MockMvcRequestBuilders.post("/calculator/sub")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json);

        mvc.perform(request)
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldMult() throws Exception{
        EquationDTO dto = EquationDTO.builder().x(10).y(10).build();
        String result = "100";

        Mockito.when(service.mult(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(result);

        String json = new ObjectMapper().writeValueAsString(dto);
        
        MockHttpServletRequestBuilder request = 
                        MockMvcRequestBuilders.post("/calculator/mult")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json);

        mvc.perform(request)
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldDiv() throws Exception{
        EquationDTO dto = EquationDTO.builder().x(10).y(5).build();
        String result = "2";

        Mockito.when(service.div(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(result);

        String json = new ObjectMapper().writeValueAsString(dto);
        
        MockHttpServletRequestBuilder request = 
                        MockMvcRequestBuilders.post("/calculator/div")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json);

        mvc.perform(request)
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldExp() throws Exception{
        EquationDTO dto = EquationDTO.builder().x(10).y(2).build();
        String result = "100";

        Mockito.when(service.exp(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(result);

        String json = new ObjectMapper().writeValueAsString(dto);
        
        MockHttpServletRequestBuilder request = 
                        MockMvcRequestBuilders.post("/calculator/exp")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json);

        mvc.perform(request)
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
