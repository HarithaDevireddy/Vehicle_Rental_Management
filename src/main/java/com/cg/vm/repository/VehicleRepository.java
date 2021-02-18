package com.cg.vm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.vm.domain.Vehicle;


@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long>{

	Vehicle findByVehicleId(Long vehicleId);

}