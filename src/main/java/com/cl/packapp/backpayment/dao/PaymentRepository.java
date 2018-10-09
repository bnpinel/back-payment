package com.cl.packapp.backpayment.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cl.packapp.backpayment.model.Payment;

public interface PaymentRepository extends MongoRepository<Payment, String> {

	public List<Payment> findByCardId(String cardID);


}

