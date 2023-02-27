package com.lp4.moviebook.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lp4.moviebook.dto.ResponseMovieDTO;
import com.lp4.moviebook.exception.AlreadyExistsException;
import com.lp4.moviebook.model.User;
import com.lp4.moviebook.repository.UserRepository;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @BeforeAll
    public User createUserForTest(){
        List<ResponseMovieDTO> watchList = new ArrayList<>();
        List<ResponseMovieDTO> watchedList = new ArrayList<>();
        return new User("1", "Luiz", "18", watchedList, watchList);
    }

    @Test
    public void createUserSuccessTest() {
        User user = createUserForTest();
        when(userRepository.existsById(user.getId())).thenReturn(false);
        when(userRepository.save(user)).thenReturn(user);
        User savedUser = userService.createUser(user);
        assertEquals(user.getId(), savedUser.getId());
    }

    @Test
    public void createUserAlreadyExistsTest() {
        User user = createUserForTest();
        when(userRepository.existsById(user.getId())).thenReturn(true);
        try {
            userService.createUser(user);
        } catch (AlreadyExistsException e) {
            assertEquals("User already exists with id: " + user.getId(), e.getMessage());
        }
    }
}