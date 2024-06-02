package com.capgemini.wsb.fitnesstracker.training.api;

import java.util.List;
import java.util.Optional;

public interface TrainingProvider {

    /**
     * Retrieves a training based on their ID.
     * If the user with given ID is not found, then {@link Optional#empty()} will be returned.
     *
     * @param trainingId id of the training to be searched
     * @return An {@link Optional} containing the located Training, or {@link Optional#empty()} if not found
     */
    Optional<Training> getTraining(Long trainingId);

    TrainingDto createTraining(Long userId, TrainingDto trainingDto);

    List<TrainingDto> getUserTrainings(Long userId);

    TrainingDto updateTraining(Long userId, Long trainingId, TrainingDto trainingDto);

    List<TrainingDto> getAllTrainings();

    void deleteTraining(Long trainingId);

    TrainingDto updateTraining(Long trainingId, Object o);

    List<TrainingDto> getTrainingsByActivityType(String activityType);

    TrainingDto createTraining(TrainingDto trainingDto);
}
