package com.example.prodentv111.controller;

import com.example.prodentv111.entities.Employee;
import com.example.prodentv111.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {
    /* Autowired anotasyonu ile bağımlılığı sağladık. */
    @Autowired
    private EmployeeRepository eRepo;

	/* Tüm müşterilerin listelenmesi için gerekli olan mapping işlemini uyguladık.
	@GetMapping anotasyonu gerekli link bağlantısı sağlıyor.
	Springboot'un kendi kütüphanesinde bulunan ModelAndView bir yer tutucu görevi görüyor ve bizi ulaşmak istediğimiz
	web sayfasına yönlendirip listeleme işlemini yapıyoruz.     */

    @GetMapping("/allEmployees")
    public ModelAndView getAllEmployees()
    {
        ModelAndView mav = new ModelAndView("list-employees");
        List<Employee> list = eRepo.findAll();
        mav.addObject("employees",list);
        return mav;

    }
	/* Müşteri ekleme kısmını tanımladık. add-employee.html sayfasındaki hidden olarak tanımladığımız buton ile
	hem kaydedip hem değiştirme işlemini bu metot üzerinden yapabiliyoruz. */

    @GetMapping("/addEmployee")
    public ModelAndView addEmployee()
    {
        ModelAndView mav = new ModelAndView("add-employee");
        Employee yeniMusteri = new Employee();
        mav.addObject("employee",yeniMusteri);
        return mav;
    }
    /* @PostMapping anotasyonu ile mySQL'e kayıt işlemini bir buton vasıtasıyla yaptırıp tüm müşteriler sayfamıza
    yönlendirme yaptık.
    */
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee)
    {
        eRepo.save(employee);
        return "redirect:/allEmployees";
    }

    /* @RequestParam metotu ile mySQL'den müsteriID bağlantısını sağlayıp gerekli güncelleme işlemlerini tanımladık.
    add-employee.html sayfasındaki hidden olarak tanımladığımız buton ile hem kaydedip hem değiştirme
    işlemini bu metot üzerinden yapabiliyoruz.Raporda daha detaylı bilgiler bulunmaktadır.
     */
    @GetMapping("/updateEmployee")
    public ModelAndView updateEmployee(@RequestParam Long musteriID)
    {
        ModelAndView mav = new ModelAndView("add-employee");
        Employee employee = eRepo.findById(musteriID).get();
        mav.addObject("employee",employee);
        return mav;
    }
    /* Müşteri silme işlemini tanımladık. mySQL'den musteriID kolonuna göre silme işlemi gerçekleştiriyor.
    İşlem tamamlandıktan sonra tüm müşterilerin listelendiği sayfaya yönlendirme yapıyor. */
    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam Long musteriID)
    {
        eRepo.deleteById(musteriID);
        return "redirect:/allEmployees";
    }

}

