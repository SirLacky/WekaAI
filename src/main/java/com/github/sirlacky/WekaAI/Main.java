package main.java.com.github.sirlacky.WekaAI;

import weka.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

import static main.java.com.github.sirlacky.WekaAI.AttInst.attributeInst;
import static main.java.com.github.sirlacky.WekaAI.AttrSelection.attrSelection;
import static main.java.com.github.sirlacky.WekaAI.CSV2ArffConverter.CSV2ArffConverter;
import static main.java.com.github.sirlacky.WekaAI.AttributeFiler.attributeFilter;
import static main.java.com.github.sirlacky.WekaAI.DiscretizeAttribute.discretizeAttribute;
import static main.java.com.github.sirlacky.WekaAI.LoadSaveData.loadSavedData;
import static main.java.com.github.sirlacky.WekaAI.SparseConverter.sparseConverter;

public class Main {
    public static void main(String[] args) throws Exception {

        //loadSavedData();

        //CSV2ArffConverter();

        //attributeFilter(new String[]{"-R", "2"});

        //sparseConverter();

        //discretizeAttribute();

        //attrSelection();

        attributeInst();
    }
}
