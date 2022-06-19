package com.company;

import java.util.Random;

public class Coin {
    private Face face;
    private Random rand;

    public Coin(Face face){
        setFace(face);
    }

    public Face getFace(){
        return this.face;
    }

    public void setFace(Face face){
        this.face = face;
    }

    public void flip(){
        rand = new Random();
        int number = rand.nextInt(2);

        if(number == 0) face = Face.HEAD;
        else if(number == 1) face = Face.TAIL;
    }

    public boolean isHeads(){
        return getFace() == face.HEAD;
    }

    public String toString(){
        return face.toString();
    }
}
