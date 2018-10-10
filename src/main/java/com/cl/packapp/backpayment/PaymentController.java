package com.cl.packapp.backpayment;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cl.packapp.backpayment.dao.PaymentRepository;
import com.cl.packapp.backpayment.model.Payment;

@RestController
public class PaymentController {
	
	@Autowired
	private PaymentRepository repository;
		
	@RequestMapping(value="/payment/{id}", method=RequestMethod.GET)
	public ResponseEntity viewPaymentById(@PathVariable("id") String id) {
		
		Optional<Payment> payment = repository.findById(id);
		
		if (payment==null || !payment.isPresent()	) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Payment>(payment.get(), HttpStatus.OK);
		}
		
		
	}
	
	
	

	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> createPayment(@RequestBody Payment payment, UriComponentsBuilder ucBuilder) {
		
		payment = repository.save(payment);
		
		System.out.println("---- Paymt " + payment.getId() + " added");
		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/payment/{id}").buildAndExpand(payment.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
}
