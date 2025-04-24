package br.com.futurodev.exercicios09.exercicio.controllers;

import br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointsDtos.CollectionPointRequestDto;
import br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointsDtos.CollectionPointResponseDto;
import br.com.futurodev.exercicios09.exercicio.services.CollectionPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("collectionPoint")
public class CollectionPointController {
    
    private final CollectionPointService service;
    
    @GetMapping
    public List <CollectionPointResponseDto> findAll() {
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public CollectionPointResponseDto findById(Long id) {
        return service.findById(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CollectionPointResponseDto create(CollectionPointRequestDto dto) {
        return service.create(dto);
    }
    
    @PutMapping("/{id}")
    public CollectionPointResponseDto update(@PathVariable Long id, CollectionPointRequestDto dto) {
        return service.update(id, dto);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
