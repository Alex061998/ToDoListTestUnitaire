package org.example.Exception;

public class InvalideItemContentException extends Exception {
	public InvalideItemContentException() {
		System.out.println("Limite de 100 caractères dépassée");
	}
}
