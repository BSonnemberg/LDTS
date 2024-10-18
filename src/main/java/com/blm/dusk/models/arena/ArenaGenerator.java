package com.blm.dusk.models.arena;

import com.blm.dusk.models.elements.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ArenaGenerator {
    private List<String> lines;
    public ArenaGenerator(int level, boolean a) throws IOException {

        URL resource = ArenaGenerator.class.getResource("/stages/stage" + level + ".stage");
        BufferedReader br = Files.newBufferedReader(Paths.get(resource.getFile()), UTF_8);

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    public Arena createArena(boolean a) throws IOException{
        Arena arena = new Arena(getWidth(), getHeight(),a);

        arena.setIntruder(createIntruder());
        arena.setGoats(createGoats());
        arena.setBlockslist(createBlocks());
        arena.setTrees(createTrees());
        arena.setKey(createKey());
        arena.setDoor(createDoor());
        arena.setBullet(createBullet());
        arena.setPoints(createPoints());

        return arena;
    }

    protected int getWidth(){
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    };

    protected int getHeight(){
        return lines.size();
    };

    protected List<Block> createBlocks(){
        List<Block> blockList = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') blockList.add(new Block(x, y));
        }

        return blockList;
    };

    protected List<Goat> createGoats(){
        List<Goat> goats = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'G') goats.add(new Goat(x, y));
        }

        return goats;
    };

    protected Intruder createIntruder(){
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'I') return new Intruder(x, y);
        }
        return null;
    };

    protected List<Tree> createTrees(){
        List<Tree> trees = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'T') trees.add(new Tree(x, y));
        }
        return trees;
    }

    protected Key createKey(){
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'K') return new Key(x, y);
        }
        return null;
    }
    protected Door createDoor(){
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'D') return new Door(x, y);
        }
        return null;
    }

    protected List<Bullet> createBullet(){
       return new ArrayList<>();
    }

    protected List<Point> createPoints() {
        List<Point> points = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '.') points.add(new Point(x, y));
        }

        return points;
    }
}
