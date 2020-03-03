package main.java.com.github.sirlacky.WekaAI;

import weka.attributeSelection.CfsSubsetEval;
import weka.attributeSelection.GreedyStepwise;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.filters.Filter;
import weka.filters.supervised.attribute.AttributeSelection;
import java.io.File;
import weka.core.converters.ConverterUtils.DataSource;

public class AttrSelection {
    public static void attrSelection(){

         /**
         * Class which is removing not relevant data from given data set.
         */

        try{
            //Load dataset
            DataSource source = new DataSource("C:\\Users\\lukasz.koziara\\Desktop\\Moje\\Projekty IntelliJ\\WekaAI\\src\\main\\resources\\weather.arff");
            Instances dataset = source.getDataSet();

            //Create object that we need
            AttributeSelection filter = new AttributeSelection();
            CfsSubsetEval eval = new CfsSubsetEval(); //evaluation object
            GreedyStepwise search = new GreedyStepwise(); //searching object

            search.setSearchBackwards(true);
            filter.setEvaluator(eval);
            filter.setSearch(search);
            filter.setInputFormat(dataset);
            Instances newDataSet = Filter.useFilter(dataset,filter);

            //Saving new dataset
            ArffSaver saver = new ArffSaver();
            saver.setInstances(newDataSet);
            saver.setFile(new File("C:\\Users\\lukasz.koziara\\Desktop\\Moje\\Projekty IntelliJ\\WekaAI\\src\\main\\resources\\weather2.arff"));
            saver.writeBatch();



        }catch (Exception e){
            System.out.println("AttrSelection class error");
        }

    }
}
