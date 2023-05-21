package kodlama.io.rentacar.business.rules;

import kodlama.io.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentacar.common.constants.Messages;
import kodlama.io.rentacar.core.exceptions.BusinessException;
import kodlama.io.rentacar.entities.enums.State;
import kodlama.io.rentacar.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MaintenanceBusinessRules {
    private final MaintenanceRepository maintenanceRepository;
    public void checkIfMaintenanceExists(int id) {
        if (!maintenanceRepository.existsById(id)) throw new IllegalArgumentException(Messages.Maintenance.NotExists);
    }

    public void checkIfCarUnderMaintenance(int carId){
        if(maintenanceRepository.existsByCarIdAndIsCompletedIsFalse(carId)){
            throw new BusinessException(Messages.Maintenance.CarExists);
        }
    }

    public void checkIfCarIsNotUnderMaintenance(int carId){
        if(!maintenanceRepository.existsByCarIdAndIsCompletedIsFalse(carId)){
            throw new BusinessException(Messages.Maintenance.CarNotExists);
        }
    }

    public void checkCarAvailabilityForMaintenance(State state) {
        if (state.equals(State.RENTED)) {
            throw new BusinessException(Messages.Maintenance.CarIsRented);
        }
    }


}
