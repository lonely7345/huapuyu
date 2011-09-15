package com.bamboo.maifang.action.rent;

import org.springframework.beans.factory.annotation.Autowired;

import com.bamboo.maifang.action.skeleton.MetadataUnitAction;
import com.bamboo.maifang.api.rent.RentService;
import com.bamboo.maifang.model.RentHouse;

public class RentHouseAction extends MetadataUnitAction {

	private static final long serialVersionUID = 1L;

	private RentHouse rentHouse;

	@Autowired
	private RentService rentService;

	public RentHouseAction() {
	}

	public String onLoad() {
		this.doGetAreas(2L);
		return SUCCESS;
	}

	public String submitCreate() {
		rentService.createRentHouse(this.rentHouse);
		return SUCCESS;
	}

	public RentHouse getRentHouse() {
		return rentHouse;
	}

	public void setRentHouse(RentHouse rentHouse) {
		this.rentHouse = rentHouse;
	}
}
