package com.sondage.sondage.site;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
    List<Site> findAll();


    @Query("select a from Site a where a.id = ?1")
    public Site findSiteById(Long id);


}