package elte.alkfejlbead.webshop.service;

import elte.alkfejlbead.webshop.entity.Developer;
import elte.alkfejlbead.webshop.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeveloperService {
    private DeveloperRepository developerRepository;

    @Autowired
    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public Developer addNewDeveloper(Developer developer) {
       return developerRepository.save(developer);
    }

    public void deleteDeveloper(int developerId) {
        developerRepository.delete(developerId);
    }

    public void updateDeveloper(Developer developer) {
       Developer updatedDeveloper = developerRepository.findOne(developer.getId());
       updatedDeveloper.setDevelopername(developer.getDevelopername());
       updatedDeveloper.setCountry(developer.getCountry());
       updatedDeveloper.setGames(developer.getGames());
       developerRepository.save(updatedDeveloper);
    }

}
