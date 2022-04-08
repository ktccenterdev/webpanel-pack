package com.pack.service.services;

import com.pack.service.entities.Offre;
import com.pack.service.entities.Pack;
import com.pack.service.dto.PackRequestDTO;
import com.pack.service.dto.PackResponseDTO;
import com.pack.service.exceptions.SuppressionException;
import com.pack.service.mappers.PackMapper;
import org.springframework.stereotype.Service;
import com.pack.service.repositories.OffreRepository;
import com.pack.service.repositories.PackRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Transactional
public class PackServiceImpl implements PackService{

    private PackRepository packRepository;
    private PackMapper packMapper;
    private OffreRepository offreRepository;

    public PackServiceImpl(PackRepository packRepository, PackMapper packMapper, OffreRepository offreRepository) {
        this.packRepository = packRepository;
        this.packMapper = packMapper;
        this.offreRepository = offreRepository;
    }

    @Override
    public PackResponseDTO getOne(String id) {
        try {
            return packMapper.packToPackResponseDTO(packRepository.findById(id).get());
        } catch (Exception e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    @Override
    public List<PackResponseDTO> getAll() {
        try {
            return packRepository.findAll().stream()
                    .map(pack -> packMapper.packToPackResponseDTO(pack))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    @Override
    public PackResponseDTO save(PackRequestDTO packRequestDTO) {
        Pack pack = packMapper.packRequestDTOTOPack(packRequestDTO);
        pack.setId(UUID.randomUUID().toString());
        try {
            Offre offre = offreRepository.findById(packRequestDTO.getOffreId()).get();
            pack.setOffre(offre);
            return packMapper.packToPackResponseDTO(packRepository.save(pack));
        }catch (Exception exception){
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public PackResponseDTO update(PackRequestDTO packRequestDTO) {
        Pack pack = packMapper.packRequestDTOTOPack(packRequestDTO);
        try{
            Offre offre = offreRepository.findById(packRequestDTO.getOffreId()).get();
            pack.setOffre(offre);
            return packMapper.packToPackResponseDTO(packRepository.save(pack));
        }catch (Exception exception){
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        try {
            packRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }
}
