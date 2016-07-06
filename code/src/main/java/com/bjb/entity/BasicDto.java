package com.bjb.entity;

import java.io.Serializable;

public class BasicDto implements Serializable,Cloneable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;			//任意表主键 继承此类后不需要在子类中再次定义ID 统一用此ID
	
	//通用参数
	private Integer start;
	private Integer end;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}
}
