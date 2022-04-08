package com.pack.service.controller;

import java.util.List;

public interface IRestController<RequestDTO, ResponseDTO> {

    List<ResponseDTO> getAll();
    ResponseDTO getOne(String id);
    ResponseDTO save(RequestDTO requestDTO);
    ResponseDTO update(RequestDTO requestDTO);
    void delete(String id);

}
