package model.Observer;

import view.GameBoard;

public class ShooterObserver implements Observer {

    private GameBoard gameBoard;

    public ShooterObserver(GameBoard gameBoard){
        this.gameBoard = gameBoard;
    }


    @Override
    public void shooterHitEnemy() {
        int score = gameBoard.getScore();
        score += 10;
        gameBoard.setScore(score);
        gameBoard.getScoreDisplay().setText("" + score);
    }

    @Override
    public void enemyHitShooter() {
        // TODO Auto-generated method stub

    }
    
}
