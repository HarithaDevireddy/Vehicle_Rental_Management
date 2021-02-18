package com.cg.vm.serviceimpl;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.vm.domain.Booking;
import com.cg.vm.exceptions.BookingIdException;
import com.cg.vm.repository.BookingRepository;
import com.cg.vm.service.BookingService;


@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	public Booking saveOrUpdate(Booking booking) {
		return bookingRepository.save(booking);
	}

	public Booking findByBookingId(int bookingId) {
	
		Booking booking = bookingRepository.findByBookingId(bookingId);
		if (booking == null)
		throw new BookingIdException("Booking Id " + bookingId + " Not In Database");
		return booking;
	}

	public List<Booking> viewBookingByBookingDate(LocalDate bookingDate) {
		
		List<Booking> bookings = bookingRepository.findAllByBookingDate(bookingDate);
		if (bookings.size() == 0)
			throw new BookingIdException("Bookings from " + bookingDate + " Not Found");	
		return bookings;
	}

	public List<Booking> viewAllBookings() {
		List<Booking> bookings = bookingRepository.findAll();
		if (bookings.size() == 0)
			throw new BookingIdException("Bookings Not Found");	
		return bookings;
	}

	@Override
	public List<Booking> viewAllBookingsByCustomer(Long cust_id) {
		List<Booking> bookingsByCustomer = bookingRepository.findAllByBooking_Cust_Id(cust_id);
		if (bookingsByCustomer.size() == 0)
			throw new BookingIdException("Bookings Not Found");	
		return bookingsByCustomer;
	}

	@Override
	public void cancelBookingById(int bookingId) {
		Booking booking = bookingRepository.findByBookingId(bookingId);
		if (booking == null)
			throw new BookingIdException("Booking Id " + bookingId + " Not In Database");
		bookingRepository.deleteById(bookingId);	
		
	}

	@Override
	public List<Booking> viewAllBookingsByVehicle(Long vehicle_id) {
	List<Booking> bookingsByVehicle = bookingRepository.findAllByBooking_Vehicle_Id(vehicle_id);
	if (bookingsByVehicle.size() == 0)
		throw new BookingIdException("Bookings Not Found");	
	return bookingsByVehicle;
	}

}