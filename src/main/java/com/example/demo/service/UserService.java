package com.example.demo.service;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.mapper.PhoneMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Phone;
import com.example.demo.model.User;
import com.example.demo.repository.PhoneRepository;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) throws UserAlreadyExistsException {
        // Transform the DTO into an Entity
        User user = UserMapper.INSTANCE.userRequestDTOtoUser( userRequestDTO );

        // Check if the User already exists
        if(userRepository.existsByEmail(user.getEmail())){
            throw new UserAlreadyExistsException(String.format("El correo %s ya está registrado", user.getEmail()));
        }
        // Save the User
        user.setActive(true);
        userRepository.save(user);
        log.info("User saved: {}", user);

        // Transform and save the Phones
       userRequestDTO.getPhones(). forEach(phoneDTO -> {
           Phone phone = PhoneMapper.INSTANCE.phoneDTOtoPhone(phoneDTO);
           phone.setUser(user);
           phoneRepository.save(phone);
           log.info("Phone saved: {}", phone);
         });
        return UserMapper.INSTANCE.usertoUserResponseDTO( user );
    }
}
