package com.ecommerce.dao.impl;

import java.sql.*;
import java.util.*;

import com.ecommerce.dao.AddressDAO;
import com.ecommerce.model.Address;
import com.ecommerce.util.DBConnection;

public class AddressDAOImpl implements AddressDAO {

    @Override
    public boolean addAddress(Address a) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO user_addresses(user_id,full_address,city,state,pincode,country) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, a.getUserId());
            ps.setString(2, a.getFullAddress());
            ps.setString(3, a.getCity());
            ps.setString(4, a.getState());
            ps.setString(5, a.getPincode());
            ps.setString(6, a.getCountry());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override public List<Address> getAddressesByUser(int id){ return null; }
    @Override public Address getAddressById(int id){ return null; }
    @Override public boolean updateAddress(Address a){ return false; }
    @Override public boolean deleteAddress(int id){ return false; }
}