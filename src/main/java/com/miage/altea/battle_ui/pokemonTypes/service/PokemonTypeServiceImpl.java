package com.miage.altea.battle_ui.pokemonTypes.service;

import com.miage.altea.battle_ui.pokemonTypes.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    private RestTemplate restTemplate;
    private String pokemonTypeServiceUrl;

    @Cacheable("pokemon-types")
    public PokemonType getPokemonType(int id) {
        PokemonType pokemonType = restTemplate.getForObject(pokemonTypeServiceUrl + "/pokemon-types/" + id, PokemonType.class);
        return pokemonType;
    }


    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${pokemonType.service.url}")
    void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonTypeServiceUrl = pokemonServiceUrl;
    }
}
