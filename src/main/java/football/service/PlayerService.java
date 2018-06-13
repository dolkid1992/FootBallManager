package football.service;

import football.model.Player;

public interface PlayerService {
    Iterable<Player> findAll();

    Player findById(Long id);

    void save(Player player);

    void remove(Long id);
}
