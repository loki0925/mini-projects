package com.masai.service;

import com.masai.exception.DriverNotfound;
import com.masai.model.Driver;

public interface DriverService {

     public Driver registerDriver(Driver driver) throws DriverNotfound;
     
}
