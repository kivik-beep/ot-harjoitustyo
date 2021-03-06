package spaceinvaders.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    int level;
    Spaceship player;
    List<Invader> enemies = new ArrayList<>();
    int enemiesCreated;

    /**
     * Creates new game.
     *
     * @param level defines how many rows of invaders is needed.
     */
    public Game(int level) {
        this.level = level;
    }

    /**
     * Creates set of invaders based on the current level.
     */
    public void createInvaders() {
        for (int a = 0; a < level; a++) {
            int y = 40 + a * 50;
            for (int i = 0; i < 5; i++) {
                Invader enemy = new Invader((460 - i * 50), y);
                this.enemies.add(enemy);
                this.enemiesCreated++;
            }
        }
    }

    /**
     * Creates new invaders and spaceship for the game.
     */
    public void start() {
        createInvaders();
        this.player = new Spaceship(250, 490);
    }

    public Spaceship getPlayer() {
        return this.player;
    }

    public List<Invader> getInvaders() {
        return this.enemies;
    }

    public void setLevel(int t) {
        this.level = this.level + t;
    }

    /**
     * Counts points to show on End scene (and save if in top10).
     *
     * @return the amount of invaders destroyed multiplied by 10
     */
    public int points() {
        int destroyed = enemiesCreated - enemies.size();
        return destroyed * 10;
    }

    public int getLevel() {
        return this.level;
    }

}
