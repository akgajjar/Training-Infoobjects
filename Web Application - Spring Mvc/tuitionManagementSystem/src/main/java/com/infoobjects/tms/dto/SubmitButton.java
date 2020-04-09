package com.infoobjects.tms.dto;

public class SubmitButton {

	
	private String formAction;
	private String formMethod;
	private String buttonValue;
	
	public SubmitButton() {
		super();
	}
	public SubmitButton(String formAction, String formMethod, String buttonValue) {
		super();
		this.formAction = formAction;
		this.formMethod = formMethod;
		this.buttonValue = buttonValue;
	}
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
