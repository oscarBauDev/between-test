package com.between.commerceApp.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RequestDto {

    @NotNull(message = "Application date must not be empty")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime applicationDate;
    @NotNull(message = "Product id must not be null")
    private Long productId;
    @NotNull(message = "Brand id id must not be null")
    private Long brandId;
}
