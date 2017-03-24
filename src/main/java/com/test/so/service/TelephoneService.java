package com.test.so.service;


import com.test.so.domain.Telephone;
import java.util.Collection;

/**
 * Created by azizunsal on 24/02/15.
 */
public interface TelephoneService {
    Telephone findById(Integer id);
    
    
    Collection<Telephone> findAll();
}
