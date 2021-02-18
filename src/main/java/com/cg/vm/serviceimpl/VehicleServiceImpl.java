package com.cg.vm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vm.domain.Vehicle;
import com.cg.vm.exceptions.VehicleNotFoundException;
import com.cg.vm.repository.VehicleRepository;
import com.cg.vm.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;

	public Vehicle saveOrUpdate(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);

	}

	public Vehicle findByVehicleId(Long vehicleId) {
		Vehicle vehicle = vehicleRepository.findByVehicleId(vehicleId);
		if (vehicle == null)
			throw new VehicleNotFoundException("Vehicle Id " + vehicleId + " Not In Database");
		    return vehicle;
		
	}
	public Iterable<Vehicle> getAllVehicles() {
		return vehicleRepository.findAll();
	}

	public  void  deleteVehicleById(Long vehicleId) {
		Vehicle vehicle = vehicleRepository.findByVehicleId(vehicleId);
		if (vehicle == null)
			throw new VehicleNotFoundException("Vehicle Id " + vehicleId + " Not In Database");
		vehicleRepository.delete(vehicle);
	}
}