package elte.alkfejlbead.webshop.controller;

import elte.alkfejlbead.webshop.annotation.Role;
import elte.alkfejlbead.webshop.entity.Developer;
import elte.alkfejlbead.webshop.entity.User;
import elte.alkfejlbead.webshop.model.api.request.ListDTO;
import elte.alkfejlbead.webshop.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/developers")
@CrossOrigin("*")
public class DeveloperController {

    private DeveloperService developerService;

    @Autowired
    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @Role(User.Role.ADMIN)
    @PostMapping("")
    public Developer addDeveloper(HttpServletRequest request, @RequestBody Developer developer) {
        return developerService.addNewDeveloper(developer);
    }

    @Role(User.Role.ADMIN)
    @GetMapping("")
    public ListDTO<Developer> getDevelopers(HttpServletRequest request) {
        return developerService.getDevelopers();
    }

    @Role(User.Role.ADMIN)
    @DeleteMapping("/{developerId}")
    public void deleteDeveloper(HttpServletRequest request, @PathVariable int developerId) {
        developerService.deleteDeveloper(developerId);
    }

    @Role(User.Role.ADMIN)
    @PatchMapping("/update")
    public void updateDeveloper(HttpServletRequest request, @RequestBody Developer developer) {
        developerService.updateDeveloper(developer);
    }
}
