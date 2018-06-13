package football.service;

import football.model.TeamFootball;

public interface TeamFootballService {
    Iterable<TeamFootball> findAll();

    TeamFootball findById(Long id);

    void save(TeamFootball teamFootball);

    void remove(Long id);
}
