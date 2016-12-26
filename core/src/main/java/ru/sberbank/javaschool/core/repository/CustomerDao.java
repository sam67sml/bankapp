package ru.sberbank.javaschool.core.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.sberbank.javaschool.core.entity.Customer;

/**
 * JavaSchool SBT
 * Created by Sam on 11.12.2016.
 */
@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM CUSTOMERS c WHERE EMAIL = :email")
    Customer findCustomerByEmail(@Param("email") String email);

}
