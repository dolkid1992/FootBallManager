package football.service.impl;

import football.model.Player;
import football.repository.PlayerRepository;
import football.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Iterable<Player> findAll(){
        return playerRepository.findAll();
    }

    @Override
    public Player findById(Long id) {
        return playerRepository.findOne(id);
    }

    @Override
    public void save(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void remove(Long id) {
        playerRepository.delete(id);
    }
}
