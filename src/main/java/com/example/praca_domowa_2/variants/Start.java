package com.example.praca_domowa_2.variants;

import com.example.praca_domowa_2.products.ProductService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("Start")
public class Start extends ProductService {

    @EventListener(ApplicationReadyEvent.class)
    public void get() {
        showProducts();
    }
}
