package com.astontech.dockerapp.service;

import com.astontech.dockerapp.domain.Beer;

import java.util.List;
import java.util.Optional;

public interface BeerService {

    List<Beer> findAllBeers();
    Beer findBeerById(Long id);
    Beer saveBeer(Beer beer);
}
