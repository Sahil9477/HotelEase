package com.example.HotelEase.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.HotelEase.Entities.ServiceEntity;
import com.example.HotelEase.Repositories.ServiceRepository;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<ServiceEntity> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public ServiceEntity getServiceById(Integer id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public ServiceEntity addService(ServiceEntity service) {
        return serviceRepository.save(service);
    }

    @Override
    public void deleteService(Integer id) {
        serviceRepository.deleteById(id);
    }
}
