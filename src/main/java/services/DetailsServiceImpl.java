package services;

import dto.DetailsRequestDTO;
import dto.DetailsResponseDTO;
import mappers.DetailsMapper;
import repositories.DetailsRepository;

import java.util.List;

public class DetailsServiceImpl implements DetailsService{

    private DetailsRepository detailsRepository;
    private DetailsMapper detailsMapper;

    public DetailsServiceImpl(DetailsRepository detailsRepository, DetailsMapper detailsMapper) {
        this.detailsRepository = detailsRepository;
        this.detailsMapper = detailsMapper;
    }

    @Override
    public DetailsResponseDTO getOne(String id) {
        return null;
    }

    @Override
    public List<DetailsResponseDTO> getAll() {
        return null;
    }

    @Override
    public DetailsResponseDTO save(DetailsRequestDTO detailsRequestDTO) {
        return null;
    }

    @Override
    public DetailsResponseDTO update(DetailsRequestDTO detailsRequestDTO) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
