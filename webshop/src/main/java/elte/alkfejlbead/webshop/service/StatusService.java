package elte.alkfejlbead.webshop.service;

import elte.alkfejlbead.webshop.entity.Status;
import elte.alkfejlbead.webshop.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    @Autowired
    StatusRepository statusRepository;

    public void changeOrderStatus(Status status) {
        Status updatedStatus = statusRepository.findOne(status.getId());
        updatedStatus.setOrderStatus(status.getOrderStatus());
        statusRepository.save(updatedStatus);
    }

    public void changeShippingStatus(Status status) {
        Status updatedStatus = statusRepository.findOne(status.getId());
        updatedStatus.setShippingStatus(status.getShippingStatus());
        statusRepository.save(updatedStatus);
    }
}
