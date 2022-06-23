package org.example.Exception;

public class InvalidePasswordLengthException extends Exception {
	public InvalidePasswordLengthException() {
		System.out.println("Mot de passe non compris entre 8 et 40 caractères");
	}
}
