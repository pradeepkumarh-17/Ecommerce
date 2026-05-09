package com.ecommerce.dao;

import java.util.List;
import com.ecommerce.model.Address;

public interface AddressDAO {

    boolean addAddress(Address address);

    List<Address> getAddressesByUser(int userId);

    Address getAddressById(int addressId);

    boolean updateAddress(Address address);

    boolean deleteAddress(int addressId);
}