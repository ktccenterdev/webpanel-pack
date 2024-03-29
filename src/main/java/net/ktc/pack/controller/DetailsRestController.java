package net.ktc.pack.controller;

import net.ktc.pack.dto.DetailsRequestDTO;
import net.ktc.pack.dto.DetailsResponseDTO;
import net.ktc.pack.services.DetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api")
@CrossOrigin("*")
public class DetailsRestController implements IRestController<DetailsRequestDTO, DetailsResponseDTO> {

    private DetailsService detailsService;

    public DetailsRestController(DetailsService detailsService) {
        this.detailsService = detailsService;
    }

    @Override
    @GetMapping(path="/details")
    public List<DetailsResponseDTO> getAll() {
        return detailsService.getAll();
    }

    @Override
    @GetMapping(path="/details/{id}")
    public DetailsResponseDTO getOne(@PathVariable(name = "id") String id) {
        return detailsService.getOne(id);
    }

    @Override
    @PostMapping(path="/details")
    public DetailsResponseDTO save(@RequestBody DetailsRequestDTO detailsRequestDTO) {
        return detailsService.save(detailsRequestDTO);
    }

    @Override
    @PutMapping(path="/details")
    public DetailsResponseDTO update(@RequestBody DetailsRequestDTO detailsRequestDTO) {
        return detailsService.update(detailsRequestDTO);
    }

    @Override
    @DeleteMapping(path="/details/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        detailsService.delete(id);
    }
}
