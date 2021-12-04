package com.sanzar.ProductService.command.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.checkerframework.common.aliasing.qual.Unique;

import java.math.BigDecimal;

@Data
@Builder
public class CreateProductCommand {

    @TargetAggregateIdentifier
    private String productId;

    private String name;
    private BigDecimal price;
    private Integer quantity;
}
