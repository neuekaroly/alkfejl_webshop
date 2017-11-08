package elte.alkfejlbead.webshop.controller;

import elte.alkfejlbead.webshop.annotation.Role;
import elte.alkfejlbead.webshop.entity.Developer;
import elte.alkfejlbead.webshop.entity.User;
import elte.alkfejlbead.webshop.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/developers")
public class DeveloperController {
    @Autowired
    private DeveloperService developerService;

   // @Role(User.Role.ADMIN)
    @PostMapping("")
    public Developer addDeveloper(@RequestBody Developer developer) {
        return developerService.addNewDeveloper(developer);
    }

    //@Role(User.Role.ADMIN)
    @DeleteMapping("/{developerid}")
    public void deleteDeveloper(@PathVariable int developerId) {
        developerService.deleteDeveloper(developerId);
    }

    @PatchMapping("/update")
    public void updateDeveloper(@RequestBody Developer developer) {
        developerService.updateDeveloper(developer);
    }

    //@PostMapping("/{developerid}/games/{gameid}")

}
