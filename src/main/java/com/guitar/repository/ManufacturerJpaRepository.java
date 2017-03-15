package com.guitar.repository;

import com.guitar.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
// this annotation leads to a uri change resulting "http://localhost:8080/api/companies"
//@RepositoryRestResource(path = "companies")
// collectionResourceRel field defines the name of the json object's name in the response
//@RepositoryRestResource(path = "companies", collectionResourceRel = "company")
public interface ManufacturerJpaRepository extends JpaRepository<Manufacturer, Long> {
    List<Manufacturer> findByFoundedDateBefore(Date date);

    List<Manufacturer> findByActiveTrue();

    List<Manufacturer> findByActiveFalse();

    List<Manufacturer> getAllThatSellAcoustics(String name);
}
