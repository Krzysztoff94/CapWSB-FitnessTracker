package com.capgemini.wsb.fitnesstracker.user.api;

import com.capgemini.wsb.fitnesstracker.user.internal.UserDto;

import java.util.List;
import java.util.Optional;

/**
 * Interface (API) for modifying operations on {@link User} entities through the API.
 * Implementing classes are responsible for executing changes within a database transaction, whether by continuing an existing transaction or creating a new one if required.
 */
public interface UserService {

    User createUser(User user);

    /**
     * Creates a new user.
     *
     * @param userDto The user data transfer object containing information about the user to be created.
     * @return The created user.
     */
    User saveUser(UserDto userDto);
    /**
     * Retrieves all users.
     *
     * @return List of all users.
     */
    List<User> getAllUsers();

    /**
     * Retrieves a user by their ID.
     *
     * @param userId The ID of the user to retrieve.
     * @return The user with the specified ID, or null if no such user exists.
     */
    Optional<User> getUserById(Long userId);


    /**
     * Updates an existing user.
     *
     * @param userId  The ID of the user to update.
     * @param userDto The user data transfer object containing updated information about the user.
     * @return The updated user.
     */
    User updateUser(Long userId, UserDto userDto);

    List<User> findAllUsers();

    /**
     * Deletes a user.
     *
     * @param userId The ID of the user to delete.
     */
    void deleteUser(Long userId);

    Long saveUser(User user1);

    Optional<User> findUserById(Long userId);
}
