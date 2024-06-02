package com.capgemini.wsb.fitnesstracker.user.internal;

import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.api.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private  UserRepository userRepository;
    private  UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User saveUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public User updateUser(Long userId, UserDto userDto) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser == null) {
            log.error("User with id {} not found", userId);
            return null;
        }

        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());

        return userRepository.save(existingUser);
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Long saveUser(User user1) {
        return user1.getId();
    }

    @Override
    public Optional<User> findUserById(Long userId) {
        return Optional.empty();
    }
}


