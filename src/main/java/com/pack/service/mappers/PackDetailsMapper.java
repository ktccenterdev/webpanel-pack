package com.pack.service.mappers;

import com.pack.service.dto.PackDetailsRequestDTO;
import com.pack.service.dto.PackDetailsResponseDTO;
import com.pack.service.entities.PackDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PackDetailsMapper {
    PackDetailsResponseDTO packDetailsToPackDetailsResponseDTO(PackDetails packDetails);
    PackDetails packDetailsRequestDTOTOPackDetails(PackDetailsRequestDTO packDetailsRequestDTO);
}
