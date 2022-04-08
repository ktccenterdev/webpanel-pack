package com.pack.service.services;

import com.pack.service.dto.DetailsRequestDTO;
import com.pack.service.entities.Details;
import com.pack.service.entities.Offre;
import com.pack.service.dto.DetailsResponseDTO;
import com.pack.service.mappers.DetailsMapper;
import org.springframework.stereotype.Service;
import com.pack.service.repositories.DetailsRepository;
import com.pack.service.repositories.OffreRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class DetailsServiceImpl implements DetailsService{

    private DetailsRepository detailsRepository;
    private DetailsMapper detailsMapper;
    private OffreRepository offreRepository;

    public DetailsServiceImpl(DetailsRepository detailsRepository, DetailsMapper detailsMapper, OffreRepository offreRepository) {
        this.detailsRepository = detailsRepository;
        this.detailsMapper = detailsMapper;
        this.offreRepository = offreRepository;
    }

    @Override
    public DetailsResponseDTO getOne(String id) {
        return detailsMapper.detailsToDetailsResponseDTO(detailsRepository.findById(id).get());
    }

    @Override
    public List<DetailsResponseDTO> getAll() {
        return detailsRepository.findAll().stream()
                .map(details -> detailsMapper.detailsToDetailsResponseDTO(details))
                .collect(Collectors.toList());
    }

    @Override
    public DetailsResponseDTO save(DetailsRequestDTO detailsRequestDTO) {
        Details details = detailsMapper.detailsRequestDTOTODetails(detailsRequestDTO);
        details.setId(UUID.randomUUID().toString());
        try {
            Offre offre = offreRepository.findById(detailsRequestDTO.getOffreId()).get();
            details.setOffre(offre);
            return detailsMapper.detailsToDetailsResponseDTO(detailsRepository.save(details));
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public DetailsResponseDTO update(DetailsRequestDTO detailsRequestDTO) {
        Details details = detailsMapper.detailsRequestDTOTODetails(detailsRequestDTO);
        try {
            Offre offre = offreRepository.findById(detailsRequestDTO.getOffreId()).get();
            details.setOffre(offre);
            return detailsMapper.detailsToDetailsResponseDTO(detailsRepository.save(details));
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public void delete(String id) {
        try {
            detailsRepository.deleteById(id);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
