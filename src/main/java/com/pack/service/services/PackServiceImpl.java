package com.pack.service.services;

import com.pack.service.entities.Offre;
import com.pack.service.entities.Pack;
import com.pack.service.dto.PackRequestDTO;
import com.pack.service.dto.PackResponseDTO;
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
        return packMapper.packToPackResponseDTO(packRepository.findById(id).get());
    }

    @Override
    public List<PackResponseDTO> getAll() {
        return packRepository.findAll().stream()
                .map(pack -> packMapper.packToPackResponseDTO(pack))
                .collect(Collectors.toList());
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
            System.out.println(exception.getMessage());
            return null;
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
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public void delete(String id) {
        try {
            Pack pack = packRepository.findById(id).get();
            packRepository.delete(pack);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
