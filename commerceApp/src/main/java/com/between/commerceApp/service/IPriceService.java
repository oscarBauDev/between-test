package com.between.commerceApp.service;

import com.between.commerceApp.model.dto.RequestDto;
import com.between.commerceApp.model.dto.ResponseDto;

public interface IPriceService {

    ResponseDto getPrice(RequestDto requestDto);
}
