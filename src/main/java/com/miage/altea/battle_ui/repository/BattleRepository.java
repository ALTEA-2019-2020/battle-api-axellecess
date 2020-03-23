package com.miage.altea.battle_ui.repository;

import com.miage.altea.battle_ui.battle.Battle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BattleRepository extends CrudRepository<Battle, String> {

    @Override
    <S extends Battle> S save(S s);

    @Override
    <S extends Battle> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    Optional<Battle> findById(String s);

    @Override
    boolean existsById(String s);

    @Override
    Iterable<Battle> findAll();

    @Override
    Iterable<Battle> findAllById(Iterable<String> iterable);

    @Override
    long count();

    @Override
    void deleteById(String s);

    @Override
    void delete(Battle battle);

    @Override
    void deleteAll(Iterable<? extends Battle> iterable);

    @Override
    void deleteAll();
}
