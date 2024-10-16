package com.ABC.Gloflox.Entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
public class Classes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size(min=2,message="Atleast 2 characters should be present")
	private String className;
	
	@NotNull 
	private LocalDate startDate;
	
	@NotNull
	private LocalDate endDate;
	
	@PositiveOrZero(message="Capacity cannot be 0 or negative")
	private int capacity;

	@JsonIgnore
	@OneToMany(mappedBy="classes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<ClassSlots> slots;
	
	public Classes( @NotNull String className, @NotNull LocalDate startDate, @NotNull LocalDate endDate ,int capacity) {
		super();
		
		this.className = className;
		this.startDate = startDate;
		this.endDate = endDate;
		this.capacity=capacity;
	}
	

	public Classes(long classId, @NotNull String className, @NotNull LocalDate startDate, @NotNull LocalDate endDate,int capacity) {
		super();
		this.id = classId;
		this.className = className;
		this.startDate = startDate;
		this.endDate = endDate;
		this.capacity=capacity;
	}


	public Classes() {
		super();
	}

	public long getClassId() {
		return id;
	}

	public void setClassId(long classId) {
		this.id = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public  LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate( LocalDate endDate) {
		this.endDate = endDate;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}


	public List<ClassSlots> getSlots() {
		return slots;
	}


	public void setSlots(List<ClassSlots> slots) {
		this.slots = slots;
	}
	
	
	

}
