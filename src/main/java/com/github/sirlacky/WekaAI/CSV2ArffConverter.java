package main.java.com.github.sirlacky.WekaAI;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

import java.io.File;

public class CSV2ArffConverter {

    public static void CSV2ArffConverter() {
        try {
            CSVLoader loader = new CSVLoader();
            loader.setSource(new File(""));
            Instances data = loader.getDataSet();

            ArffSaver saver = new ArffSaver();
            saver.setInstances(data);
            saver.setFile(new File("C:\\Users\\lukasz.koziara\\Desktop\\Moje\\Projekty IntelliJ\\WekaAI\\src\\main\\resources\\weather2.arff"));
            saver.writeBatch();

        } catch (Exception e) {

        }
    }
}
