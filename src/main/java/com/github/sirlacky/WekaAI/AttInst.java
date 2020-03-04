package main.java.com.github.sirlacky.WekaAI;

import weka.core.converters.ArffSaver;
import weka.experiment.Stats;
import weka.core.AttributeStats;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import java.io.File;

public class AttInst {
    public static void attributeInst() {
        try {
            //Load dataset
            DataSource source = new DataSource("C:\\Users\\lukasz.koziara\\Desktop\\Moje\\Projekty IntelliJ\\WekaAI\\src\\main\\resources\\weather.arff");
            Instances dataset = source.getDataSet();

            //Set choosen class index as last attribute
            if (dataset.classIndex() == -1) {
                dataset.setClassIndex((dataset.numAttributes() - 1));
            }

            //Get number of attributes (notice class is not counted)
            int numAttr = dataset.numAttributes() - 1;

            for (int i = 0; i < numAttr; i++) {
                //Check if current attribute is nominal
                if (dataset.attribute(i).isNominal()) {
                    System.out.println("The " + i + "th Attribute is Nominal");
                    //Get number of values
                    int n = dataset.attribute(i).numValues();
                    System.out.println("The " + i + "th Attribute has " + n + " values");
                }
                //Get an AttributeStats object
                AttributeStats as = dataset.attributeStats(i);
                int dC = as.distinctCount;
                System.out.println("The " + i + "th Attribute has: " + dC + " distinct values");

                //Get a Stats object from AttributeStats
                if (dataset.attribute(i).isNumeric()) {
                    System.out.println("The " + i + "th Attribute is Numberic");
                    Stats s = as.numericStats;
                    System.out.println("The " + i + "th Attribute has min value: " + s.min + " and max value: " + s.max);
                }
            }

            //Get number of instances
            int numinst = dataset.numInstances();

            //Loop through all instances
            for (int i = 0; i < numinst; i++) {
                Instance instance = dataset.instance(i);
                //Check if attribiute is missing from the i'th instance
                if (instance.isMissing(0)) {
                    System.out.println("The " + 0 + "th Attribute is missing");
                }
                if (instance.classIsMissing()) {
                    System.out.println("The class is missing in the " + "th Instance");
                }
                //if you want to access the value of Class in your data
                //notice classes of type nominal and string are given ID's
                double cV = instance.classValue();
                System.out.println(instance.classAttribute().value((int) cV));
            }

        } catch (Exception e) {
            System.out.println("AttrInst class error");
        }


    }
}
