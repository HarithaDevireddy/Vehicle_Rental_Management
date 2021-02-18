package com.cg.vm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vm.domain.Driver;
import com.cg.vm.exceptions.DriverNotFoundException;
import com.cg.vm.repository.DriverRepository;
import com.cg.vm.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
	@Autowired
	private DriverRepository driverRepository;
	
	
	public Driver saveorUpdateDriver(Driver driver) throws DriverNotFoundException {
		
	try {
		return driverRepository.save(driver);
	}
	catch(Exception e)
	{
		throw new DriverNotFoundException("Driver details not added");
	}
	}

	public Driver findProjectByFirstName(String firstName) throws DriverNotFoundException {
		try {
		Driver driver=driverRepository.findByFirstName(firstName);
		return driver;
		}
		catch(Exception e)
		{
			throw new DriverNotFoundException("Driver details not found for the given first name");
		}
	}
	public Driver findProjectByLastName(String lastName) throws DriverNotFoundException {
		try {
		Driver driver=driverRepository.findByLastName(lastName);
		return driver;
		}
		catch(Exception e)
		{
			throw new DriverNotFoundException("Driver details not found for the given last name");
		}
	}

	public void deleteDriverByDriverId(int driverId) throws DriverNotFoundException{
		try
		{
			Driver driver=driverRepository.findByDriverId(driverId);
			driverRepository.delete(driver);;
		}
		catch(Exception e)
		{
			throw new DriverNotFoundException("Driver details not found for the given Driver Id");
		}
	}

	public void deleteDriverById(String licenseNo) throws DriverNotFoundException{
		try
		{
			Driver driver=driverRepository.findByLicenseNo(licenseNo);
			driverRepository.delete(driver);
		}
		catch(Exception e)
		{
			throw new DriverNotFoundException("Driver details not found for the given Id");
		}
		
	}
	

}
