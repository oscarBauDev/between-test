package com.between.commerceApp.resource;

import com.between.commerceApp.model.dto.RequestDto;
import com.between.commerceApp.model.dto.ResponseDto;
import com.between.commerceApp.service.IPriceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/prices")
public class PriceController {

    private final IPriceService service;

    public PriceController(IPriceService service) {
        this.service = service;
    }

    @PostMapping("/price")
    public ResponseEntity<ResponseDto> getPrice(@Valid @RequestBody RequestDto requestDto){
        return ResponseEntity.ok(service.getPrice(requestDto));
    }
}
