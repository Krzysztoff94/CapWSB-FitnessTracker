package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.exception.api.NotFoundException;

/**
 * Exception indicating that the {@link Training} was not found.
 */
@SuppressWarnings("squid:S110")
public class TrainingNotFoundException extends NotFoundException {


    public TrainingNotFoundException(Long id) {
        super("Training with ID=" + id + " was not found");
    }

    public TrainingNotFoundException(String s) {
        super(s);
    }

//    public TrainingNotFoundException(String id) {
//        this(String.valueOf(Long.valueOf("Training with ID=%s was not found".formatted(id))));
//    }

//    public TrainingNotFoundException(String s) {
//        super(s);
//    }
}
