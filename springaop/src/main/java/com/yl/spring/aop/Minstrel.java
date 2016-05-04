package com.yl.spring.aop;

import java.io.PrintStream;

/**
 * Created by yanlong on 2016/5/5.
 */
public class Minstrel {
    private PrintStream stream;

    public Minstrel(PrintStream stream) {
        this.stream = stream;
    }

    public void singBeforeQuest(){
        stream.println("Fa la la, the knight is so brave");
    }

    public void singAfterQuest(){
        stream.println("Tee hee hee, the brave knight did embark on a quest");
    }
}
