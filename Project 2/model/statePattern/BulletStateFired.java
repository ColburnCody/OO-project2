package model.statePattern;

import model.Bullet;

public class BulletStateFired implements BulletState {

    public BulletStateFired(){

    }

    @Override
    public void goNext(Bullet context) {
        context.setState(new BulletStateExplosion());
    }
    
}
