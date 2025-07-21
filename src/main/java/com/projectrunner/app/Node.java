package com.projectrunner.app;

import java.util.function.Function;

public class Node {

    private final String name;
    private final Function<String,String> action;

    public Node(String name,Function<String,String> action){
        this.name = name;
        this.action = action;
    }

    public String getName(){
        return name;
    }

    public String run(String context){
        return action.apply(context);
    }
}
