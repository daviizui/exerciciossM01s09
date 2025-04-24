package br.com.futurodev.exercicios09.exercicio.services;

import br.com.futurodev.exercicios09.exercicio.dtos.ElectronicWastesDtos.ElectronicWasteRequestDto;
import br.com.futurodev.exercicios09.exercicio.dtos.ElectronicWastesDtos.ElectronicWasteResponseDto;
import br.com.futurodev.exercicios09.exercicio.entities.ElectronicWaste;

import java.util.List;

public interface ElectronicWasteService {

    List<ElectronicWasteResponseDto> findAll();
    ElectronicWasteResponseDto findById(Long id);
    ElectronicWasteResponseDto create(ElectronicWasteRequestDto dto);
    ElectronicWasteResponseDto update(Long id, ElectronicWasteRequestDto dto);
    void delete(Long id);

    ElectronicWaste findEntityById (Long id);
}
