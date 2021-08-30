package com.example.praca_domowa_2.variants;

import com.example.praca_domowa_2.products.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("Pro")
public class Pro extends ProductService {
    @Value("${product-details.vat}")
    private double vat;

    @Value("${product-details.discount}")
    private double discount;

    @EventListener(ApplicationReadyEvent.class)
    public void get() {
        showProducts();
        System.out.println("Stawka VAT: " + vat);
        System.out.println("Razem brutto: " + Math.round(summaryPrice * (1 + vat)));
        System.out.println("Razem brutto [po rabacie] " + Math.round(discount * 100) + "% : " + Math.round((summaryPrice * (1 + vat)) * (1 - discount)));
    }

}
