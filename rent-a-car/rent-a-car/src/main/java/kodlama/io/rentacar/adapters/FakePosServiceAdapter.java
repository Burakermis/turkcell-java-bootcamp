package kodlama.io.rentacar.adapters;

import kodlama.io.rentacar.business.abstracts.PosService;
import kodlama.io.rentacar.common.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class FakePosServiceAdapter implements PosService {
    @Override
    public void pay() {
        boolean isPaymentSuccess = new Random().nextBoolean();
        if(!isPaymentSuccess) throw new RuntimeException(Messages.Payment.Failed);
    }
}
