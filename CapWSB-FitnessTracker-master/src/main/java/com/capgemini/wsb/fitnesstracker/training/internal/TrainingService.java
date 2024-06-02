package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.TrainingDto;

import java.util.List;

public interface TrainingService {

    /**
     * Tworzy nowy trening dla użytkownika.
     *
     * @param userId     ID użytkownika.
     * @param trainingDto Dane treningu.
     * @return Nowo utworzony trening.
     */
    TrainingDto createTraining(Long userId, TrainingDto trainingDto);

    /**
     * Pobiera listę treningów dla danego użytkownika.
     *
     * @param userId ID użytkownika.
     * @return Lista treningów użytkownika.
     */
    List<TrainingDto> getUserTrainings(Long userId);

    /**
     * Aktualizuje istniejący trening użytkownika.
     *
     * @param userId     ID użytkownika.
     * @param trainingId ID treningu do aktualizacji.
     * @param trainingDto Zaktualizowane dane treningu.
     * @return Zaktualizowany trening.
     */
    TrainingDto updateTraining(Long userId, Long trainingId, TrainingDto trainingDto);
}
