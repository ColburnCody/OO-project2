package model.statePattern;

import model.Bullet;

public class BulletStateExplosion implements BulletState {

    public BulletStateExplosion(){

    }

    @Override
    public void goNext(Bullet context) {
        context.setState(new BulletStateDone());

    }
    
}
