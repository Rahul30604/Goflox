package com.ABC.Gloflox.Service;

import java.time.LocalDate;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ABC.Gloflox.Entity.Booking;
import com.ABC.Gloflox.Entity.ClassSlots;
import com.ABC.Gloflox.springDataJpa.BookingDataJpaRepository;
import com.ABC.Gloflox.springDataJpa.ClassSlotJpaRepository;

@Service
public class BookingService {
	@Autowired
	private BookingDataJpaRepository bookingRepository;
	
	@Autowired
	private ClassSlotJpaRepository classSlotsRepository;
	
	public String bookClass(Long classId,String memberName ,LocalDate bookingDate) {
		
		Optional<ClassSlots> classSlotOpt=classSlotsRepository.findByClassesIdAndSlotDate(classId, bookingDate);
		if(classSlotOpt.isPresent()) {
			ClassSlots classSlots=classSlotOpt.get();
			if(classSlots.getAvailableSlots()>0) {
				classSlots.setAvailableSlots(classSlots.getAvailableSlots()-1);
				classSlotsRepository.save(classSlots);
				
				Booking booking=new Booking(memberName,bookingDate,classId);
				bookingRepository.save(booking);
				return "Booking SuccessFull";
			}
			else {
				return "No available Slots for the Selected Date";
			}
		}
		return "Class Slot not found for the selected Date";
	}

}
