package com.aor.crossyroad.model.game.lines;

import com.aor.crossyroad.model.game.elements.Tree;
import com.aor.crossyroad.model.game.lines.Line;

import java.util.ArrayList;
import java.util.List;

public class Sidewalk extends Line {
    private List<Tree> trees;

    public Sidewalk(int y) {
        super(y, 'S');
    }

    public void randomizeTrees() {
        trees = new ArrayList<>();
        trees.add(new Tree(15,15));
    }

    public List<Tree> getTrees() {
        randomizeTrees();
        return trees;
    }
}
