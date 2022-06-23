package org.example;

import static org.junit.Assert.assertEquals;

import org.example.Entity.Item;
import org.example.Entity.Todolist;
import org.example.Entity.User;
import org.example.Exception.*;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class AppTest {
	/* Creation de user
	 */
	@Test
	public void createUserTest() {
		User myTestUser = new User("Nono", "Issou", LocalDate.of(1995, 4, 2), "testmail@gmail.com", "mytestpassword", new Todolist());
		assertEquals("Nono", myTestUser.getFirstname());
		assertEquals("Issou", myTestUser.getLastname());
		assertEquals(LocalDate.of(1995, 4, 2), myTestUser.getBirthday());
		assertEquals("testmail@gmail.com", myTestUser.getMailAddress());
		assertEquals("mytestpassword", myTestUser.getPassword());
		assertEquals(0, myTestUser.getTodolist().getItems().size());
	}

	/* Verify if user is under 13 years old
	 */
	@Test(expected = InvalideOldException.class)
	public void userIsValidShouldThrowInvalideOldException() throws InvalideEmailException, InvalidePasswordLengthException, InvalideOldException {
		User myTestUser = new User("Nono", "Issou", LocalDate.now(), "testmail@gmail.com", "coucou", new Todolist());
		myTestUser.isValid();
	}

	/* Verify if e-mail is correct
	 */
	@Test(expected = InvalideEmailException.class)
	public void userIsValidShouldThrowInvalideEmailException() throws InvalideEmailException, InvalidePasswordLengthException, InvalideOldException {
		User myTestUser = new User("Nono", "Issou", LocalDate.of(1995, 4, 19), "testmailtestmailboxfr", "coucou", new Todolist());
		myTestUser.isValid();
	}

	/* Verify if password is between 8 and 40 characters
	 */
	@Test(expected = InvalidePasswordLengthException.class)
	public void userIsValidShouldThrowInvalidePasswordLengthException() throws InvalideEmailException, InvalideOldException, InvalidePasswordLengthException {
		User myTestUser = new User("Nono", "Issou", LocalDate.of(1995, 4, 19), "testmail@gmail.com", "coucou", new Todolist());
		myTestUser.isValid();
	}

	/* Creation of todolist
	 */
	@Test
	public void createTodolistTest() {
		Todolist myTestTodolist = new Todolist();
		assertEquals(0, myTestTodolist.getItems().size());
	}

	/* Verify when 10 items reached throw exception
	 */
	@Test(expected = TodolistMaxItemsReached.class)
	public void todolistAddShouldThrowTodolistMaxItemsReachedException() throws TodolistMaxItemsReached, InvalideItemContentException, ItemNameAlreadyExistException {
		Todolist myTestTodolist = new Todolist();
		for (int i = 0; i <= 11; i++) {
			long testNow = LocalDateTime.of(1995, 4, 2, 3, 3, 3).toEpochSecond(ZoneOffset.UTC);
			myTestTodolist.add(
					new Item("testItemName" + Integer.toString(i), "testItemContent" + Integer.toString(i), new Date(testNow + ((i + 1) * 30 * 60 * 1000)))
					);
		}
	}

	/* Verify
	 * test if is todolist.add() function throw the correct exception when item content over 100 char
	 */
	@Test(expected = InvalideItemContentException.class)
	public void todolistAddShouldThrowInvalidItemContentException() throws TodolistMaxItemsReached, InvalideItemContentException, ItemNameAlreadyExistException {
		Todolist myTestTodolist = new Todolist();
		myTestTodolist.add(
				new Item("testName",
						"nonoIssouxDnonoIssouxDnonoIssouxDnonoIssouxDnonoIssouxDnonoIssouxDnonoIssouxDnonoIssouxDnonoIssouxDnonoIssouxDnonoIssouxD",
						new Date())
		);
	}

	/* Verify if name existe in todolist thorw exeption
	 */
	@Test(expected = ItemNameAlreadyExistException.class)
	public void todolistAddShouldThrowItemNameAlreadyExistException() throws TodolistMaxItemsReached, InvalideItemContentException, ItemNameAlreadyExistException {
		Todolist myTestTodolist = new Todolist();
		for (int i = 0; i <= 3; i++) {
			long testNow = LocalDateTime.of(1995, 7, 5, 4, 9, 55).toEpochSecond(ZoneOffset.UTC);
			myTestTodolist.add(
					new Item("testName" , "testContent", new Date(testNow + ((i + 1) * 30 * 60 * 1000)))
			);
		}
	}

	/* Creation items
	 */
	@Test
	public void createItemTest() {
		Date myTestDate = new Date();
		Item myTestItem = new Item("testItemName", "testItemContent", myTestDate);
		assertEquals("testItemName", myTestItem.getName());
		assertEquals("testItemContent", myTestItem.getContent());
		assertEquals(myTestDate, myTestItem.getCreationDate());
	}
}
