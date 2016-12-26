package ru.sberbank.javaschool.core.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.javaschool.core.entity.AccountInfo;

/**
 * JavaSchool SBT
 * Created by Sam on 11.12.2016.
 */
@Repository
public interface AccountInfoDao extends JpaRepository<AccountInfo, Long> {
}
