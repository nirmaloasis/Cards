package com.allstate.repositories;


import com.allstate.entities.Statistics;
import org.springframework.data.repository.CrudRepository;

public interface IStatisticsRepository extends CrudRepository<Statistics, Integer>{
}
