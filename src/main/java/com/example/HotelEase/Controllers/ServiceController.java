package com.example.HotelEase.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.HotelEase.Entities.ServiceEntity;
import com.example.HotelEase.Services.ServiceService;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping
    public List<ServiceEntity> getAllServices() {
        return serviceService.getAllServices();
    }

    @GetMapping("/{id}")
    public ServiceEntity getServiceById(@PathVariable Integer id) {
        return serviceService.getServiceById(id);
    }

    @PostMapping
    public ServiceEntity addService(@RequestBody ServiceEntity service) {
        return serviceService.addService(service);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Integer id) {
        serviceService.deleteService(id);
    }
}
