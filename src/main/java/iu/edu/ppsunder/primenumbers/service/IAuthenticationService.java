package iu.edu.ppsunder.primenumbers.service;

import iu.edu.ppsunder.primenumbers.model.Customer;

import java.io.IOException;

public interface IAuthenticationService {

    Customer register (Customer customer) throws IOException;

}
