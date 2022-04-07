package services;

import dto.PackRequestDTO;
import dto.PackResponseDTO;
import mappers.PackMapper;
import repositories.PackRepository;

import java.util.List;

public class PackServiceImpl implements PackService{

    private PackRepository packRepository;
    private PackMapper packMapper;

    public PackServiceImpl(PackRepository packRepository, PackMapper packMapper) {
        this.packRepository = packRepository;
        this.packMapper = packMapper;
    }

    @Override
    public PackResponseDTO getOne(String id) {
        return null;
    }

    @Override
    public List<PackResponseDTO> getAll() {
        return null;
    }

    @Override
    public PackResponseDTO save(PackRequestDTO packRequestDTO) {
        return null;
    }

    @Override
    public PackResponseDTO update(PackRequestDTO packRequestDTO) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
