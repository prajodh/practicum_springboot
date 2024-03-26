package iu.edu.ppsunder.primenumbers.service;

import iu.edu.ppsunder.primenumbers.model.Customer;

import java.io.IOException;

public interface IAuthenticationService {

    boolean register (Customer customer) throws IOException;

    Boolean login(String username, String password) throws IOException;
}
