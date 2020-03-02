package main.java.com.github.sirlacky.WekaAI;

import weka.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

import static main.java.com.github.sirlacky.WekaAI.AttributeFiler.attributeFilter;
import static main.java.com.github.sirlacky.WekaAI.LoadSaveData.loadSavedData;

public class Main {
    public static void main(String[] args) throws Exception {

        //loadSavedData();

        attributeFilter(new String[]{"-R", "2"});
    }
}
