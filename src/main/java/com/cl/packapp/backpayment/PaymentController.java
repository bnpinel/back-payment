package com.cl.packapp.backpayment;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cl.packapp.backpayment.dao.PaymentRepository;
import com.cl.packapp.backpayment.model.Payment;

@RestController
public class PaymentController {
	
	@Autowired
	private PaymentRepository repository;
	
	
	@RequestMapping(value="/payment/{card_id}", method=RequestMethod.GET)
	public Optional<Payment> viewPaymentByCardId(@PathVariable("card_id") String card_id) {
		return repository.findByCardId(card_id);
	}
	
	
	
	@RequestMapping(value="/payment/{card_id}", method=RequestMethod.POST)
	public ResponseEntity<?> editCard(@RequestBody Card card, UriComponentsBuilder ucBuilder) {
		
		card = repository.save(card);
		
		System.out.println("---- Card " + card.getId() + " added");
		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/card{id}").buildAndExpand(card.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value="/card/{id}", method=RequestMethod.PUT)
	public ResponseEntity<?> editCard(@PathVariable("id") String id, @RequestBody Card card, UriComponentsBuilder ucBuilder) {
		
		card = repository.save(card);
		
		System.out.println("---- Card " + card.getId() + " edited");
		
        return new ResponseEntity<Card>(card, HttpStatus.OK);
	}

}
