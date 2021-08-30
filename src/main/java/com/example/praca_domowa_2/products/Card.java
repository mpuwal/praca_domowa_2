package com.example.praca_domowa_2.products;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private Product product;

    public Product addToCard(String name, int price) {
        product = new Product(name,price);
        return product;
    }
}
