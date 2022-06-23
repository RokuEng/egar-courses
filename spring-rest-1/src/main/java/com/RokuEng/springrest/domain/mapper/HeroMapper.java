package com.RokuEng.springrest.domain.mapper;

import com.RokuEng.springrest.domain.dto.HeroDto;
import com.RokuEng.springrest.domain.hero.Hero;
import lombok.Data;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HeroMapper {

//	@Mapping(source = "Hero.name", target = "name")
//	@Mapping(source = "Hero.damage", target = "damage")
//	@Mapping(source = "Hero.health", target = "health")
	HeroDto toDto(Hero hero);

	List<HeroDto> toDtoList(List<Hero> list);
}
