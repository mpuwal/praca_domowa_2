package com.example.praca_domowa_2.products;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductService implements IProduct {

    private final int MIN_PRICE = 50;
    private final int MAX_PRICE = 300;
    private List<Product> productList = new ArrayList<>();
    private Random rand;
    protected int summaryPrice;

    private Card card = new Card();

    @Value("${spring.profiles.active}")
    private String env;

    public ProductService() {

       productList.add(card.addToCard("Myszka",getPrice()));
       productList.add(card.addToCard("Klawiatura",getPrice()));
       productList.add(card.addToCard("Słuchawki",getPrice()));
       productList.add(card.addToCard("Podkładka",getPrice()));
       productList.add(card.addToCard("Głosnik",getPrice()));

        this.summaryPrice = productList.stream()
                .mapToInt((Product::getPrice))
                .sum();
    }

    public void showProducts() {
        System.out.println("Aktywny profil: " + env);
        productList.forEach(System.out::println);
        System.out.println("Razem netto: " + this.summaryPrice + " PLN");
    }

    private int getPrice() {
        rand = new Random();
        return rand.nextInt(MAX_PRICE-MIN_PRICE+1)+MIN_PRICE;
    }


}
