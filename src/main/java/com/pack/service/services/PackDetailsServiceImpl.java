package com.pack.service.services;

import com.pack.service.entities.Details;
import com.pack.service.entities.Pack;
import com.pack.service.dto.PackDetailsRequestDTO;
import com.pack.service.dto.PackDetailsResponseDTO;
import com.pack.service.entities.PackDetails;
import com.pack.service.mappers.PackDetailsMapper;
import org.springframework.stereotype.Service;
import com.pack.service.repositories.DetailsRepository;
import com.pack.service.repositories.PackDetailsRepository;
import com.pack.service.repositories.PackRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class PackDetailsServiceImpl implements PackDetailsService{

    private PackDetailsRepository packDetailsRepository;
    private PackDetailsMapper packDetailsMapper;
    private PackRepository packRepository;
    private DetailsRepository detailsRepository;

    public PackDetailsServiceImpl(PackDetailsRepository packDetailsRepository,
                                  PackDetailsMapper packDetailsMapper,
                                  PackRepository packRepository, DetailsRepository detailsRepository) {
        this.packDetailsRepository = packDetailsRepository;
        this.packDetailsMapper = packDetailsMapper;
        this.packRepository = packRepository;
        this.detailsRepository = detailsRepository;
    }

    @Override
    public PackDetailsResponseDTO getOne(String id) {
        return packDetailsMapper.packDetailsToPackDetailsResponseDTO(packDetailsRepository.findById(id).get());
    }

    @Override
    public List<PackDetailsResponseDTO> getAll() {
        return packDetailsRepository.findAll().stream()
                .map(packDetails -> packDetailsMapper.packDetailsToPackDetailsResponseDTO(packDetails))
                .collect(Collectors.toList());
    }

    @Override
    public PackDetailsResponseDTO save(PackDetailsRequestDTO packDetailsRequestDTO) {
        PackDetails packDetails = packDetailsMapper.packDetailsRequestDTOTOPackDetails(packDetailsRequestDTO);
        packDetails.setId(UUID.randomUUID().toString());

        try {
            Pack pack = packRepository.findById(packDetailsRequestDTO.getPackId()).get();
            Details details = detailsRepository.findById(packDetailsRequestDTO.getDetailsId()).get();
            packDetails.setDetails(details);
            packDetails.setPack(pack);
            return packDetailsMapper.packDetailsToPackDetailsResponseDTO(packDetailsRepository.save(packDetails));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public PackDetailsResponseDTO update(PackDetailsRequestDTO packDetailsRequestDTO) {
        PackDetails packDetails = packDetailsMapper.packDetailsRequestDTOTOPackDetails(packDetailsRequestDTO);

        try {
            Pack pack = packRepository.findById(packDetailsRequestDTO.getPackId()).get();
            Details details = detailsRepository.findById(packDetailsRequestDTO.getDetailsId()).get();
            packDetails.setDetails(details);
            packDetails.setPack(pack);
            return packDetailsMapper.packDetailsToPackDetailsResponseDTO(packDetailsRepository.save(packDetails));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void delete(String id) {
        packDetailsRepository.deleteById(id);
    }
}
