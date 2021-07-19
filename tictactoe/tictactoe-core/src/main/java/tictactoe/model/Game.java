package tictactoe.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Game {

    private IntegerProperty id = new SimpleIntegerProperty(this,"id");
    private StringProperty player1 = new SimpleStringProperty(this, "player1");
    private StringProperty player2 = new SimpleStringProperty(this, "player2");
    private IntegerProperty size = new SimpleIntegerProperty(this,"size");
    private IntegerProperty matchTime = new SimpleIntegerProperty(this,"matchTime");
    private IntegerProperty roundTime = new SimpleIntegerProperty(this,"roundTime");
    private StringProperty positionO = new SimpleStringProperty(this,"positionO");
    private StringProperty positionX = new SimpleStringProperty(this,"positionX");


    public String getPositionO() {
        return positionO.get();
    }

    public StringProperty positionOProperty() {
        return positionO;
    }

    public void setPositionO(String positionO) {
        this.positionO.set(positionO);
    }

    public String getPositionX() {
        return positionX.get();
    }

    public StringProperty positionXProperty() {
        return positionX;
    }

    public void setPositionX(String positionX) {
        this.positionX.set(positionX);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getPlayer1() {
        return player1.get();
    }

    public StringProperty player1Property() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1.set(player1);
    }

    public String getPlayer2() {
        return player2.get();
    }

    public StringProperty player2Property() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2.set(player2);
    }

    public int getSize() {
        return size.get();
    }

    public IntegerProperty sizeProperty() {
        return size;
    }

    public void setSize(int size) {
        this.size.set(size);
    }

    public int getMatchTime() {
        return matchTime.get();
    }

    public IntegerProperty matchTimeProperty() {
        return matchTime;
    }

    public void setMatchTime(int matchTime) {
        this.matchTime.set(matchTime);
    }

    public int getRoundTime() {
        return roundTime.get();
    }

    public IntegerProperty roundTimeProperty() {
        return roundTime;
    }

    public void setRoundTime(int roundTime) {
        this.roundTime.set(roundTime);
    }


}
