package cn.sorato.exp2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by kongren on 2016/12/14.
 */
public class GuessGameTest{
    GuessGame game;

    @Before
    public void setup() throws Exception{
        game = new GuessGame(0, 128);
    }

    @Test
    public void guess() throws Exception{
        Random rnd = new Random();
        game.guess(rnd.nextInt() + game.max);
        game.guess(game.max - rnd.nextInt());

        Field v = GuessGame.class.getDeclaredField("value");
        v.setAccessible(true);
        Assert.assertTrue(game.guess(v.getInt(game)));
    }

}