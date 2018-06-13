package football.service.impl;

import football.model.TeamFootball;
import football.repository.TeamFootBallRepository;
import football.service.TeamFootballService;
import org.springframework.beans.factory.annotation.Autowired;

public class TeamFootBallServiceImpl implements TeamFootballService {

    @Autowired
    private TeamFootBallRepository teamFootBallRepository;

    @Override
    public Iterable<TeamFootball> findAll() {
        return teamFootBallRepository.findAll();
    }

    @Override
    public TeamFootball findById(Long id) {
        return teamFootBallRepository.findOne(id);
    }

    @Override
    public void save(TeamFootball teamFootball) {
        teamFootBallRepository.save(teamFootball);
    }

    @Override
    public void remove(Long id) {
        teamFootBallRepository.delete(id);
    }
}
