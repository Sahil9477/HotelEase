package com.example.HotelEase.Services;

import java.util.List;

import com.example.HotelEase.Entities.ServiceEntity;

public interface ServiceService {
    List<ServiceEntity> getAllServices();
    ServiceEntity getServiceById(Integer id);
    ServiceEntity addService(ServiceEntity service);
    void deleteService(Integer id);
}
