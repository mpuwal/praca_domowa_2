package com.example.praca_domowa_2.variants;

import com.example.praca_domowa_2.products.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("Plus")
public class Plus extends ProductService {

    @Value("${product-details.vat}")
    private double vat;

    @EventListener(ApplicationReadyEvent.class)
    public void get() {
        showProducts();
        System.out.println("Stawka VAT: " + vat);
        System.out.println("Razem brutto: " + Math.round(summaryPrice * (1 + vat)));
    }
}
