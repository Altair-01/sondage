package com.sondage.sondage.agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
    List<Agent> findBySite(Long id);
    List<Agent> findAll();
    Agent findAgentById(Long id);

}