package com.infoobjects.tms.dto;

import java.util.HashMap;
import java.util.Map;

import com.infoobjects.tms.dto.interfaces.DTO;

/**
 * @author Aniket
 * @description DTO Class - used to hold database record for generic show all
 *              page
 */
public class Data implements DTO {

	private Map<String, String> data;
	private Map<String, SubmitButton> submitButtons;

	/**
	 * Constructors
	 */
	public Data() {
		this.data = new HashMap<String, String>();
		this.submitButtons = new HashMap<String, SubmitButton>();

	}

	public Data(Map<String, String> dataToDisplay, Map<String, SubmitButton> submitButtons) {
		this.data = dataToDisplay;
		this.submitButtons = submitButtons;
	}

	/**
	 * toString method to display Data's data
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Data [data=" + data + ", submitButtons=" + submitButtons + "]";
	}

	/**
	 * getters and setters
	 */
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
