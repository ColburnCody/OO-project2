package model.strategyPattern;

import model.EnemyComposite;
import view.GameBoard;

public class EnemyMovement implements EnemyMoveStrategy{

    private EnemyComposite enemy;

    public EnemyMovement(EnemyComposite enemy){
        this.enemy = enemy;
    }

    @Override
    public int rightEnd() {
        var rows = enemy.getRows();
        int xEnd = -100;
        for(var row: rows){
            if(row.size() == 0) continue;
            int x = row.get(row.size() - 1).x + EnemyComposite.getEnemySize();
            if(x > xEnd) xEnd = x;
        }
        return xEnd;
    }

    @Override
    public int leftEnd() {
        var rows = enemy.getRows();
        int xEnd = 9000;
        for(var row: rows){
            if(row.size() == 0) continue;
            int x = row.get(0).x;
            if(x < xEnd) xEnd = x;
        }
        return xEnd;
    }

    @Override
    public boolean atBottom() {
        var composite = enemy.getRows();
        for(var c: composite){
            for(var e: c){
                if(e.y == GameBoard.HEIGHT){
                    return true;
                }
            }
        }
        return false;
    }
    
}
