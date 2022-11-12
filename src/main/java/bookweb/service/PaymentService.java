/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookweb.service;

import bookweb.model.Payment;
import java.util.List;

/**
 *
 * @author PhucNguyen
 */
public interface PaymentService {

    public List<Payment> getAll();

    public Payment getPaymentById(int id);

    public Payment savePayment(Payment payment);

    public List<Payment> saveListPayment(List<Payment> listPayment);

    public String deletePayment(int id);

    public Payment updatePayment(Payment payment);

}
