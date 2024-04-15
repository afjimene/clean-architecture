package com.ecommerce.product.mapper;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "status")
public class StatusDataMapper {
    @Id
    Integer status;
    @NotBlank(message = "Name is required")
    String statusName;

    public Integer getStatus() {
        return status;
    }

    public String getStatusName() {
        return statusName;
    }
}
