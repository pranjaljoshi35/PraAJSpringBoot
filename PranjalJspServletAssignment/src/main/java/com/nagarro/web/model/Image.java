package com.nagarro.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Image {
	@Id @GeneratedValue
	int serial_no;
	
	String name;
	double size;
	String preview;
	String actions;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public String getPreview() {
		return preview;
	}
	public void setPreview(String preview) {
		this.preview = preview;
	}
	public String getActions() {
		return actions;
	}
	public void setActions(String actions) {
		this.actions = actions;
	}
	@Override
	public String toString() {
		return "Image [name=" + name + ", size=" + size + ", preview=" + preview + ", actions=" + actions + "]";
		//<td><span>Actions</span> <input type="submit" value="Edit"> <input type="reset" value="Cancel"></td>
	}
	
}
