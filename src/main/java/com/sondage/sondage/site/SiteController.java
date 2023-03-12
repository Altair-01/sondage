package com.sondage.sondage.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/site")

public class SiteController {
    private final SiteService siteService;

    @Autowired
    public SiteController(SiteService siteService) {
        this.siteService = siteService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Site> getSites() {
        return siteService.getSites();
    }

    @GetMapping("/id/{siteId}")
    @ResponseStatus(HttpStatus.OK)
    public Site getSiteById(@PathVariable("siteId") Long siteId){
        return siteService.getSiteById(siteId);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void addSite(@RequestBody Site site){
        siteService.addSite(site);
    }
    @DeleteMapping("/delete/{siteId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSite(@PathVariable ("siteId") Long siteId){
        siteService.deleteSite(siteId);
    }
    @PutMapping("/update/{siteId}")
    @ResponseStatus(HttpStatus.OK)
    public void put(@PathVariable ("siteId") Long siteId,
                    //Il faut mettre le name carrement en plain text
                    @RequestBody(required = true) String name){
        siteService.updateSite(siteId,name);
    }

}
