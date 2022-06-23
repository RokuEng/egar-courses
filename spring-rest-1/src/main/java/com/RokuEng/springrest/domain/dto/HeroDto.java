package com.RokuEng.springrest.domain.dto;

import com.RokuEng.springrest.domain.hero.Hero;
import lombok.Data;

@Data
public class HeroDto {
	private String name;

	private Float health;

	private Float damage;

	public Hero create() {
		Hero hero = new Hero();
		hero.setName(name);
		hero.setDamage(damage);
		hero.setHealth(health);
		return hero;
	}
}
