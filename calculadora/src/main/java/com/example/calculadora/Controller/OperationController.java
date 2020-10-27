package com.example.calculadora.Controller;

import com.example.calculadora.dto.EquationDTO;
import com.example.calculadora.Services.OperationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/calculator")
public class OperationController {
    @Autowired
    OperationService service;

    double resultado;

    @PostMapping("/sum")
    public ResponseEntity sum(@RequestBody EquationDTO eq) {
        EquationDTO equacao = EquationDTO.builder().x(eq.getX()).y(eq.getY()).build();

        try {
            resultado = Double.parseDouble(service.sum(equacao.getX(), equacao.getY()));
            return new ResponseEntity(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }

    @PostMapping("/sub")
    public ResponseEntity sub(@RequestBody EquationDTO eq) {
        EquationDTO equacao = EquationDTO.builder().x(eq.getX()).y(eq.getY()).build();

        try {
            resultado = Double.parseDouble(service.sub(equacao.getX(), equacao.getY()));
            return new ResponseEntity(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }

    @PostMapping("/mult")
    public ResponseEntity mult(@RequestBody EquationDTO eq) {
        EquationDTO equacao = EquationDTO.builder().x(eq.getX()).y(eq.getY()).build();

        try {
            resultado = Double.parseDouble(service.mult(equacao.getX(), equacao.getY()));
            return new ResponseEntity(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/div")
    public ResponseEntity div(@RequestBody EquationDTO eq) {        
        EquationDTO equacao = EquationDTO.builder().x(eq.getX()).y(eq.getY()).build();

        try {
            resultado = Double.parseDouble(service.div(equacao.getX(), equacao.getY()));
            return new ResponseEntity(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/exp")
    public ResponseEntity exp(@RequestBody EquationDTO eq) { 
        EquationDTO equacao = EquationDTO.builder().x(eq.getX()).y(eq.getY()).build();

        try {
            resultado = Double.parseDouble(service.exp(equacao.getX(), equacao.getY()));
            return new ResponseEntity(resultado, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    
}