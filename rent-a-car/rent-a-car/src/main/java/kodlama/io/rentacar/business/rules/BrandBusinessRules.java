package kodlama.io.rentacar.business.rules;

import kodlama.io.rentacar.common.constants.Messages;
import kodlama.io.rentacar.core.exceptions.BusinessException;
import kodlama.io.rentacar.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private final BrandRepository brandRepository;
    public void checkIfBrandExistsById(int id) {
        if (!brandRepository.existsById(id)) throw new BusinessException(Messages.Brand.MotExists);
    }

    public void checkIfBrandExistsByName(String name) {
        if (brandRepository.existsByNameIgnoreCase(name)) {
            throw new BusinessException(Messages.Brand.Exists);
        }
    }
}
