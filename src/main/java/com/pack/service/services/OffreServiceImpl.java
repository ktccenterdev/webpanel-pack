package com.pack.service.services;

import com.pack.service.entities.Offre;
import com.pack.service.dto.OffreRequestDTO;
import com.pack.service.dto.OffreResponseDTO;
import com.pack.service.mappers.OffreMapper;
import org.springframework.stereotype.Service;
import com.pack.service.repositories.OffreRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class OffreServiceImpl implements  OffreService{

    private OffreRepository offreRepository;
    private OffreMapper offreMapper;

    public OffreServiceImpl(OffreRepository offreRepository, OffreMapper offreMapper) {
        this.offreRepository = offreRepository;
        this.offreMapper = offreMapper;
    }

    @Override
    public OffreResponseDTO getOne(String id) {
        Offre offre = offreRepository.findById(id).get();
        return offreMapper.offreToOffreResponseDTO(offre);
    }

    @Override
    public List<OffreResponseDTO> getAll() {
        List<Offre> offres = offreRepository.findAll();
        return offres.stream()
                .map(offre -> offreMapper.offreToOffreResponseDTO(offre))
                .collect(Collectors.toList());
    }

    @Override
    public OffreResponseDTO save(OffreRequestDTO offreRequestDTO) {
        Offre offre = offreMapper.offreRequestDTOTOOffre(offreRequestDTO);
        offre.setId(UUID.randomUUID().toString());
        try {
            return offreMapper.offreToOffreResponseDTO(offreRepository.save(offre));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public OffreResponseDTO update(OffreRequestDTO offreRequestDTO) {
        Offre offre = offreMapper.offreRequestDTOTOOffre(offreRequestDTO);
        try {
            return offreMapper.offreToOffreResponseDTO(offreRepository.save(offre));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public void delete(String id) {
        try {
            offreRepository.deleteById(id);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
