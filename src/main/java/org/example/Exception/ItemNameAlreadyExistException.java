package org.example.Exception;

public class ItemNameAlreadyExistException extends Exception {
	public ItemNameAlreadyExistException() {
		System.out.println("Le nom de l'item existe déjà");
	}
}
