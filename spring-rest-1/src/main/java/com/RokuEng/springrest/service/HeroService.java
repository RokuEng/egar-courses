package com.RokuEng.springrest.service;

import com.RokuEng.springrest.domain.hero.Hero;
import com.RokuEng.springrest.repo.spring.HeroRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HeroService {

	private HeroRepo heroRepo;

	public Hero findById(Integer id) {
		return heroRepo.findById(id).orElseThrow();
	}

	public List<Hero> findAllHeroes() {
		return heroRepo.findAll();
	}

	public Hero create(Hero hero) {
		return heroRepo.save(hero);
	}

	public Hero update(Hero hero) {
		return heroRepo.save(hero);
	}

	public void delete(Hero hero) {
		heroRepo.delete(hero);
	}
}
