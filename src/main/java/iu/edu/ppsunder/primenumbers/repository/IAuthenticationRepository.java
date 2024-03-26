package iu.edu.ppsunder.primenumbers.repository;

import iu.edu.ppsunder.primenumbers.model.Customer;

import java.io.IOException;

public interface IAuthenticationRepository {

    boolean save(Customer customer) throws IOException;

    Customer findByUsername(String username) throws IOException;
}
