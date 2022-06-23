package org.example.Exception;

public class TodolistMaxItemsReached extends Exception {
	public TodolistMaxItemsReached() {
		System.out.println("Je pense que tu es arrivé au bout de ton stock, appuis sur 3 pour voir tes items");
	}
}
