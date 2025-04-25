package br.com.futurodev.exercicios09.exercicio.services;

import br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointMaterialResponseDto.CollectionPointMaterialRequestDto;
import br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointsDtos.CollectionPointRequestDto;
import br.com.futurodev.exercicios09.exercicio.dtos.CollectionPointsDtos.CollectionPointResponseDto;
import br.com.futurodev.exercicios09.exercicio.entities.CollectionPoint;
import br.com.futurodev.exercicios09.exercicio.entities.CollectionPointMaterial;
import br.com.futurodev.exercicios09.exercicio.entities.ElectronicWaste;
import br.com.futurodev.exercicios09.exercicio.erros.expections.badRequest.CollectionPointMaterialRequiredAttributeException;
import br.com.futurodev.exercicios09.exercicio.erros.expections.badRequest.CollectionPointRequiredAttributeException;
import br.com.futurodev.exercicios09.exercicio.erros.expections.notFound.CollectionPointNotFoundException;
import br.com.futurodev.exercicios09.exercicio.erros.expections.notFound.NotFoundException;
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
        CollectionPoint cp = findEntityById(id);
        repository.delete(cp);
    }

    @Override
    public List<CollectionPointResponseDto> findAllProductsByName(String name) {
        List<CollectionPoint> collectionPoints = repository.findAllByName(name);

        return CollectionPointMapper.toResponseDtos(collectionPoints);
    }

    private CollectionPoint findEntityById (Long id) {
        return repository.findById(id).orElseThrow(() -> new CollectionPointNotFoundException(id));
    }

    private CollectionPointResponseDto save(CollectionPoint cp, CollectionPointRequestDto dto){

        validationDto(dto);
        CollectionPointMapper.toEntity(cp,dto);

        for (CollectionPointMaterialRequestDto materialDto : dto.materials()) {
            CollectionPointMaterial cpMaterial = new CollectionPointMaterial();
            if (materialDto.maxCapacity() == null) {
                throw new CollectionPointMaterialRequiredAttributeException("maxCapacity");
            }
            cpMaterial.setCollectionPoint(cp);
            cpMaterial.setMaxCapacity(materialDto.maxCapacity());

            if (materialDto.electronicWasteId() == null) {
                throw new CollectionPointMaterialRequiredAttributeException("electronicWasteId");
            }
            ElectronicWaste ew = electronicWasteService.findEntityById(materialDto.electronicWasteId());
            cpMaterial.setElectronicWaste(ew);

            cp.getMaterials().add(cpMaterial);


        }

        return CollectionPointMapper.toResponseDto(repository.save(cp));
    }

    public  void validationDto(CollectionPointRequestDto dto) {
        if (dto.name() == null || dto.name().isBlank()) {
            throw new CollectionPointRequiredAttributeException("name");
        }
        if (dto.address() == null || dto.address().isBlank()) {
            throw new CollectionPointRequiredAttributeException("address");
        }
        if (dto.collectionDay() == null || dto.collectionDay().isBlank()) {
            throw new CollectionPointRequiredAttributeException("collectionDay");
        }

    }
}
