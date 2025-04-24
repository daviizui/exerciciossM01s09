package br.com.futurodev.exercicios09.exercicio.services;

import br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointMaterialResponseDto.CollectionPointMaterialRequestDto;
import br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointsDtos.CollectionPointRequestDto;
import br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointsDtos.CollectionPointResponseDto;
import br.com.futurodev.exercicios09.exercicio.entities.CollectionPoint;
import br.com.futurodev.exercicios09.exercicio.entities.CollectionPointMaterial;
import br.com.futurodev.exercicios09.exercicio.entities.ElectronicWaste;
import br.com.futurodev.exercicios09.exercicio.mappers.CollectionPointMapper;
import br.com.futurodev.exercicios09.exercicio.repositories.CollectionPointRepository;
import br.com.futurodev.exercicios09.exercicio.repositories.ElectronicWasteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CollectionPointServiceImpl implements CollectionPointService {

    private final CollectionPointRepository repository;
    private final ElectronicWasteService electronicWasteService;


    @Override
    public List<CollectionPointResponseDto> findAll() {
        List<CollectionPoint> electronicWastes = repository.findAll();
        return CollectionPointMapper.toResponseDtos(electronicWastes);
    }

    @Override
    public CollectionPointResponseDto findById(Long id) {
        CollectionPoint electronicWaste = findEntityById(id);
        return CollectionPointMapper.toResponseDto(electronicWaste);
    }

    @Override
    public CollectionPointResponseDto create(CollectionPointRequestDto dto) {
       return save(new CollectionPoint(), dto);
    }

    @Override
    public CollectionPointResponseDto update(Long id, CollectionPointRequestDto dto) {
        CollectionPoint cp = findEntityById(id);
        return save(cp, dto);
    }

    @Override
    public void delete(Long id) {
        CollectionPoint ew = findEntityById(id);
        repository.delete(ew);
    }

    private CollectionPoint findEntityById (Long id) {
        return repository.findById(id).orElseThrow(null);
    }

    private CollectionPointResponseDto save(CollectionPoint cp, CollectionPointRequestDto dto){
        CollectionPointMapper.toEntity(cp,dto);

        for (CollectionPointMaterialRequestDto materialDto : dto.materials()) {
            CollectionPointMaterial cpMaterial = new CollectionPointMaterial();
            cpMaterial.setCollectionPoint(cp);
            cpMaterial.setMaxCapacity(materialDto.maxCapacity());

            ElectronicWaste ew = electronicWasteService.findEntityById(materialDto.electronicWasteId());
            cpMaterial.setElectronicWaste(ew);

            cp.getMaterials().add(cpMaterial);


        }

        return CollectionPointMapper.toResponseDto(repository.save(cp));
    }
}
