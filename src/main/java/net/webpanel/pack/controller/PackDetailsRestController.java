package net.webpanel.pack.controller;

import net.webpanel.pack.dto.PackDetailsRequestDTO;
import net.webpanel.pack.dto.PackDetailsResponseDTO;
import net.webpanel.pack.services.PackDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api")
public class PackDetailsRestController implements IRestController<PackDetailsRequestDTO, PackDetailsResponseDTO> {

   private PackDetailsService packDetailsService;

    public PackDetailsRestController(PackDetailsService packDetailsService) {
        this.packDetailsService = packDetailsService;
    }

    @Override
    @GetMapping(path="/packsdetails")
    public List<PackDetailsResponseDTO> getAll() {
        return packDetailsService.getAll();
    }

    @Override
    @GetMapping(path="/packsdetails/{id}")
    public PackDetailsResponseDTO getOne(@PathVariable(name = "id") String id) {
        return packDetailsService.getOne(id);
    }

    @Override
    @PostMapping(path="/packsdetails")
    public PackDetailsResponseDTO save(@RequestBody PackDetailsRequestDTO packDetailsRequestDTO) {
        return packDetailsService.save(packDetailsRequestDTO);
    }

    @Override
    @PutMapping(path="/packsdetails")
    public PackDetailsResponseDTO update(@RequestBody PackDetailsRequestDTO packDetailsRequestDTO) {
        return packDetailsService.update(packDetailsRequestDTO);
    }

    @Override
    @DeleteMapping(path="/packsdetails")
    public void delete(@PathVariable(name = "id") String id) {
        packDetailsService.delete(id);
    }
}
