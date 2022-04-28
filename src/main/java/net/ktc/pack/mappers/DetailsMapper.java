package net.ktc.pack.mappers;

import net.ktc.pack.dto.DetailsRequestDTO;
import net.ktc.pack.entities.Details;
import net.ktc.pack.dto.DetailsResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetailsMapper {
    DetailsResponseDTO detailsToDetailsResponseDTO(Details details);
    Details detailsRequestDTOTODetails(DetailsRequestDTO detailsRequestDTO);
}
