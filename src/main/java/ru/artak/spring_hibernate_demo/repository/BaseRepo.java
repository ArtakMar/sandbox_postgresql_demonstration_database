package ru.artak.spring_hibernate_demo.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.artak.spring_hibernate_demo.model.Base;
import ru.artak.spring_hibernate_demo.model.BaseDto;

import java.util.Optional;

public interface BaseRepo extends JpaRepository<Base, Long> {
//    @Override
//    @EntityGraph(value = "base")
//    Optional<Base> findById(Long aLong);

//    @Query(value = "SELECT new ru.artak.spring_hibernate_demo.model.BaseDto (id, name) FROM base where id = :id", nativeQuery = true)
    @Query("SELECT new ru.artak.spring_hibernate_demo.model.BaseDto(b.id, b.name) FROM Base b where b.id = :id")
    BaseDto findBaseWithoutChildren(Long id);

    @EntityGraph(value = "base")
    Base findWithHierarchyById(Long aLong);
}
