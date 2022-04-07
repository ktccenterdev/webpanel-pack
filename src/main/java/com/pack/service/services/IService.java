package com.pack.service.services;

import java.util.List;

public interface IService<RequestDTO, ResponseDTO> {
    ResponseDTO getOne(String id);
    List<ResponseDTO> getAll();
    ResponseDTO save(RequestDTO requestDTO);
    ResponseDTO update(RequestDTO requestDTO);
    void delete(String id);
}
