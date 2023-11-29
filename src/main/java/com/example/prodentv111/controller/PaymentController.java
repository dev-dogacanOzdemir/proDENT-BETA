package com.example.prodentv111.controller;

import com.example.prodentv111.entities.Payment;
import com.example.prodentv111.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PaymentController {
    @Autowired
    private PaymentRepository pRepo;

    @GetMapping("/allPayments")
    public ModelAndView getAllPayments()
    {
        ModelAndView mav = new ModelAndView("list-payments");
        List<Payment> list = pRepo.findAll();
        mav.addObject("payments",list);
        return mav;

    }
    @GetMapping("/addPayment")
    public ModelAndView addPayment()
    {
        ModelAndView mav = new ModelAndView("add-payment");
        Payment yeniOdeme = new Payment();
        mav.addObject("payment",yeniOdeme);
        return mav;
    }
    @PostMapping("/savePayment")
    public String savePayment(@ModelAttribute Payment payment)
    {
        pRepo.save(payment);
        return "redirect:/allPayments";
    }
    @GetMapping("/updatePayment")
    public ModelAndView updatePayment(@RequestParam Long musteriKasaID)
    {
        ModelAndView mav = new ModelAndView("add-payment");
        Payment payment = pRepo.getById(musteriKasaID);
        mav.addObject("payment",payment);
        return mav;
    }
    @GetMapping("/deletePayment")
    public String deletePayment(@RequestParam Long musteriKasaID)
    {
        pRepo.deleteById(musteriKasaID);
        return "redirect:/allPayments";
    }
}
