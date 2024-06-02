package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingDto;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingNotFoundException;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingProvider;
import com.capgemini.wsb.fitnesstracker.user.internal.UserRepository;

import java.util.List;
import java.util.Optional;

// TODO: Provide Impl
public class TrainingServiceImpl implements TrainingProvider {

    private final TrainingRepository trainingRepository;
    private final TrainingMapper trainingMapper;

   // @Autowired
    public TrainingServiceImpl(TrainingRepository trainingRepository, UserRepository userRepository, TrainingMapper trainingMapper) {
        this.trainingRepository = trainingRepository;
        this.trainingMapper = trainingMapper;
    }

    @Override
    public Optional<Training> getTraining(Long trainingId) {
        return trainingRepository.findById(trainingId);
    }

    @Override
    public TrainingDto createTraining(Long user, TrainingDto trainingDto) {
        Training training = trainingMapper.toEntity(trainingDto);
        training.setUserId(user);
        return trainingMapper.toDto(trainingRepository.save(training));
    }

    @Override
    public List<TrainingDto> getUserTrainings(Long user) {
        List<Training> userTrainings = trainingRepository.findByUser_Id(user);
        return trainingMapper.toDtoList(userTrainings);
    }

    @Override
    public TrainingDto updateTraining(Long user, Long trainingId, TrainingDto trainingDto) {

        Training existingTraining = trainingRepository.findByIdAndUser_Id(trainingId, user)
                .orElseThrow(() -> new TrainingNotFoundException("Training not found for user: " + user));

        existingTraining.setName(trainingDto.getName());
        return trainingMapper.toDto(trainingRepository.save(existingTraining));
    }

    @Override
    public List<TrainingDto> getAllTrainings() {
        return List.of();
    }

    @Override
    public void deleteTraining(Long trainingId) {

    }

    @Override
    public TrainingDto updateTraining(Long trainingId, Object o) {
        return null;
    }

    @Override
    public List<TrainingDto> getTrainingsByActivityType(String activityType) {
        return List.of();
    }

    @Override
    public TrainingDto createTraining(TrainingDto trainingDto) {
        return null;
    }

}
