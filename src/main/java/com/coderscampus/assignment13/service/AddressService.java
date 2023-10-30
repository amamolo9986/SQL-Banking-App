package com.coderscampus.assignment13.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment13.domain.Address;
import com.coderscampus.assignment13.domain.User;
import com.coderscampus.assignment13.repository.AddressRepository;
import com.coderscampus.assignment13.repository.UserRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepo;

	public Address findById(Long userId) {
		Optional<Address> addressOpt = addressRepo.findById(userId);
		return addressOpt.orElse(new Address());
	}

}
