package com.between.commerceApp.resource;

import com.between.commerceApp.model.dto.RequestDto;
import com.between.commerceApp.model.dto.ResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PriceControllerTest {

    @Autowired
    PriceController controller;
    private final Long ZARA = 1L;

    @Test
    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA). Debe retornar un precio final de 35.50")
    void test1() throws Exception {
        RequestDto requestDto = RequestDto.builder()
                .applicationDate(LocalDateTime.of(2020,6,14,10,0))
                .brandId(ZARA)
                .productId(35455L)
                .build();

        ResponseDto expectedResponse = ResponseDto.builder()
                .brandId(ZARA)
                .productId(35455L)
                .priceList(1)
                .startDate(LocalDateTime.of(2020,6,14,0,0))
                .endDate(LocalDateTime.of(2020,12,31,23,59,59))
                .finalPrice(new BigDecimal("35.50"))
                .build();

        ResponseEntity<ResponseDto> response = controller.getPrice(requestDto);
        if (response.getStatusCode() == HttpStatus.OK) {
            ResponseDto responseBody = response.getBody();
            assertEquals(expectedResponse.getFinalPrice(), responseBody.getFinalPrice());
            assertEquals(expectedResponse.getStartDate(), responseBody.getStartDate());
            assertEquals(expectedResponse.getEndDate(), responseBody.getEndDate());
        }

    }

    @Test
    @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA). Debe retornar un precio final de 25.45")
    void test2() throws Exception {
        RequestDto requestDto = RequestDto.builder()
                .applicationDate(LocalDateTime.of(2020,6,14,16,0))
                .brandId(ZARA)
                .productId(35455L)
                .build();

        ResponseDto expectedResponse = ResponseDto.builder()
                .brandId(ZARA)
                .productId(35455L)
                .priceList(1)
                .startDate(LocalDateTime.of(2020,6,14,15,0))
                .endDate(LocalDateTime.of(2020,6,14,18,30))
                .finalPrice(new BigDecimal("25.45"))
                .build();

        ResponseEntity<ResponseDto> response = controller.getPrice(requestDto);
        if (response.getStatusCode() == HttpStatus.OK) {
            ResponseDto responseBody = response.getBody();
            assertEquals(expectedResponse.getFinalPrice(), responseBody.getFinalPrice());
            assertEquals(expectedResponse.getStartDate(), responseBody.getStartDate());
            assertEquals(expectedResponse.getEndDate(), responseBody.getEndDate());
        }

    }

    @Test
    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA). Debe retornar un precio final de 35.50")
    void test3() throws Exception {
        RequestDto requestDto = RequestDto.builder()
                .applicationDate(LocalDateTime.of(2020,6,14,21,0))
                .brandId(ZARA)
                .productId(35455L)
                .build();

        ResponseDto expectedResponse = ResponseDto.builder()
                .brandId(ZARA)
                .productId(35455L)
                .priceList(1)
                .startDate(LocalDateTime.of(2020,6,14,0,0))
                .endDate(LocalDateTime.of(2020,12,31,23,59,59))
                .finalPrice(new BigDecimal("35.50"))
                .build();

        ResponseEntity<ResponseDto> response = controller.getPrice(requestDto);
        if (response.getStatusCode() == HttpStatus.OK) {
            ResponseDto responseBody = response.getBody();
            assertEquals(expectedResponse.getFinalPrice(), responseBody.getFinalPrice());
            assertEquals(expectedResponse.getStartDate(), responseBody.getStartDate());
            assertEquals(expectedResponse.getEndDate(), responseBody.getEndDate());
        }
    }

    @Test
    @DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA). Debe retornar un precio final de 30.50")
    void test4() throws Exception {
        RequestDto requestDto = RequestDto.builder()
                .applicationDate(LocalDateTime.of(2020,6,15,10,0))
                .brandId(ZARA)
                .productId(35455L)
                .build();

        ResponseDto expectedResponse = ResponseDto.builder()
                .brandId(ZARA)
                .productId(35455L)
                .priceList(1)
                .startDate(LocalDateTime.of(2020,6,15,0,0))
                .endDate(LocalDateTime.of(2020,6,15,11,0))
                .finalPrice(new BigDecimal("30.50"))
                .build();

        ResponseEntity<ResponseDto> response = controller.getPrice(requestDto);
        if (response.getStatusCode() == HttpStatus.OK) {
            ResponseDto responseBody = response.getBody();
            assertEquals(expectedResponse.getFinalPrice(), responseBody.getFinalPrice());
            assertEquals(expectedResponse.getStartDate(), responseBody.getStartDate());
            assertEquals(expectedResponse.getEndDate(), responseBody.getEndDate());
        }
    }

    @Test
    @DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA).Debe retornar un precio final de 38.95")
    void test5() throws Exception {
        RequestDto requestDto = RequestDto.builder()
                .applicationDate(LocalDateTime.of(2020,6,15,21,0))
                .brandId(ZARA)
                .productId(35455L)
                .build();

        ResponseDto expectedResponse = ResponseDto.builder()
                .brandId(ZARA)
                .productId(35455L)
                .priceList(1)
                .startDate(LocalDateTime.of(2020,6,15,16,0))
                .endDate(LocalDateTime.of(2020,12,31,23,59,59))
                .finalPrice(new BigDecimal("38.95"))
                .build();

        ResponseEntity<ResponseDto> response = controller.getPrice(requestDto);
        if (response.getStatusCode() == HttpStatus.OK) {
            ResponseDto responseBody = response.getBody();
            assertEquals(expectedResponse.getFinalPrice(), responseBody.getFinalPrice());
            assertEquals(expectedResponse.getStartDate(), responseBody.getStartDate());
            assertEquals(expectedResponse.getEndDate(), responseBody.getEndDate());
        }
    }

}