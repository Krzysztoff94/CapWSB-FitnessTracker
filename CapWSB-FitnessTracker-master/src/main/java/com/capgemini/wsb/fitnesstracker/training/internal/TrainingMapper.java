package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingDto;

import java.util.List;
import java.util.stream.Collectors;

public class TrainingMapper {
    public TrainingDto toDto(Training training) {
        return null;
    }

    public Training toEntity(TrainingDto trainingDto) {
        return null;
    }

    public List<TrainingDto> toDtoList(List<Training> trainings) {
        return trainings.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Training mapDtoToEntity(TrainingDto trainingDto) {
        return null;
    }

    public Object mapEntityToDto(Training training) {
        return null;
    }
}
