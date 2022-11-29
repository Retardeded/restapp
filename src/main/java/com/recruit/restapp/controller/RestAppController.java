package com.recruit.restapp.controller;

import com.recruit.restapp.model.NumbersSortData;
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

    @GetMapping("/status/ping")
    public String getPing() {
        return "pong";
    }

    @GetMapping("/numbers/sort-command")
    public List<Integer> sortNumbers(@RequestBody NumbersSortData numbersSortData) {
        if(numbersSortData.getNumbers() == null) {
            throw new ResponseStatusException(UNPROCESSABLE_ENTITY, "Invalid data");
        }
        return restAppService.sortNumbers(numbersSortData);
    }

    @GetMapping("/currencies/get-current-currency-value-command")
    public Double getCurrencyValue(@RequestBody String currency) {
        return restAppService.getCurrency(currency);
    }
}
