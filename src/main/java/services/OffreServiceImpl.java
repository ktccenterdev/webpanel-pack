package services;

import dto.OffreRequestDTO;
import dto.OffreResponseDTO;
import mappers.OffreMapper;
import repositories.OffreRepository;

import java.util.List;

public class OffreServiceImpl implements  OffreService{

    private OffreRepository offreRepository;
    private OffreMapper offreMapper;

    public OffreServiceImpl(OffreRepository offreRepository, OffreMapper offreMapper) {
        this.offreRepository = offreRepository;
        this.offreMapper = offreMapper;
    }

    @Override
    public OffreResponseDTO getOne(String id) {
        return null;
    }

    @Override
    public List<OffreResponseDTO> getAll() {
        return null;
    }

    @Override
    public OffreResponseDTO save(OffreRequestDTO offreRequestDTO) {
        return null;
    }

    @Override
    public OffreResponseDTO update(OffreRequestDTO offreRequestDTO) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
