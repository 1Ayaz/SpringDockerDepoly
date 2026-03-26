package com.aditya.leave;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="csedockercompose")
public class CseEntity {
	@Column
	@Id
	public int id;
	@Column
	public String name;
	@Column
	public String branch;
	@Column
	public String college;
	@Column
	public String city;

	public CseEntity() {
		super();
	}

	public CseEntity(int id, String name, String branch, String college, String city) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.college = college;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "CseEntity [id=" + id + ", name=" + name + ", branch=" + branch + ", college=" + college + ", city="
				+ city + "]";
	}
}
