package kodlama.io.rentacar.business.rules;

import kodlama.io.rentacar.common.constants.Messages;
import kodlama.io.rentacar.core.exceptions.BusinessException;
import kodlama.io.rentacar.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelBusinessRules {
    private final ModelRepository modelRepository;
    public void checkIfModelExistsById(int id) {
        if (!modelRepository.existsById(id)) {
            throw new BusinessException(Messages.Model.NotExists);
        }
    }

    public void checkIfModelExistsByName(String name) {
        if (modelRepository.existsByNameIgnoreCase(name)) {
            throw new BusinessException(Messages.Model.Exists);
        }
    }
}
