package com.pack.service.dto;

import lombok.Data;

import java.util.Date;

@Data
public abstract class AbstractDefaultValuesResponseDTO {
    private Date created;
    private Date update;
    private Boolean isDefault;
    private Boolean isVisible;
}

