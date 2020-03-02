package main.java.com.github.sirlacky.WekaAI;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

import java.io.File;

/**
 * Method removes attribute form data set and can perform attribute modification
 */
public class AttributeFiler {
    public static void attributeFilter(String[]parameters) {

        //Load dataset
        try {
            DataSource source = new DataSource("C:\\Users\\lukasz.koziara\\Desktop\\Moje\\Projekty IntelliJ\\WekaAI\\src\\main\\resources\\weather.arff");
            Instances dataset = source.getDataSet();

            //Use filter to remove a certain attribute
            String[] opts = parameters; //opts is table storing parameters to remove (commend/position);
            Remove remove = new Remove();
            remove.setOptions(opts); //pass parameters
            remove.setInputFormat(dataset); //pass dataset
            Instances newDataSet = Filter.useFilter(dataset, remove); //execute removal/create new dataset

            //Saving new dataset
            ArffSaver saver = new ArffSaver();
            saver.setInstances(newDataSet);
            saver.setFile(new File("C:\\Users\\lukasz.koziara\\Desktop\\Moje\\Projekty IntelliJ\\WekaAI\\src\\main\\resources\\weather2.arff"));
            saver.writeBatch();

        } catch (Exception e) {
            System.out.println("Attribute Filter error");
        }


    }
}
