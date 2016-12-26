package ru.sberbank.javaschool.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.javaschool.core.entity.CardType;

/**
 * JavaSchool SBT
 * Created by Sam on 11.12.2016.
 */
@Repository
public interface CardTypeDao extends JpaRepository<CardType, Long> {
}
