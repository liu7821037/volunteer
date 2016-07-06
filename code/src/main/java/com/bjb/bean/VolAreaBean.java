package com.bjb.bean;

import java.util.List;

import com.bjb.entity.VolArea;

public class VolAreaBean {
	
	/**
	 * 地域简称
	 */
	private String first_letter;
	
	private List<VolArea> VolAreas;
	
	public String getFirst_letter() {
		return first_letter;
	}

	public void setFirst_letter(String first_letter) {
		this.first_letter = first_letter;
	}

	public List<VolArea> getVolAreas() {
		return VolAreas;
	}

	public void setVolAreas(List<VolArea> volAreas) {
		VolAreas = volAreas;
	}
}
