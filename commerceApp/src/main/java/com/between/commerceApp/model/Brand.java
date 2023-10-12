package com.between.commerceApp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
