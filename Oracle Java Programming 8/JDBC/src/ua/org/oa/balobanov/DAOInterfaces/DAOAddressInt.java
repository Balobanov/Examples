package ua.org.oa.balobanov.DAOInterfaces;

import java.util.List;

import ua.org.oa.balobanov.essences.Address;

public interface DAOAddressInt {
	boolean insert(Address adr);
	List<Address> selectAll();
	boolean update(Address adr);
	Address selectById(int id);
	boolean delete(Address adr);
}
