package com.positive;

public class Main {

    public static void main(String[] args) throws Exception {
        new Main().findAllMatchesIndexes("some text that makes me t", " t");
    }

    public void findAllMatchesIndexes(String url, String query){
        int lookUpIndex = 0;
        while ((lookUpIndex = url.indexOf(query, lookUpIndex)) != -1){
            System.out.println(lookUpIndex);
            lookUpIndex ++;
        }
    }

}
