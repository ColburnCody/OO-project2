package model.statePattern;

import model.Bullet;

public interface BulletState {
    void goNext(Bullet context);
}
