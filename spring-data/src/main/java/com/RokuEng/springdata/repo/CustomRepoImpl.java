package com.RokuEng.springdata.repo;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomRepoImpl<E, ID> extends SimpleJpaRepository<E, ID> implements CustomRepo<E, ID> {

    public CustomRepoImpl(
            Class<E> domainClass,
            EntityManager em
    ) {
        super(domainClass, em);
    }

    @Override
    public List<E> findWithOffsetAndLimit(Integer offset, Integer limit) {
        return null;
    }
}
