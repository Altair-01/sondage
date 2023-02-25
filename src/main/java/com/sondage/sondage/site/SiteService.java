package com.sondage.sondage.site;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class SiteService {
    @Autowired
    SiteRepository siteRepository;

    public List<Site> getSites(){
        return siteRepository.findAll();
    }

    public Site getSiteById(Long id){
        return siteRepository.findSiteById(id);
    }

    public Site addSite(Site site) {
        return siteRepository.save(site);
    }

    public void deleteSite(Long id) {
        boolean existe = siteRepository.existsById(id);
        if(!existe){
            throw new RuntimeException("Ce site avec cet id: "+id+" ne peut pas être supprimer");
        }
        siteRepository.deleteById(id);
    }

    @Transactional
    public void updateSite(Long id, String name) {
        Site site = siteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Ce site avec id: "+id+" n'existe pas"));
        if (name!= null && name.length() > 0 && !Objects.equals(site.getName(), name)) {
            site.setName(name);
        }
        System.out.println(site.getName());

    }
}
