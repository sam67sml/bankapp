package ru.sberbank.javaschool.core.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.sberbank.javaschool.core.entity.Role;

/**
 * JavaSchool SBT
 * Created by Sam on 11.12.2016.
 */
public interface RoleRepo extends JpaRepository<Role, Long> {
}
