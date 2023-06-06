package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
     void testGetUser() {
       /* User user = new User();
        user.setId(1);
        user.setName("Test User");

        Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(user));

        User result = userService.getUser(1);

        assertEquals(user, result);*/
    }

}

