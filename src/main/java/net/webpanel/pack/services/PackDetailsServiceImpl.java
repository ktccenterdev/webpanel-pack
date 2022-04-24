package net.webpanel.pack.services;

import net.webpanel.pack.entities.Details;
import net.webpanel.pack.entities.Pack;
import net.webpanel.pack.dto.PackDetailsRequestDTO;
import net.webpanel.pack.dto.PackDetailsResponseDTO;
import net.webpanel.pack.entities.PackDetails;
import net.webpanel.pack.mappers.PackDetailsMapper;
import net.webpanel.pack.repositories.DetailsRepository;
import org.springframework.stereotype.Service;
import net.webpanel.pack.repositories.PackDetailsRepository;
import net.webpanel.pack.repositories.PackRepository;

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
        try {
            return packDetailsMapper.packDetailsToPackDetailsResponseDTO(packDetailsRepository.findById(id).get());
        } catch (Exception e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    @Override
    public List<PackDetailsResponseDTO> getAll() {
        try {
            return packDetailsRepository.findAll().stream()
                    .map(packDetails -> packDetailsMapper.packDetailsToPackDetailsResponseDTO(packDetails))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
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
            throw new RuntimeException(e.getLocalizedMessage());
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
        }catch (Exception exception){
            throw new RuntimeException(exception.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        try {
            packDetailsRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }
}
