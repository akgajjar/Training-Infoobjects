package com.infoobjects.tms.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {

	private Map<String, String> data;
	private Map<String, SubmitButton> submitButtons;
	
	
	public Data() {
		super();
		this.data = new HashMap<String, String>();
		this.submitButtons = new HashMap<String, SubmitButton>();
		
	}
	public Data(Map<String, String> dataToDisplay, Map<String, SubmitButton> submitButtons) {
		super();
		this.data = dataToDisplay;
		this.submitButtons = submitButtons;
	}
	public Map<String, String> getData() {
		return data;
	}
	public void setData(Map<String, String> data) {
		this.data = data;
	}
	public Map<String, SubmitButton> getSubmitButtons() {
		return submitButtons;
	}
	public void setSubmitButtons(Map<String, SubmitButton> submitButtons) {
		this.submitButtons = submitButtons;
	}

}
