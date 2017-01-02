package cn.sorato.exp7.info;

import java.util.HashMap;
import java.util.Optional;

/**
 * Created by kongren on 2016/11/15.
 */
public class Student implements ISerializable{
    private String name;
    private HashMap<String, ScoreInfo> scoreInfoMap = new HashMap<>();

    public Student(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setScoreInfo(String courseName, ScoreInfo info){
        scoreInfoMap.put(courseName,info);
    }

    public Optional<ScoreInfo> getScoreInfo(String courseName){
        return Optional.ofNullable(scoreInfoMap.get(courseName));
    }

    public boolean hasScoreInfo(String courseName){
        return scoreInfoMap.containsKey(courseName);
    }

    public void removeScoreInfo(String courseName){
        scoreInfoMap.remove(courseName);
    }
}
