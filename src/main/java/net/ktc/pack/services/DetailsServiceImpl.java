package net.ktc.pack.services;

import net.ktc.pack.entities.Offre;
import net.ktc.pack.dto.DetailsRequestDTO;
import net.ktc.pack.entities.Details;
import net.ktc.pack.dto.DetailsResponseDTO;
import net.ktc.pack.mappers.DetailsMapper;
import net.ktc.pack.repositories.DetailsRepository;
import net.ktc.pack.repositories.OffreRepository;
import org.springframework.stereotype.Service;

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
        try{
            return detailsMapper.detailsToDetailsResponseDTO(detailsRepository.findById(id).get());
        }catch(Exception exception){
            throw new RuntimeException(exception.getLocalizedMessage());
        }
    }

    @Override
    public List<DetailsResponseDTO> getAll() {
        try{
            return detailsRepository.findAll().stream()
                    .map(details -> detailsMapper.detailsToDetailsResponseDTO(details))
                    .collect(Collectors.toList());
        }catch (Exception exception){
            throw new RuntimeException(exception.getLocalizedMessage());
        }

    }

    @Override
    public DetailsResponseDTO save(DetailsRequestDTO detailsRequestDTO) {
        try {
            Details details = detailsMapper.detailsRequestDTOTODetails(detailsRequestDTO);
            details.setId(UUID.randomUUID().toString());
            Offre offre = offreRepository.findById(detailsRequestDTO.getOffreId()).get();
            details.setOffre(offre);
            return detailsMapper.detailsToDetailsResponseDTO(detailsRepository.save(details));
        }catch (Exception exception){
            throw new RuntimeException(exception.getLocalizedMessage());
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
            throw new RuntimeException(exception.getLocalizedMessage());
        }
    }

    @Override
    public void delete(String id) {
        try {
            detailsRepository.deleteById(id);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getLocalizedMessage());
        }
    }
}
