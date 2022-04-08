package com.pack.service.controller;

import com.pack.service.dto.PackRequestDTO;
import com.pack.service.dto.PackResponseDTO;
import com.pack.service.services.PackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api")
public class PackRestController implements IRestController<PackRequestDTO, PackResponseDTO> {

    private PackService packService;

    public PackRestController(PackService packService) {
        this.packService = packService;
    }

    @Override
    @GetMapping(path="/packs")
    public List<PackResponseDTO> getAll() {
        return packService.getAll();
    }

    @Override
    @GetMapping(path="/packs/{id}")
    public PackResponseDTO getOne(@PathVariable(name = "id") String id) {
        return packService.getOne(id);
    }

    @Override
    @PostMapping(path="/packs")
    public PackResponseDTO save(@RequestBody PackRequestDTO packRequestDTO) {
        return packService.save(packRequestDTO);
    }

    @Override
    @PutMapping(path="/packs")
    public PackResponseDTO update(@RequestBody PackRequestDTO packRequestDTO) {
        return packService.update(packRequestDTO);
    }

    @Override
    @DeleteMapping("/packs/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        packService.delete(id);
    }
}
