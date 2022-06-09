package com.RokuEng.springdata.repo;

import com.RokuEng.springdata.core.entity.hero.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@NoRepositoryBean
public interface CustomRepo<E, ID> extends JpaRepository<E, ID> {

    List<E> findWithOffsetAndLimit(Integer offset, Integer limit);
}
