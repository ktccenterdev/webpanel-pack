package net.webpanel.pack.controller;

import net.webpanel.pack.dto.OffreRequestDTO;
import net.webpanel.pack.dto.OffreResponseDTO;
import net.webpanel.pack.exceptions.APIException;
import net.webpanel.pack.services.OffreService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/api")
@CrossOrigin(origins = "*")
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
    public OffreResponseDTO save(@Valid @RequestBody OffreRequestDTO offreRequestDTO) {
        if(offreRequestDTO.getIntitule() == "") throw new APIException("Intitulé obligatoire");
        return offreService.save(offreRequestDTO);
       // return new ResponseEntity<OffreResponseDTO>(offreRequestDTO, HttpStatus.OK);
    }

    @Override
    @PutMapping(path="/offres")
    public OffreResponseDTO update(@Valid @RequestBody OffreRequestDTO offreRequestDTO) {
        return offreService.update(offreRequestDTO);
    }

    @Override
    @DeleteMapping(path="/offres/{id}")
    public void delete(@PathVariable(name="id") String id) {
        offreService.delete(id);
    }
}
