package com.astontech.dockerapp.service.impl;

import com.astontech.dockerapp.domain.Beer;
import com.astontech.dockerapp.repositories.BeerRepository;
import com.astontech.dockerapp.service.BeerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeerServiceIMPL implements BeerService {

    private final BeerRepository beerRepository;

    public BeerServiceIMPL(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public List<Beer> findAllBeers() {
        return (List<Beer>) beerRepository.findAll();
    }

    @Override
    public Beer findBeerById(Long id) {
        return beerRepository.findById(id).orElse(null);
    }

    @Override
    public Beer saveBeer(Beer beer) {
        return beerRepository.save(beer);
    }
}
