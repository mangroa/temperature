package com.mangroo.temperature.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TemperatureRepository extends CrudRepository<Temperature, Float> {

    List<Temperature> findByName(String name);
}
