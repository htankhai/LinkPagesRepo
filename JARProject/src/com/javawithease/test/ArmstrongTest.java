package com.javawithease.test;

import com.javawithease.business.ArmstrongNumber;

/**
 * This class is used to test the custom jar.
 * @author javawithease
 */
public class ArmstrongTest {
	public static void main(String args[]){
		//Use the static method from the jar file to check whether the
		//no. is armstrong or not.
		boolean isArmStrong = ArmstrongNumber.armstrong(407);
		if(isArmStrong){
			System.out.println("Given number is an armstrong number.");
		}else{
			System.out.println("Given number is not an armstrong number.");
		}
	}
}
