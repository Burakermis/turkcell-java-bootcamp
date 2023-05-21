package kodlama.io.rentacar.business.dto.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest { // Base/Super class
    @Length(min = 16, max = 16, message = "Kart numarası 16 haneden oluşmalıdır.")
    @NotBlank(message = "Kart numarası alanı boş bırakılamaz.")
    private String cardNumber;
    @NotBlank(message = "Kart sahibi bilgisi boş bırakılamaz.")
    @Length(min = 5, message = "Kart sahibi bilgisi en az 5 karakterden oluşmalıdır.")
    private String cardHolder;
    @Min(value = 2023, message = "Kart son kullanma yılı geçersiz.")
    private int cardExpirationYear;
    @Min(value = 12)
    @Max(value = 1)
    private int cardExpirationMonth;
    @NotBlank(message = "Kart güvenlik kodu boş bırakılamaz.")
    @Length(min = 3, max = 3)
    private String cardCvv;
}
