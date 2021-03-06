package main.java.com.github.sirlacky.WekaAI;

import weka.core.Instances;
import weka.core.converters.ArffSaver;

//import weka.core.converters.ConverterUtils.DataSource;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class LoadSaveData {
    public static void loadSavedData() throws  Exception{

        //Load data set from arff file.
        Instances dataset = new Instances(new BufferedReader(new FileReader("C:\\Users\\lukasz.koziara\\Desktop\\Moje\\Projekty IntelliJ\\WekaAI\\src\\main\\resources\\weather.arff")));

        System.out.println(dataset.toSummaryString());

        //Save data set to new file.
        ArffSaver saver = new ArffSaver();
        saver.setInstances(dataset);
        saver.setFile(new File("C:\\Users\\lukasz.koziara\\Desktop\\Moje\\Projekty IntelliJ\\WekaAI\\src\\main\\resources\\report.arff"));
        saver.writeBatch();
    }
}
