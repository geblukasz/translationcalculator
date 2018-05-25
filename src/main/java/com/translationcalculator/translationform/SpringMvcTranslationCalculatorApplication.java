package com.translationcalculator.translationform;

import com.translationcalculator.translationform.calculator.Calculator;
import com.translationcalculator.translationform.calculator.CatToolsCalculator;
import com.translationcalculator.translationform.calculator.StandardCalculator;
import com.translationcalculator.translationform.config.StorageProperties;
import com.translationcalculator.translationform.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import static com.translationcalculator.translationform.Utils.Variables.*;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SpringMvcTranslationCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcTranslationCalculatorApplication.class, args);

    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }


    public static void calc() {

        Calculator calculator = new StandardCalculator(false, 11111, PAGE_VOLUME_PL_EN_NO_TAX_NO_CAT, STAKE_PL_EN_NO_TAX_NO_CAT);
        System.out.println("Cena bez vat i bez cat PL-EN: " + calculator.prepareRoundedPrice());

        Calculator calculator2 = new StandardCalculator(false, 11111, PAGE_VOLUME_EN_PL_NO_TAX_NO_CAT, STAKE_EN_PL_NO_TAX_NO_CAT);
        System.out.println("Cena bez vat i bez cat EN-PL: " + calculator2.prepareRoundedPrice());

        Calculator calculator3 = new StandardCalculator(true, 11111, PAGE_VOLUME_PL_EN_NO_TAX_NO_CAT, STAKE_PL_EN_WITH_TAX_NO_CAT);
        System.out.println("Cena z vat i bez cat PL-EN: " + calculator3.prepareRoundedPrice());

        Calculator calculator4 = new StandardCalculator(true, 11111, PAGE_VOLUME_EN_PL_WITH_TAX_NO_CAT, STAKE_EN_PL_WITH_TAX_NO_CAT);
        System.out.println("Cena z vat i bez cat EN-PL: " + calculator4.prepareRoundedPrice());

        Calculator calculator5 = new CatToolsCalculator(false, ONE_WORD_PRICE_PL_EN_NO_TAX_WITH_CAT, 100, 55, 2000);
        System.out.println("Cena bez vat i z cat PL-EN: " + calculator5.prepareRoundedPrice());

        Calculator calculator6 = new CatToolsCalculator(false, ONE_WORD_PRICE_EN_PL_NO_TAX_WITH_CAT, 100, 55, 2000);
        System.out.println("Cena bez vat i z cat EN-PL: " + calculator6.prepareRoundedPrice());

        Calculator calculator7 = new CatToolsCalculator(true, ONE_WORD_PRICE_PL_EN_NO_TAX_WITH_CAT, 100, 55, 2000);
        System.out.println("Cena z vat i z cat PL-EN: " + calculator7.prepareRoundedPrice());

        Calculator calculator8 = new CatToolsCalculator(true, ONE_WORD_PRICE_EN_PL_NO_TAX_WITH_CAT, 100, 55, 2000);
        System.out.println("Cena z vat i z cat EN-PL: " + calculator8.prepareRoundedPrice());

    }
}

