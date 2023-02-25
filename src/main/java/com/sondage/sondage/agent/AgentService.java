package com.sondage.sondage.agent;

import com.sondage.sondage.site.Site;
import com.sondage.sondage.site.SiteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;

@Service
@RequestMapping(path = "agent")
public class AgentService {
    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private SiteRepository siteRepository;

    public Agent getAgentById(Long id) {
        return agentRepository.findById(id).orElse(null);
    }

    public List<Agent> getAgents(){
        return agentRepository.findAll();
    }

    public List<Agent> getAgentsBySite(Long siteID) {
        return  agentRepository.findBySite(siteID);
    }
    public Agent addAgent(Long siteId, Agent agent) {
        Site site = siteRepository.findSiteById(siteId);
        if (site == null) {
            throw new IllegalArgumentException("Site not found");
        }

        agent.setSite(site);
        return agentRepository.save(agent);
    }
    public void deleteAgent(Long id) {
        boolean existe = agentRepository.existsById(id);
        if(!existe){
            throw new RuntimeException("Cet agent avec cet id: "+id+" ne peut pas être supprimer");
        }
        agentRepository.deleteById(id);
    }

    @Transactional
    public void updateAgent(Long id, String fullName) {
        Agent agent = agentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Cet agent avec id: "+id+" n'existe pas"));
        if (fullName!= null && fullName.length() > 0 && !Objects.equals(agent.getFullName(), fullName)) {
            agent.setFullName(fullName);
        }
        System.out.println(agent.getFullName());

    }


}
