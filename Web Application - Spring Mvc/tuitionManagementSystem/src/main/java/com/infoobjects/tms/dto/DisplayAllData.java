package com.infoobjects.tms.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayAllData {

	private List<String> dataHeaders;
	private List<String> buttonsHeaders;
	private List<Data> dataToDisplay;
	private String displayAllDataHeading;
	
	public DisplayAllData() {
		super();
		this.dataHeaders = new ArrayList<String>();
		this.buttonsHeaders = new ArrayList<String>();
		this.dataToDisplay = new ArrayList<Data>();
	}
	
	public List<String> getDataHeaders() {
		return dataHeaders;
	}
	public void setDataHeaders(List<String> dataHeaders) {
		this.dataHeaders = dataHeaders;
	}
	public List<String> getButtonsHeaders() {
		return buttonsHeaders;
	}
	public void setButtonsHeaders(List<String> buttonsHeaders) {
		this.buttonsHeaders = buttonsHeaders;
	}
	public List<Data> getDataToDisplay() {
		return dataToDisplay;
	}
	public void setDataToDisplay(List<Data> dataToDisplay) {
		this.dataToDisplay = dataToDisplay;
	}

	public String getDisplayAllDataHeading() {
		return displayAllDataHeading;
	}

	public void setDisplayAllDataHeading(String displayAllDataHeading) {
		this.displayAllDataHeading = displayAllDataHeading;
	}
	
	
}
