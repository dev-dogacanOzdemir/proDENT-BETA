package com.example.prodentv111.controller;

import com.example.prodentv111.entities.Appointment;
import com.example.prodentv111.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppointmentController {
    @Autowired
    private AppointmentRepository aRepo;
    @GetMapping("/allAppointments")
    public ModelAndView getAllAppointment(){
        ModelAndView mav = new ModelAndView("list-appointments");
        List<Appointment> list = aRepo.findAll();
        mav.addObject("appointmentss",list);
        return mav;
    }
    @GetMapping("/addAppointment")
    public ModelAndView addAppointment(){
        ModelAndView mav = new ModelAndView("add-appointment");
        Appointment appointment = new Appointment();
        mav.addObject("appointment",appointment);
        return mav;
    }
    @PostMapping("/saveAppointment")
    public String saveAppointment(@ModelAttribute Appointment appointment){
        aRepo.save(appointment);
        return "redirect:/allAppointments";
    }
    @GetMapping("/updateAppointment")
    public ModelAndView updateAppointment(@RequestParam Long randevuID){
        ModelAndView mav = new ModelAndView("add-appointment");
        Appointment appointment = aRepo.findById(randevuID).get();
        mav.addObject("appointment",appointment);
        return mav;
    }
    @GetMapping("/deleteAppointment")
    public String deleteAppointment(@RequestParam Long randevuID){
        aRepo.deleteById(randevuID);
        return "redirect:/allAppointment";
    }


}
