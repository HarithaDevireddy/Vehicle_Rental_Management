package com.cg.vm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.vm.domain.Driver;


@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{

	Driver findByFirstName(String firstName);
	Driver findByLastName(String lastName);
	Driver findByDriverId(int driverId);
	Driver findByLicenseNo(String licenseNo);
}
