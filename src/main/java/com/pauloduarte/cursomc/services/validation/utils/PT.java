package com.pauloduarte.cursomc.services.validation.utils;

/**
 * @author Rafa Domingos
 * @see <a href="https://github.com/Rafa-Domingos/Springclass/blob/master/src/main/java/com/rafael/springclass/services/validation/Utils/BR.java</a>
 */
public class PT{

	public static boolean isValidNifS(String vatNumber) {
		final int max=9;
		//check if is numeric and has 9 numbers
		if (!vatNumber.matches("[0-9]+") || vatNumber.length()!=max ||vatNumber.charAt(0)>'3') return false;
		int checkSum=0;
		//calculate checkSum
		for (int i=0; i<max-1; i++){
			checkSum+=(vatNumber.charAt(i)-'0')*(max-i);
		}
		int checkDigit=11-(checkSum % 11);
		//if checkDigit is higher than TEN set it to zero
		if (checkDigit>=10) checkDigit=0;
		//compare checkDigit with the last number of NIF
		
			return checkDigit==vatNumber.charAt(max-1)-'0';
	}
	public static boolean isValidNifC(String vatNumber) {
		final int max=9;
		//check if is numeric and has 9 numbers
		if (!vatNumber.matches("[0-9]+") || vatNumber.length()!=max || vatNumber.charAt(0)<='3') return false;
		int checkSum=0;
		//calculate checkSum
		for (int i=0; i<max-1; i++){
			checkSum+=(vatNumber.charAt(i)-'0')*(max-i);
		}
		int checkDigit=11-(checkSum % 11);
		//if checkDigit is higher than TEN set it to zero
		if (checkDigit>=10) checkDigit=0;
		//compare checkDigit with the last number of NIF
		
			return checkDigit==vatNumber.charAt(max-1)-'0';
	}
	
	}