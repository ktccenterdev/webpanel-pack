package services;

import dto.PackDetailsRequestDTO;
import dto.PackDetailsResponseDTO;
import mappers.PackDetailsMapper;
import repositories.PackDetailsRepository;

import java.util.List;

public class PackDetailsServiceImpl implements PackDetailsService{

    private PackDetailsRepository packDetailsRepository;
    private PackDetailsMapper packDetailsMapper;

    public PackDetailsServiceImpl(PackDetailsRepository packDetailsRepository, PackDetailsMapper packDetailsMapper) {
        this.packDetailsRepository = packDetailsRepository;
        this.packDetailsMapper = packDetailsMapper;
    }

    @Override
    public PackDetailsResponseDTO getOne(String id) {
        return null;
    }

    @Override
    public List<PackDetailsResponseDTO> getAll() {
        return null;
    }

    @Override
    public PackDetailsResponseDTO save(PackDetailsRequestDTO packDetailsRequestDTO) {
        return null;
    }

    @Override
    public PackDetailsResponseDTO update(PackDetailsRequestDTO packDetailsRequestDTO) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
