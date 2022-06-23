package com.RokuEng.springrest.controller;

import com.RokuEng.springrest.domain.dto.HeroDto;
import com.RokuEng.springrest.domain.hero.Hero;
import com.RokuEng.springrest.domain.mapper.HeroMapper;
import com.RokuEng.springrest.service.HeroService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/")
public class HeroController {

	private HeroService heroService;

	private HeroMapper heroMapper;

	@GetMapping
	public List<HeroDto> list() {
		return heroMapper.toDtoList(heroService.findAllHeroes());
	}

	@PostMapping
	public HeroDto create(
		@RequestBody HeroDto hero
	) {
		Hero afterCreate = heroService.create(hero.create());
		return heroMapper.toDto(afterCreate);
	}

	@GetMapping("/{id}")
	public HeroDto get(
		@PathVariable("id") Integer id
	) {
		return heroMapper.toDto(heroService.findById(id));
	}

	@PutMapping("/{id}")
	public HeroDto update(
		@PathVariable("id") Integer id,
		@RequestBody HeroDto hero
	) {
		Hero heroFromDb = heroService.findById(id);
		BeanUtils.copyProperties(hero.create(), heroFromDb, "id", "createdAt", "updatedAt");
		return heroMapper.toDto(heroService.update(heroFromDb));
	}

	@DeleteMapping("/{id}")
	public HeroDto hero(
		@PathVariable("id") Integer id
	) {
		Hero heroFromDb = heroService.findById(id);
		heroService.delete(heroFromDb);
		return heroMapper.toDto(heroFromDb);
	}
}
