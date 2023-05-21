package kodlama.io.rentacar.business.rules;

import kodlama.io.rentacar.common.constants.Messages;
import kodlama.io.rentacar.core.exceptions.BusinessException;
import kodlama.io.rentacar.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class CarBusinessRules {
    private final CarRepository carRepository;

    public void checkIfCarExists(int id) {
        if (!carRepository.existsById(id)) {
            throw new BusinessException(Messages.Car.NotExists);
        }
    }
    public void checkIfCarExistsByPlate(String plate) {
        if (!carRepository.existsByPlate(plate)) {
            throw new BusinessException(Messages.Car.PlateExists);
        }
    }
}
