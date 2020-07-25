package com.technolins.registrationform.util;

public class Ajax {

	private Ajax() {
	}

	public static boolean isAjaxRequest(String requestedWith) {
		return requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;
	}
}
