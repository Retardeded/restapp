package com.recruit.restapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CurrencyRequestLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String currencyCode;
    private String personName;
    private LocalDateTime date;
    private double currencyExchangeRate;

    public CurrencyRequestLog(String currencyCode, String personName, LocalDateTime date, double currencyExchangeRate) {
        this.currencyCode = currencyCode;
        this.personName = personName;
        this.date = date;
        this.currencyExchangeRate = currencyExchangeRate;
    }
}