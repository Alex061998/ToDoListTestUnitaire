package org.example.Exception;

public class InvalideEmailException extends Exception {
	public InvalideEmailException() {
		System.out.println("L'email saisie est incorrect");
	}
}
