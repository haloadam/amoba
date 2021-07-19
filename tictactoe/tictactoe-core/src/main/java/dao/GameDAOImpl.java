package dao;

import tictactoe.model.Game;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GameDAOImpl implements GameDAO {

    private static final String SELECT_ALL_GAMES = "SELECT * FROM GAME";
    private static final String INSERT_GAME = "INSERT INTO GAME (player1, player2, size, matchTime, roundTime, positionO, positionX) VALUES (?,?,?,?,?,?,?)";
    private static final String DELETE_GAME = "DELETE FROM GAME WHERE id = ?";
    private static final String GET_GAME = "SELECT FROM GAME WHERE id = ?";
    private Properties props = new Properties();
    private String connectionURL;

    public GameDAOImpl() {
        try {
            Class.forName("org.sqlite.JDBC");
            props.load(getClass().getResourceAsStream("/application.properties"));
            connectionURL = props.getProperty("db.url");
            System.out.println(connectionURL);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Game> findAll() {

        List<Game> result = new ArrayList<>();

        try (Connection c = DriverManager.getConnection(connectionURL);
             Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_GAMES)
        ) {
            while (rs.next()) {
                Game game = new Game();
                game.setId(rs.getInt("id"));
                game.setPlayer1(rs.getString("player1"));
                game.setPlayer2(rs.getString("player2"));
                game.setSize(rs.getInt("size"));
                game.setMatchTime(rs.getInt("matchTime"));
                game.setRoundTime(rs.getInt("roundTime"));
                game.setPositionO(rs.getString("positionO"));
                game.setPositionX(rs.getString("positionX"));

                result.add(game);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public Game save(Game game) {

        try (Connection c = DriverManager.getConnection(connectionURL)) {
            PreparedStatement stmt;
            stmt = c.prepareStatement(INSERT_GAME, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, game.getPlayer1());
            stmt.setString(2, game.getPlayer2());
            stmt.setInt(3, game.getSize());
            stmt.setInt(4, game.getMatchTime());
            stmt.setInt(5, game.getRoundTime());
            stmt.setString(6, game.getPositionO());
            stmt.setString(7, game.getPositionX());
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return game;
    }

    @Override
    public void delete(Game game) {
        try (Connection c = DriverManager.getConnection(connectionURL);
             PreparedStatement stmt = c.prepareStatement(DELETE_GAME);
        ) {
            stmt.setInt(1, game.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getGame(Game game) {
        try (Connection c = DriverManager.getConnection(connectionURL);
             PreparedStatement stmt = c.prepareStatement(GET_GAME);
        ) {
            stmt.setInt(1, game.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
