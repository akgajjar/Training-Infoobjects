package com.infoobjects.tms.dto;

import com.infoobjects.tms.dto.interfaces.DTO;

/**
 * @author Aniket
 * @description DTO Class - used to hold single Submit button related Record for
 *              generic show all page
 */
public class SubmitButton implements DTO {

	private String formAction;
	private String formMethod;
	private String buttonValue;

	/**
	 * Constructors
	 */
	public SubmitButton() {
	}

	public SubmitButton(String formAction, String formMethod, String buttonValue) {
		this.formAction = formAction;
		this.formMethod = formMethod;
		this.buttonValue = buttonValue;
	}

	/**
	 * toString method to display SubmitButton's data
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "SubmitButton [formAction=" + formAction + ", formMethod=" + formMethod + ", buttonValue=" + buttonValue
				+ "]";
	}

	/**
	 * getters and setters
	 */
	public String getFormAction() {
		return formAction;
	}

	public void setFormAction(String formAction) {
		this.formAction = formAction;
	}

	public String getFormMethod() {
		return formMethod;
	}

	public void setFormMethod(String formMethod) {
		this.formMethod = formMethod;
	}

	public String getButtonValue() {
		return buttonValue;
	}

	public void setButtonValue(String buttonValue) {
		this.buttonValue = buttonValue;
	}

}
