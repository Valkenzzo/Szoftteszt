package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExchangeRateServiceTest {


    @Test
    void returnsStubbedRate() {
        ExchangeRateService rateService =
                mock(ExchangeRateService.class);

        when(rateService.getRate("EUR", "HUF"))
                .thenReturn(400.0);

        assertEquals(400.0, rateService.getRate("EUR", "HUF"));
    }
}
