package kodlama.io.rentacar.business.dto.requests.update;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import kodlama.io.rentacar.common.constants.Regex;
import kodlama.io.rentacar.common.utils.annotations.NotFutureYear;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequest {
    private int modelId;
    @Min(1)
    @Max(100000)
    private double dailyPrice;
    @Min(1996)
    @Max(2023)
    @NotFutureYear
    private int modelYear;
    @Pattern(regexp = Regex.Plate, message = "Plate number must match the pattern")
    private String plate;
}
