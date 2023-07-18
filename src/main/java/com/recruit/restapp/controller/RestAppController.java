package com.recruit.restapp.controller;

import com.recruit.restapp.model.CurrencyRequest;
import com.recruit.restapp.model.CurrencyRequestLog;
import com.recruit.restapp.service.RestAppService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;


@RequestMapping(path = "")
@RestController
public class RestAppController {

    private final RestAppService restAppService;

    public RestAppController(RestAppService restAppService) {
        this.restAppService = restAppService;
    }

    @PostMapping("/currencies/get-current-currency-value-command")
    public Double getCurrencyValue(@RequestBody CurrencyRequest currencyRequest) {
        return restAppService.getCurrency(currencyRequest);
    }

    @GetMapping(path = "/currencies/requests")
    public List<CurrencyRequestLog> getAllCurrencyRequests() {
        return restAppService.getAllCurrencyRequests();
    }
}
