package model.statePattern;

import model.Bullet;

public class BulletStateDone implements BulletState {

    public BulletStateDone(){

    }

    @Override
    public void goNext(Bullet context) {
        context.setState(null);

    }
    
}
