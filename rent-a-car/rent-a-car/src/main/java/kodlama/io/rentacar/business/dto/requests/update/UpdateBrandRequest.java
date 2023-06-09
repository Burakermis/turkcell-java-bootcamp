package kodlama.io.rentacar.business.dto.requests.update;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBrandRequest {
    @NotBlank
    @Length(min =2, message = "length must be greater than 2")
    private String name;
}
