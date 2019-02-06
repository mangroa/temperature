package com.mangroo.temperature.data.repo;

import com.mangroo.temperature.data.Temperature;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface TemperatureRepository extends CrudRepository<Temperature, Long> {
    List<Temperature> findByName(String name);
}
