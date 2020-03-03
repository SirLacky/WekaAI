package main.java.com.github.sirlacky.WekaAI;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import java.io.File;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Discretize;

public class DiscretizeAttribute {
    public static void discretizeAttribute() {

        try{
            //Load Dataset
            DataSource source = new DataSource("C:\\Users\\lukasz.koziara\\Desktop\\Moje\\Projekty IntelliJ\\WekaAI\\src\\main\\resources\\weather.arff");
            Instances dataset = source.getDataSet();

            //Set Options
            String [] options = new String[4]; //Create array for every needed command to execute.
            options[0] = "-B";
            options[1] = "2";
            options[2] = "-R";
            options[3] = "0";

            //Applay given comments to discretization.
            Discretize discretize = new Discretize();
            discretize.setOptions(options);
            discretize.setInputFormat(dataset);
            Instances newDataSet = Filter.useFilter(dataset, discretize);

            //Saving new dataset
            ArffSaver saver = new ArffSaver();
            saver.setInstances(newDataSet);
            saver.setFile(new File("C:\\Users\\lukasz.koziara\\Desktop\\Moje\\Projekty IntelliJ\\WekaAI\\src\\main\\resources\\weather2.arff"));
            saver.writeBatch();

        }catch(Exception e){
            System.out.println("DiscretizeAttribute class error");
        }
    }




}
