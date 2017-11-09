package elte.alkfejlbead.webshop.controller;

import elte.alkfejlbead.webshop.entity.Status;
import elte.alkfejlbead.webshop.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @PostMapping("/orderstatus")
    public void changeOrderStatus(@RequestBody  Status status) {
        statusService.changeOrderStatus(status);
    }

    @PostMapping("/shippingstatus")
    public void changeShippingStatus(@RequestBody  Status status) {
        statusService.changeShippingStatus(status);
    }
}
