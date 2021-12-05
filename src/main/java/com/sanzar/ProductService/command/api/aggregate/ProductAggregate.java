package com.sanzar.ProductService.command.api.aggregate;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.sanzar.ProductService.command.api.commands.CreateProductCommand;
import com.sanzar.ProductService.command.api.event.ProductCreatedEvent;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {
    @AggregateIdentifier
    private String productId;

    private String name;
    private BigDecimal price;
    private Integer quantity;


    public ProductAggregate(CreateProductCommand createProductCommand)
    {
        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
        BeanUtils.copyProperties(createProductCommand,productCreatedEvent);
    }
    public ProductAggregate()
    {

    }
    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent)
    {

        this.quantity=productCreatedEvent.getQuantity();
        this.name=productCreatedEvent.getName();
        this.price=productCreatedEvent.getPrice();
        this.productId=productCreatedEvent.getProductId();
    }
}
