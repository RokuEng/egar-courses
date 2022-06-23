package com.RokuEng.springrest.repo.spring;

import com.RokuEng.springrest.domain.hero.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepo extends JpaRepository<Hero, Integer> {
}
