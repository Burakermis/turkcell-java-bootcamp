package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.CarService;
import kodlama.io.rentacar.business.abstracts.MaintenanceService;
import kodlama.io.rentacar.business.dto.requests.create.CreateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateMaintenanceRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllMaintenancesResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetMaintenanceResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateMaintenanceResponse;
import kodlama.io.rentacar.business.rules.MaintenanceBusinessRules;
import kodlama.io.rentacar.entities.Maintenance;
import kodlama.io.rentacar.entities.enums.State;
import kodlama.io.rentacar.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService {
    private final MaintenanceRepository repository;
    private final ModelMapper mapper;
    private final CarService carService;
    private final MaintenanceBusinessRules maintenanceBusinessRules;

    @Override
    public List<GetAllMaintenancesResponse> getAll() {
        List<Maintenance> maintenances = repository.findAll();
        List<GetAllMaintenancesResponse> response= maintenances
                .stream()
                .map(maintenance -> mapper.map(maintenance, GetAllMaintenancesResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetMaintenanceResponse getById(int id) {
        maintenanceBusinessRules.checkIfMaintenanceExists(id);
        Maintenance maintenance = repository.findById(id).orElseThrow();
        GetMaintenanceResponse response = mapper.map(maintenance, GetMaintenanceResponse.class);

        return response;
    }

    //Bakımı bitirmek için -> Car'ın Available duruma gelmesi.
    @Override
    public GetMaintenanceResponse returnCarFromMaintenance(int carId) {
        maintenanceBusinessRules.checkIfCarIsNotUnderMaintenance(carId);
        Maintenance maintenance = repository.findByCarIdAndIsCompletedIsFalse(carId);
        maintenance.setCompleted(true);
        maintenance.setEndDate(LocalDateTime.now());
        repository.save(maintenance);
        carService.changeState(carId, State.AVAILABLE); // Update edildi, car bakımdan çıktı.
        GetMaintenanceResponse response = mapper.map(maintenance, GetMaintenanceResponse.class);

        return response;
    }

    @Override
    public CreateMaintenanceResponse add(CreateMaintenanceRequest request) {
        maintenanceBusinessRules.checkIfCarUnderMaintenance(request.getCarId());
        maintenanceBusinessRules.checkCarAvailabilityForMaintenance(carService.getById(request.getCarId()).getState());
        Maintenance maintenance = mapper.map(request, Maintenance.class);
        maintenance.setId(0);
        maintenance.setCompleted(false);
        maintenance.setStartDate(LocalDateTime.now());
        maintenance.setEndDate(null);
        repository.save(maintenance);
        carService.changeState(request.getCarId(), State.MAINTENANCE); // Car bakıma girdi.
        CreateMaintenanceResponse response = mapper.map(maintenance, CreateMaintenanceResponse.class);

        return response;
    }

    @Override
    public UpdateMaintenanceResponse update(int id, UpdateMaintenanceRequest request) {
        maintenanceBusinessRules.checkIfMaintenanceExists(id);
        Maintenance maintenance = mapper.map(request, Maintenance.class);
        maintenance.setId(id);
        repository.save(maintenance);
        UpdateMaintenanceResponse response = mapper.map(maintenance, UpdateMaintenanceResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        maintenanceBusinessRules.checkIfMaintenanceExists(id);
        makeCarAvailableCompletedFalse(id);
        repository.deleteById(id);
    }
    private void makeCarAvailableCompletedFalse(int id){
        int carId = repository.findById(id).get().getCar().getId();
        if(repository.existsByCarIdAndIsCompletedIsFalse(carId)){
            carService.changeState(id, State.AVAILABLE);
        }
    }
}