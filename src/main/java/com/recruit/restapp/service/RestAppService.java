package com.recruit.restapp.service;

import com.recruit.restapp.model.NumbersSortData;
import com.recruit.restapp.webclient.NBPClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import static org.springframework.http.HttpStatus.*;

@Service
public class RestAppService {

    private final NBPClient nbpClient;

    public RestAppService(NBPClient nbpClient) {
        this.nbpClient = nbpClient;
    }

    public List<Integer> sortNumbers(NumbersSortData numbersSortData) {
            if (Objects.equals(numbersSortData.getOrder(), "ASC")) {
                Collections.sort(numbersSortData.getNumbers());
                return numbersSortData.getNumbers();
            } else if (Objects.equals(numbersSortData.getOrder(), "DESC")) {
                Collections.sort(numbersSortData.getNumbers());
                Collections.reverse(numbersSortData.getNumbers());
                return numbersSortData.getNumbers();
            }
            else {
                throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Invalid data");
            }
    }

    public Double getCurrency(String currency) {
        return nbpClient.getCurrencyValue(currency);
    }
}
