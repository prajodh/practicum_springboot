package iu.edu.ppsunder.primenumbers.repository;

import iu.edu.ppsunder.primenumbers.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationDBRepository
extends CrudRepository<Customer, String>
{
    Customer findByUsername(String username);
}