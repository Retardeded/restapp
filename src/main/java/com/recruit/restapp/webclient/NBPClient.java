package com.recruit.restapp.webclient;

import com.recruit.restapp.webclient.dto.CurrencyTableDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Component
public class NBPClient {

    private static final String NBP_URL = "http://api.nbp.pl/api/";
    private RestTemplate restTemplate = new RestTemplate();


    public Double getCurrencyValue(String currencyCode) {
        Double value = getCurrencyValueDto(NBP_URL + "exchangerates/rates/A/" + currencyCode + "/?format=json");
        return value;
    }

    private Double getCurrencyValueDto(String url) {

        try {
            ResponseEntity<CurrencyTableDto> rateResponse =
                    restTemplate.exchange(url,
                            HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                            });
            CurrencyTableDto table = rateResponse.getBody();

            return table.rates.get(0).mid;
        } catch (HttpStatusCodeException e) {
            throw new ResponseStatusException(NOT_FOUND, "Such currency code does not exist");
        }

    }


}
