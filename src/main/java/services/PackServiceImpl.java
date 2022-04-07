package services;

import dto.PackRequestDTO;
import dto.PackResponseDTO;
import entities.Offre;
import entities.Pack;
import mappers.PackMapper;
import repositories.PackRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PackServiceImpl implements PackService{

    private PackRepository packRepository;
    private PackMapper packMapper;

    public PackServiceImpl(PackRepository packRepository, PackMapper packMapper) {
        this.packRepository = packRepository;
        this.packMapper = packMapper;
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
            return packMapper.packToPackResponseDTO(packRepository.save(pack));
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public PackResponseDTO update(PackRequestDTO packRequestDTO) {
        Pack pack = packMapper.packRequestDTOTOPack(packRequestDTO);
        try {
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
