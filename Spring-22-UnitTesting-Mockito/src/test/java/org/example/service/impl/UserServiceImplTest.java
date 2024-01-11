package org.example.service.impl;

import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserServiceImpl userService;



    @Test
    void deleteByUserName_test() {
        userService.deleteByUserName("mikesmith@example.com");

//        verify(userRepository, times(2)).deleteByUserName("mikesmith@example.com");
        verify(userRepository, atLeastOnce()).deleteByUserName("mikesmith@example.com");

        InOrder inOrder = inOrder(userRepository);

        inOrder.verify(userRepository).deleteByUserName("mikesmith@example.com");
        inOrder.verify(userRepository).findAll();

    }






}