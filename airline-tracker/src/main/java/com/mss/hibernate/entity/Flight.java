package com.mss.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airlines")
public class Flight {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "flight_no")
	String flightNo;
	
	@Column(name = "dep_loc")
	String depLOC;
	
	@Column(name = "arr_loc")
	String arrLOC;
	
	@Column(name = "valid_till")
	String validTill;
	
	@Column(name = "flight_time")
	String flightTime;
	
	@Column(name = "flight_dur")
	double flightDur;
	
	@Column(name = "fare")
	double fare;
	
	@Column(name = "seat_availablity")
	String isAvailable;
	
	@Column(name = "class")
	String seatClass;

	
	
	public Flight() {
	}

	public Flight(String flightNo, String depLOC, String arrLOC, String validTill, String flightTime, double flightDur,
			double fare, String isAvailable, String seatClass) {
		this.flightNo = flightNo;
		this.depLOC = depLOC;
		this.arrLOC = arrLOC;
		this.validTill = validTill;
		this.flightTime = flightTime;
		this.flightDur = flightDur;
		this.fare = fare;
		this.isAvailable = isAvailable;
		this.seatClass = seatClass;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getDepLOC() {
		return depLOC;
	}

	public void setDepLOC(String depLOC) {
		this.depLOC = depLOC;
	}

	public String getArrLOC() {
		return arrLOC;
	}

	public void setArrLOC(String arrLOC) {
		this.arrLOC = arrLOC;
	}

	public String getValidTill() {
		return validTill;
	}

	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}

	public String getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}

	public double getFlightDur() {
		return flightDur;
	}

	public void setFlightDur(double flightDur) {
		this.flightDur = flightDur;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double d) {
		this.fare = d;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	@Override
	public String toString() {
		return "Flight [flightNo=" + flightNo + ", depLOC=" + depLOC + ", arrLOC=" + arrLOC + ", validTill=" + validTill
				+ ", flightTime=" + flightTime + ", flightDur=" + flightDur + ", fare=" + fare + ", isAvailable="
				+ isAvailable + ", seatClass=" + seatClass + "]";
	}
	
	
}
