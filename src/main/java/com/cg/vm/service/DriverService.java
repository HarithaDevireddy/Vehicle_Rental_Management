package com.cg.vm.service;

import com.cg.vm.domain.Driver;

public interface DriverService {
	public Driver saveorUpdateDriver(Driver driver);
	public Driver findProjectByFirstName(String firstName);
	public Driver findProjectByLastName(String lastName);
	public void deleteDriverByDriverId(int driverId);
	public void deleteDriverById(String licenseNo);

}
