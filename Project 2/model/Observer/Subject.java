package model.Observer;

import model.Shooter;

public interface Subject {
    void addShooterListener(Observer o);
    void removeShooterListener(Observer o);
    void notifyObservers(Shooter.Event event);
}
