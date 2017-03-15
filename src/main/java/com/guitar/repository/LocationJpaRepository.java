package com.guitar.repository;

import com.guitar.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// this annotation with exported field set to false,
// will prevent location repository to be exported,
// the link/relation to Location entity/resource in the json representation
// of other entities/repositories will also be removed.
//@RepositoryRestResource(exported = false)
public interface LocationJpaRepository extends JpaRepository<Location, Long> {
    List<Location> findByStateIgnoreCaseStartingWith(String stateName);

    Location findFirstByStateIgnoreCaseStartingWith(String stateName);

    List<Location> findByStateNotLikeOrderByStateAsc(String stateName);

    List<Location> findByStateIsOrCountryEquals(String value, String value2);

    List<Location> findByStateNot(String state);

}
