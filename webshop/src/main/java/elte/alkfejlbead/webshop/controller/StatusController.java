package elte.alkfejlbead.webshop.controller;

import elte.alkfejlbead.webshop.annotation.Role;
import elte.alkfejlbead.webshop.entity.Status;
import elte.alkfejlbead.webshop.entity.User;
import elte.alkfejlbead.webshop.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/status")
public class StatusController {

    private StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @Role(User.Role.ADMIN)
    @PostMapping("/orderstatus")
    public void changeOrderStatus(HttpServletRequest request, @RequestBody  Status status) {
        statusService.changeOrderStatus(status);
    }

    @Role(User.Role.ADMIN)
    @PostMapping("/shippingstatus")
    public void changeShippingStatus(HttpServletRequest request, @RequestBody  Status status) {
        statusService.changeShippingStatus(status);
    }
}
