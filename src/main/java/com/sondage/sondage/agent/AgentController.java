package com.sondage.sondage.agent;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agent")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Agent> getAgent() {
        return  agentService.getAgents();
    }

    @GetMapping("/id/{agentId}")
    @ResponseStatus(HttpStatus.OK)
    public Agent findAgentById(@PathVariable Long agentId){
        return agentService.getAgentById(agentId);
    }

    @GetMapping("/findSite/{siteId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Agent> getAgentBySite(@PathVariable Long siteId) {
        return  agentService.getAgentsBySite(siteId);
    }

    @PostMapping("/{siteId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Agent addAgent(@PathVariable Long siteId, @RequestBody Agent agent) {
        return agentService.addAgent(siteId, agent);
    }

    @DeleteMapping("/delete/{agentId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSite(@PathVariable("agentId") Long agentId){
        agentService.deleteAgent(agentId);
    }

    //Modify agent name
    @PutMapping("/update/name/{agentId}")
    @ResponseStatus(HttpStatus.OK)
    public void put(@PathVariable ("agentId") Long agentId,
                    //Il faut mettre le name carrement en plain text
                    @RequestBody(required = true) String fullName){
        agentService.updateAgent(agentId,fullName);
    }


}
