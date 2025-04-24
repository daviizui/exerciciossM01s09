package br.com.futurodev.exercicios09.exercicio.services;

import br.com.futurodev.exercicios09.exercicio.dtos.ElectronicWastesDtos.ElectronicWasteRequestDto;
import br.com.futurodev.exercicios09.exercicio.dtos.ElectronicWastesDtos.ElectronicWasteResponseDto;
import br.com.futurodev.exercicios09.exercicio.entities.ElectronicWaste;
import br.com.futurodev.exercicios09.exercicio.mappers.ElectronicWasteMapper;
import br.com.futurodev.exercicios09.exercicio.repositories.ElectronicWasteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElectronicWasteServiceImpl implements ElectronicWasteService {

    private final ElectronicWasteRepository repository;


    @Override
    public List<ElectronicWasteResponseDto> findAll() {
        List<ElectronicWaste> electronicWastes = repository.findAll();
        return ElectronicWasteMapper.toResponseDtos(electronicWastes);
    }

    @Override
    public ElectronicWasteResponseDto findById(Long id) {
        ElectronicWaste electronicWaste = findEntityById(id);
        return ElectronicWasteMapper.toResponseDto(electronicWaste);
    }

    @Override
    public ElectronicWasteResponseDto create(ElectronicWasteRequestDto dto) {
        ElectronicWaste ew = ElectronicWasteMapper.toEntity(new ElectronicWaste(),dto);
        return ElectronicWasteMapper.toResponseDto(repository.save(ew));
    }

    @Override
    public ElectronicWasteResponseDto update(Long id, ElectronicWasteRequestDto dto) {
        ElectronicWaste ew = findEntityById(id);
        ElectronicWasteMapper.toEntity(ew,dto);
        return ElectronicWasteMapper.toResponseDto(repository.save(ew));
    }

    @Override
    public void delete(Long id) {
        ElectronicWaste ew = findEntityById(id);
        repository.delete(ew);
    }

    public ElectronicWaste findEntityById (Long id) {
        return repository.findById(id).orElseThrow(null);
    }
}
