package com.RokuEng.springdata.repo;

import com.RokuEng.springdata.core.entity.hero.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeroRepo extends CustomRepo<Hero, Integer> {
    Optional<Hero> findByName(String name);

    @Query("SELECT h FROM Hero h WHERE h.audit.updateDate IS NOT NULL AND h.name LIKE :pattern")
    List<Hero> findByComplexQuery(
            @Param("pattern")
            String pattern
    );
}
