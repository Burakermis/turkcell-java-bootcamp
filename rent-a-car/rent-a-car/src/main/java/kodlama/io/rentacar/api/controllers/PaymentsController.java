package kodlama.io.rentacar.api.controllers;

import jakarta.validation.Valid;
import kodlama.io.rentacar.business.abstracts.PaymentService;
import kodlama.io.rentacar.business.dto.requests.create.CreatePaymentRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdatePaymentRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreatePaymentResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllPaymentsResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetPaymentResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdatePaymentResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/payments")
public class PaymentsController {
    private final PaymentService paymentService;

    @GetMapping
    List<GetAllPaymentsResponse> getAll(){
        return paymentService.getAll();
    }
    @GetMapping("/{id}")
    GetPaymentResponse getById(@PathVariable int id){
        return paymentService.getById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    CreatePaymentResponse add(@Valid @RequestBody CreatePaymentRequest request){
        return paymentService.add(request);
    }
    @PutMapping("/{id}")
    UpdatePaymentResponse update(@PathVariable int id,@Valid @RequestBody UpdatePaymentRequest request){
        return paymentService.update(id,request);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    void delete(@PathVariable int id){
        paymentService.delete(id);
    }

}
