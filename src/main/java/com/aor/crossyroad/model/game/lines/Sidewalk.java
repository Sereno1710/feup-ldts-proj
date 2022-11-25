package com.aor.crossyroad.model.game.lines;

import com.aor.crossyroad.model.game.elements.Tree;
import com.aor.crossyroad.model.game.lines.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sidewalk extends Line {
    private List<Tree> trees;

    public Sidewalk(int y) {
        super(y, 'S');
    }

    public void randomizeElements() {
        Random r = new Random();
        int ran=r.nextInt(0,90);
        trees = new ArrayList<>();
        for(int i=1;i<100;i++){
            if(i<ran || i>=ran+10){
                trees.add(new Tree(i,getY()));
            }
        }
    }

    public List<Tree> getTrees() {
        return trees;
    }
}
