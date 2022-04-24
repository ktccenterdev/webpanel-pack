package net.webpanel.pack.services;

import net.webpanel.pack.entities.Offre;
import net.webpanel.pack.dto.OffreRequestDTO;
import net.webpanel.pack.dto.OffreResponseDTO;
import net.webpanel.pack.mappers.OffreMapper;
import net.webpanel.pack.repositories.OffreRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class OffreServiceImpl implements  OffreService{

    private OffreRepository offreRepository;
    private OffreMapper offreMapper;

    public OffreServiceImpl(OffreRepository offreRepository, OffreMapper offreMapper) {
        this.offreRepository = offreRepository;
        this.offreMapper = offreMapper;
    }

    @Override
    public OffreResponseDTO getOne(String id) {
        try {
            Offre offre = offreRepository.findById(id).get();
            return offreMapper.offreToOffreResponseDTO(offre);
        } catch (Exception e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    @Override
    public List<OffreResponseDTO> getAll() {
        try {
            List<Offre> offres = offreRepository.findAll();
            return offres.stream()
                    .map(offre -> offreMapper.offreToOffreResponseDTO(offre))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    @Override
    public OffreResponseDTO save(OffreRequestDTO offreRequestDTO) {
        try {
            Offre offre = offreMapper.offreRequestDTOTOOffre(offreRequestDTO);
            offre.setId(UUID.randomUUID().toString());
            return offreMapper.offreToOffreResponseDTO(offreRepository.save(offre));
        } catch (Exception exception) {
            throw new RuntimeException(exception.getLocalizedMessage());
        }
    }

    @Override
    public OffreResponseDTO update(OffreRequestDTO offreRequestDTO) {
        try {
            Offre offre = offreMapper.offreRequestDTOTOOffre(offreRequestDTO);
            return offreMapper.offreToOffreResponseDTO(offreRepository.save(offre));
        } catch (Exception exception) {
            throw new RuntimeException(exception.getLocalizedMessage());
        }
    }

    @Override
    public void delete(String id) {
        try {
            offreRepository.deleteById(id);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getLocalizedMessage());
        }
    }
}
