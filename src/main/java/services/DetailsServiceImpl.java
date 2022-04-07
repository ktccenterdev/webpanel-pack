package services;

import dto.DetailsRequestDTO;
import dto.DetailsResponseDTO;
import entities.Details;
import entities.Offre;
import mappers.DetailsMapper;
import repositories.DetailsRepository;
import repositories.OffreRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
            Details details = detailsRepository.findById(id).get();
            detailsRepository.delete(details);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
