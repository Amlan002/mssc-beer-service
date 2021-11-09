package com.beer.app.web.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.beer.app.web.domain.Beer;
import com.beer.app.web.model.BeerStyleEnum;
import com.beer.app.web.repository.BeerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "06312342000361";
    public static final String BEER_2_UPC = "06312343000192";
    public static final String BEER_3_UPC = "00837833752133";

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {

          if(beerRepository.count() == 0 ) {
              loadBeerObjects();
          }
    }

    private void loadBeerObjects() {
        Beer b1 = Beer.builder()
                .beerName("Corona")
                .beerStyle(BeerStyleEnum.IPA.name())
                .minOnHand(121)
                .quantityToBrew(2001)
                .price(new BigDecimal("12.95"))
                .upc(BEER_1_UPC)
                .build();

        Beer b2 = Beer.builder()
                .beerName("Kingfisher")
                .beerStyle(BeerStyleEnum.PALE_ALE.name())
                .minOnHand(122)
                .quantityToBrew(2002)
                .price(new BigDecimal("12.95"))
                .upc(BEER_2_UPC)
                .build();

        Beer b3 = Beer.builder()
                .beerName("Budb")
                .beerStyle(BeerStyleEnum.PALE_ALE.name())
                .minOnHand(123)
                .quantityToBrew(2003)
                .price(new BigDecimal("12.95"))
                .upc(BEER_3_UPC)
                .build();

        beerRepository.save(b1);
        beerRepository.save(b2);
        beerRepository.save(b3);
    }
}
