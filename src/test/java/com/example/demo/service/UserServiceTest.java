package com.example.demo.service;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Phone;
import com.example.demo.model.User;
import com.example.demo.repository.PhoneRepository;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PhoneRepository phoneRepository;

    @InjectMocks
    private UserService userService;

    private UserRequestDTO userRequestDTO;
    private User user;

    @BeforeEach
    public void setup() {
        // Initialize your test data
        userRequestDTO = new UserRequestDTO();
        userRequestDTO.setEmail("test@example.com");
        userRequestDTO.setPhones(Collections.emptyList());

        user = UserMapper.INSTANCE.userRequestDTOtoUser(userRequestDTO);
    }

    @Test
    void testCreateUserSuccessfully() throws UserAlreadyExistsException {
        // Arrange
        when(userRepository.existsByEmail(user.getEmail())).thenReturn(false);

        // Act
        UserResponseDTO result = userService.createUser(userRequestDTO);

        // Assert
        assertNotNull(result);
        verify(userRepository, times(1)).save(user);
        verify(phoneRepository, times(userRequestDTO.getPhones().size())).save(any(Phone.class));
    }

    @Test
    void testCreateUserWhenUserAlreadyExists() {
        // Arrange
        when(userRepository.existsByEmail(user.getEmail())).thenReturn(true);

        // Act
        assertThrows(UserAlreadyExistsException.class, () -> userService.createUser(userRequestDTO));

        // Assert
        verify(userRepository, times(0)).save(user);
        verify(phoneRepository, times(0)).save(any(Phone.class));
    }
}
