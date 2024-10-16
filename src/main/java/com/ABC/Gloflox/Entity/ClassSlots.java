package com.ABC.Gloflox.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ClassSlots {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
	
	@ManyToOne
	@JoinColumn(name="class_id")
	private Classes classes;
	
	private LocalDate slotDate;
	
	private int availableSlots;
	
	

	public ClassSlots() {
		super();
	}
	
	public ClassSlots(Classes classes, LocalDate slotDate, int availableSlots) {
		super();
		this.classes = classes;
		this.slotDate = slotDate;
		this.availableSlots = availableSlots;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}

	public Classes getClasses() {
		return classes;
	}

	public LocalDate getSlotDate() {
		return slotDate;
	}

	public int getAvailableSlots() {
		return availableSlots;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public void setSlotDate(LocalDate slotDate) {
		this.slotDate = slotDate;
	}

	public void setAvailableSlots(int availableSlots) {
		this.availableSlots = availableSlots;
	}
	
	
	
}
