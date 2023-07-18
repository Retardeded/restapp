package com.recruit.restapp.service;

import com.recruit.restapp.model.CurrencyRequest;
import com.recruit.restapp.model.CurrencyRequestLog;
import com.recruit.restapp.repository.CurrencyRequestLogRepository;
import com.recruit.restapp.webclient.NBPClient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RestAppService {

    private final NBPClient nbpClient;
    private final CurrencyRequestLogRepository currencyRequestLogRepository;

    public RestAppService(NBPClient nbpClient, CurrencyRequestLogRepository currencyRequestLogRepository) {
        this.nbpClient = nbpClient;
        this.currencyRequestLogRepository = currencyRequestLogRepository;
    }

    public Double getCurrency(CurrencyRequest currencyRequest) {
    String currencyCode = currencyRequest.getCurrency();
    Double currencyValue = nbpClient.getCurrencyValue(currencyCode);

    saveCurrencyRequestLog(currencyRequest, currencyCode, currencyValue);
        return currencyValue;
    }

    private void saveCurrencyRequestLog(CurrencyRequest currencyRequest, String currencyCode, Double currencyValue) {
        CurrencyRequestLog requestLog = new CurrencyRequestLog(currencyCode, currencyRequest.getName(), LocalDateTime.now(), currencyValue.doubleValue());
        currencyRequestLogRepository.save(requestLog);
    }

    public List<CurrencyRequestLog> getAllCurrencyRequests() {
        return (List<CurrencyRequestLog>) currencyRequestLogRepository.findAll();
    }
}
