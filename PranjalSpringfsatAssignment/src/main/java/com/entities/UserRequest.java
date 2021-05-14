package com.entities;

public class UserRequest {
	private String departure_loc;
	private String arrival_loc;
	private String flight_date;
	private String flight_class;
	private String output_preference;
	public String getDeparture_loc() {
		return departure_loc;
	}
	public void setDeparture_loc(String departure_loc) {
		this.departure_loc = departure_loc;
	}
	public String getArrival_loc() {
		return arrival_loc;
	}
	public void setArrival_loc(String arrival_loc) {
		this.arrival_loc = arrival_loc;
	}
	public String getFlight_date() {
		return flight_date;
	}
	public void setFlight_date(String flight_date) {
		this.flight_date = flight_date;
	}
	public String getFlight_class() {
		return flight_class;
	}
	public void setFlight_class(String flight_class) {
		this.flight_class = flight_class;
	}
	public String getOutput_preference() {
		return output_preference;
	}
	public void setOutput_preference(String output_preference) {
		this.output_preference = output_preference;
	}
	@Override
	public String toString() {
		return "UserRequest [departure_loc=" + departure_loc + ", arrival_loc=" + arrival_loc + ", flight_date="
				+ flight_date + ", flight_class=" + flight_class + ", output_preference=" + output_preference + "]";
	}
	
}
