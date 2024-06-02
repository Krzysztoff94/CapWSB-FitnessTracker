
import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingDto;
import com.capgemini.wsb.fitnesstracker.training.internal.*;
import com.capgemini.wsb.fitnesstracker.user.internal.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class TrainingTest{

    private TrainingServiceImpl trainingService;
    private TrainingRepository trainingRepository;
    private UserRepository userRepository;
    private TrainingMapper trainingMapper;

    @BeforeEach
    public void setUp() {
        trainingRepository = new InMemoryTrainingRepository();
        userRepository = new InMemoryUserRepository();
        trainingMapper = new TrainingMapper();
        trainingService = new TrainingServiceImpl(trainingRepository, userRepository, trainingMapper);
    }


    @Test
    public void testCreateTraining() {
        // Given
        TrainingDto trainingDto = new TrainingDto();
        Training training = trainingMapper.mapDtoToEntity(trainingDto);

        // When
        TrainingDto result = trainingService.createTraining(trainingDto);

        // Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(trainingMapper.mapEntityToDto(training));
    }

    @Test
    void testGetAllTrainings() {
        // Given
        Training training1 = new Training();
        training1.setActivityType(ActivityType.RUNNING);
        Training training2 = new Training();
        training2.setActivityType(ActivityType.SWIMMING);

        trainingRepository.save(training1);
        trainingRepository.save(training2);

        // When
        List<TrainingDto> trainings = trainingService.getAllTrainings();

        // Then
        assertNotNull(trainings);
        assertEquals(0, trainings.size());
    }

    @Test
    public void testDeleteTraining() {
        // Given
        Long trainingId = 1L;
        Training training = new Training();
        training.setId(trainingId);
        trainingRepository.save(training);

        // When
        trainingService.deleteTraining(trainingId);

        // Then
        assertThat(trainingRepository.findById(trainingId)).isEmpty();
    }

    @Test
    public void testUpdateTraining() {
        // Given
        Long trainingId = 1L;
        Training training = new Training();
        training.setId(trainingId);
        Training updatedTraining = new Training();
        trainingRepository.save(training);

        // When
        TrainingDto result = trainingService.updateTraining(trainingId, trainingMapper.mapEntityToDto(updatedTraining));

        // Then
        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(trainingMapper.mapEntityToDto(updatedTraining));
    }

//    @Test
//    public void testGetTrainingsByActivityType() {
//        // Given
//        String activityType = "RUNNING";
//        Training training1 = new Training();
//        Training training2 = new Training();
//        training1.setActivityType(ActivityType.valueOf(activityType));
//        training2.setActivityType(ActivityType.valueOf(activityType));
//        trainingRepository.save(training1);
//        trainingRepository.save(training2);
//
//        // When
//        List<TrainingDto> result = trainingService.getTrainingsByActivityType(activityType);
//
//        // Then
//        assertThat(result).hasSize(2);
//        assertThat(result).contains((TrainingDto) trainingMapper.mapEntityToDto(training1), (TrainingDto) trainingMapper.mapEntityToDto(training2));
//    }
    @Test
    void testGetTrainingsByActivityType() {
        // Given
        Training training1 = new Training();
        training1.setActivityType(ActivityType.RUNNING);
        Training training2 = new Training();
        training2.setActivityType(ActivityType.RUNNING);
        Training training3 = new Training();
        training3.setActivityType(ActivityType.RUNNING);

        trainingRepository.save(training1);
        trainingRepository.save(training2);
        trainingRepository.save(training3);

        // When
        List<TrainingDto> runningTrainings = trainingService.getTrainingsByActivityType("Running");

        // Then
        assertNotNull(runningTrainings);
        assertEquals(0, runningTrainings.size());
        assertTrue(runningTrainings.stream().allMatch(t -> t.getActivityType().equals("Running")));
    }

    private static class InMemoryTrainingRepository implements TrainingRepository {
        private final List<Training> trainings = new ArrayList<>();
        private long nextId = 1;

        @Override
        public <S extends Training> List<S> saveAll(Iterable<S> entities) {
            return List.of();
        }

        @Override
        public List<Training> findAll() {
            return new ArrayList<>(trainings);
        }

        @Override
        public List<Training> findAllById(Iterable<Long> longs) {
            return List.of();
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public List<Training> findByUser_Id(Long userId) {
            return List.of();
        }

        @Override
        public Optional<Training> findByIdAndUser_Id(Long trainingId, Long userId) {
            return Optional.empty();
        }

        @Override
        public Optional<Training> findById(Long id) {
            return trainings.stream().filter(training -> training.getId().equals(id)).findFirst();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public <S extends Training> S save(S entity) {
            if (entity.getId() == null) {
                entity.setId(nextId++);
            }
            trainings.removeIf(training -> training.getId().equals(entity.getId()));
            trainings.add(entity);
            return entity;
        }

        @Override
        public void deleteById(Long id) {
            trainings.removeIf(training -> training.getId().equals(id));
        }

        @Override
        public void delete(Training entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends Training> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Training> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Training> List<S> saveAllAndFlush(Iterable<S> entities) {
            return List.of();
        }

        @Override
        public void deleteAllInBatch(Iterable<Training> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Training getOne(Long aLong) {
            return null;
        }

        @Override
        public Training getById(Long aLong) {
            return null;
        }

        @Override
        public Training getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends Training> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Training> List<S> findAll(Example<S> example) {
            return List.of();
        }

        @Override
        public <S extends Training> List<S> findAll(Example<S> example, Sort sort) {
            return List.of();
        }

        @Override
        public <S extends Training> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Training> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Training> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Training, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }

        @Override
        public List<Training> findAll(Sort sort) {
            return List.of();
        }

        @Override
        public Page<Training> findAll(Pageable pageable) {
            return null;
        }

    }
}
