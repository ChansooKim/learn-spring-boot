package com.csk.learnspringboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CurrencyConfigurationController {

    @Autowired
    private CurrencyServiceConfiguration currencyServiceConfiguration;

    @RequestMapping("/currency-configuration")
    public CurrencyServiceConfiguration retrieveAllCourses() {
        return currencyServiceConfiguration;
    }
}
