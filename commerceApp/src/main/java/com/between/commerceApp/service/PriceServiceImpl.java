package com.between.commerceApp.service;

import com.between.commerceApp.exception.NotFoundException;
import com.between.commerceApp.model.Price;
import com.between.commerceApp.model.dto.RequestDto;
import com.between.commerceApp.model.dto.ResponseDto;
import com.between.commerceApp.repository.IPriceRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class PriceServiceImpl implements IPriceService {

    private final IPriceRepository repository;

    public PriceServiceImpl(IPriceRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseDto getPrice(RequestDto requestDto) {
       Price finalPrice= repository.findPrices(requestDto.getBrandId(), requestDto.getProductId(), requestDto.getApplicationDate()).stream()
               .max(Comparator.comparing(Price::getPriority)).orElseThrow(() -> new NotFoundException("Not price found in the provided date"));

        return mapPriceToResponseDto(finalPrice);
    }

    private ResponseDto mapPriceToResponseDto(Price price){
        ResponseDto response = new ResponseDto();
        response.setBrandId(price.getBrand().getId());
        response.setProductId(price.getProductId());
        response.setPriceList(price.getPriceList());
        response.setStartDate(price.getStartDate());
        response.setEndDate(price.getEndDate());
        response.setFinalPrice(price.getPrice());
        return response;
    }
}
