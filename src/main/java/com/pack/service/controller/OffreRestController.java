package com.pack.service.controller;

import com.pack.service.dto.OffreRequestDTO;
import com.pack.service.dto.OffreResponseDTO;
import com.pack.service.services.OffreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api")
public class OffreRestController implements IRestController<OffreRequestDTO, OffreResponseDTO> {
    private OffreService offreService;

    public OffreRestController(OffreService offreService) {
        this.offreService = offreService;
    }

    @Override
    @GetMapping(path="/offres")
    public List<OffreResponseDTO> getAll() {
        return offreService.getAll();
    }

    @Override
    @GetMapping(path="/offres/{id}")
    public OffreResponseDTO getOne(@PathVariable(name="id") String id) {
        return offreService.getOne(id);
    }

    @Override
    @PostMapping(path="/offres")
    public OffreResponseDTO save(@RequestBody OffreRequestDTO offreRequestDTO) {
        return offreService.save(offreRequestDTO);
    }

    @Override
    @PutMapping(path="/offres")
    public OffreResponseDTO update(@RequestBody OffreRequestDTO offreRequestDTO) {
        return offreService.update(offreRequestDTO);
    }

    @Override
    @DeleteMapping(path="/offres/{id}")
    public void delete(@PathVariable(name="id") String id) {
        offreService.delete(id);
    }
}
