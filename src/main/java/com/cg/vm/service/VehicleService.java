package com.cg.vm.service;

import com.cg.vm.domain.Vehicle;

public interface VehicleService {
	public Vehicle saveOrUpdate(Vehicle vehicle);
	public Iterable<Vehicle> getAllVehicles();
	public  void  deleteVehicleById(Long vehicleId);
	
}
