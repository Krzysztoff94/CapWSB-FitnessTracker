package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface TrainingRepository extends JpaRepository<Training, Long> {

    List<Training> findByUser_Id(Long userId);

    Optional<Training> findByIdAndUser_Id(Long trainingId, Long userId);
    Optional<Training> findById(Long id);

}
