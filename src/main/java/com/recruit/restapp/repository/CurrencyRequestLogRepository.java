package com.recruit.restapp.repository;

import com.recruit.restapp.model.CurrencyRequestLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRequestLogRepository extends CrudRepository<CurrencyRequestLog, Long> {
    // You can add additional methods if needed
}
