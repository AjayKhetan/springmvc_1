package com.nisum.mvc;
import org.springframework.stereotype.Component;

@Component
public class Error {
	private int errorCode;
	private String errorDescription;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public Error(int errorCode, String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	public Error() {
		// TODO Auto-generated constructor stub
	}
}
