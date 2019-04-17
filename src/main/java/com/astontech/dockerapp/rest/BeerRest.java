package com.astontech.dockerapp.rest;

import com.astontech.dockerapp.domain.Beer;
import com.astontech.dockerapp.service.BeerService;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
@RequestMapping("/api/beer")
public class BeerRest {

    private final BeerService beerService;

    public BeerRest(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/")
    public Collection<Resource<Beer>> getAllBeers() {
        List<Beer> beers = beerService.findAllBeers();
        List<Resource<Beer>> resources = new ArrayList<>();
        for (Beer b : beers) {
            resources.add(getResource(b));

        }

        return resources;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Beer> findBeerById(@PathVariable Long id) {

        Beer b = beerService.findBeerById(id);
        Resource<Beer> resource = new Resource<>(b);
        resource.add(linkTo(methodOn(BeerRest.class).findBeerById(id)).withSelfRel());
        return resource;

    }

    @PostMapping("/")
    public Beer saveBeer(@RequestBody Beer beer) {
        return beerService.saveBeer(beer);
    }

    private Resource<Beer> getResource(Beer beer) {
        Resource<Beer> resource = new Resource<>(beer);
        resource.add(linkTo(BeerRest.class).slash(beer.getId()).withSelfRel());
        return resource;
    }

}
