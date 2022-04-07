package com.pack.service.mappers;

import com.pack.service.dto.DetailsRequestDTO;
import com.pack.service.entities.Details;
import com.pack.service.dto.DetailsResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetailsMapper {
    DetailsResponseDTO detailsToDetailsResponseDTO(Details details);
    Details detailsRequestDTOTODetails(DetailsRequestDTO detailsRequestDTO);
}
