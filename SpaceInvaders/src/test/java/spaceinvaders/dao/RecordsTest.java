/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kxkivi
 */
public class RecordsTest {

    Records test;

    @Before
    public void setUp() {
        
        try {
            File added = new File("testscores.csv");
            try (PrintWriter write = new PrintWriter(added)) {
                write.println("one,100");
                write.println("two,90");
                write.println("three,80");
                write.println("4,100");
                write.println("5,100");
                write.println("6,100");
                write.println("7,100");
                write.println("8,100");
                write.println("9,100");
                write.println("10,100");
            }
        } catch (FileNotFoundException ex1) {
            Logger.getLogger(Records.class.getName()).log(Level.SEVERE, null, ex1);
        }
        this.test = new Records("testscores.csv");

    }

    @After
    public void tearDown() {

        try {

            PrintWriter write = new PrintWriter("testscores.csv");
            write.println("one,100");
            write.println("two,90");
            write.println("three,80");
            write.println("4,100");
            write.println("5,100");
            write.println("6,100");
            write.println("7,100");
            write.println("8,100");
            write.println("9,100");
            write.println("10,100");
            write.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RecordsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Test
    public void getScoresWorks() {
        ArrayList other = test.getHighScores();
        test.addScore(new Player("other", 70));
        test.addScore(new Player("another", 50));

        assertEquals(other, test.getHighScores());
    }

    @Test
    public void addScoreWorks() {
        Player best = new Player("best", 1000);
        test.addScore(best);
        assertEquals(best.toSave(), test.getHighScores().get(0).toSave());
    }

    @Test
    public void trimScoreWorks() {
        ArrayList<Player> testList = test.getHighScores();

        testList.add(new Player("best", 1000));
        test.trim(testList);
        testList.add(new Player("worst", 50));
        test.trim(testList);
        test.trim(testList);

        assertEquals("best", testList.get(0).getName());
        assertEquals(testList.size(), 10);

    }

}
