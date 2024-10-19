package com.graphql.inventorymanagement.entity;

public record ProductInput(String name,
 String category,
 Float price,
Integer stock) {

}
