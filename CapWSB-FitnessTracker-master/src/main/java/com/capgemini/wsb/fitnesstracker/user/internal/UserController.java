package com.capgemini.wsb.fitnesstracker.user.internal;

import com.capgemini.wsb.fitnesstracker.user.api.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
class UserController {

    private final UserServiceImpl userService;

    private final UserMapper userMapper;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers()
                          .stream()
                          .map(userMapper::toDto)
                          .toList();
    }
    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public User addUser(@RequestBody UserDto userDto) throws InterruptedException {

        // Demonstracja how to use @RequestBody
        System.out.println("User with e-mail: " + userDto.email() + "passed to the request");

        // TODO: saveUser with Service and return User
        return userService.saveUser(userDto);
    }
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody UserDto userDto) {
        return userService.updateUser(userId, userDto);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

}