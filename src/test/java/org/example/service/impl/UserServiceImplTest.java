package org.example.service.impl;

import org.example.dao.UserRepository;
import org.example.exception.EntityNotFoundException;
import org.example.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

	private final long ID = 1L;
	private final String NAME = "Name";
	private final String EMAIL = "email@mail.com";

	@Mock
	private UserRepository mockRepository;

	@InjectMocks
	private UserServiceImpl userService;

	@Test
	void getUserByIdTestWithExistingId() {
		when(mockRepository.get(ID)).thenReturn(Optional.of(new User(ID, NAME, EMAIL)));
		var user = userService.getUserById(ID);
		assertEquals(user.getId(), ID);
	}

	@Test
	void getUserByIdTestWithNonExistingId() {
		when(mockRepository.get(ID)).thenReturn(Optional.empty());
		var exception = assertThrows(EntityNotFoundException.class, () -> userService.getUserById(ID));
		assertEquals("User not found by id: 1", exception.getMessage());
	}

	@Test
	void getUserByEmailTestWithExistingId() {
		when(mockRepository.getUserByEmail(EMAIL)).thenReturn(Optional.of(new User(ID, NAME, EMAIL)));
		var user = userService.getUserByEmail(EMAIL);
		assertEquals(user.getEmail(), EMAIL);
	}

	@Test
	void getUserByEmailTestWithNonExistingId() {
		when(mockRepository.getUserByEmail(EMAIL)).thenReturn(Optional.empty());
		var exception = assertThrows(EntityNotFoundException.class, () -> userService.getUserByEmail(EMAIL));
		assertEquals("User not found by email: email@mail.com", exception.getMessage());
	}

}
