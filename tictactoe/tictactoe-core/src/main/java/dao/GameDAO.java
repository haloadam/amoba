package dao;

import tictactoe.model.Game;

import java.util.List;

public interface GameDAO {
    List<Game> findAll();

    Game save(Game game);

    void delete(Game game);

    void getGame(Game game);

}
