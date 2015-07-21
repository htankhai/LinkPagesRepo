package com.ecerami.xmlrpc;

public class AreaHandler {

	public String areaTester(String value) {
		return "Area: " + value;
	}

	public Double rectArea(double length, double width) {
		return new Double(length*width);
	}

	public Double circleArea(double radius) {
		double value=(radius*radius*Math.PI);
		return new Double (value);
		//return new Double (radius);
	}

}