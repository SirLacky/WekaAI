package main.java.com.github.sirlacky.WekaAI;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.NonSparseToSparse;
import weka.core.converters.ConverterUtils.DataSource;

import java.io.File;

/**
 * Sparse converter converts large files filled mostly with zeros to smaller files without zeros:
 *
 * Before: File1:   1,   2,   3, 0, 0, 0, 0, 0, 9;
 * After:  File2: 0 1, 1 2, 2 3,              8 9; (index, value)
 *
 */
public class SparseConverter {
    public static void sparseConverter(){
        try{
            //Load old dataset
            DataSource source = new DataSource("C:\\Users\\lukasz.koziara\\Desktop\\Moje\\Projekty IntelliJ\\WekaAI\\src\\main\\resources\\weather.arff");
            Instances dataset = source.getDataSet();

            NonSparseToSparse sp = new NonSparseToSparse();
            sp.setInputFormat(dataset);
            Instances newData = Filter.useFilter(dataset,sp);

            //Saving new dataset
            ArffSaver saver = new ArffSaver();
            saver.setInstances(newData);
            saver.setFile(new File("C:\\Users\\lukasz.koziara\\Desktop\\Moje\\Projekty IntelliJ\\WekaAI\\src\\main\\resources\\weather2.arff"));
            saver.writeBatch();

        }catch(Exception e){
            System.out.println("Sparse Converter Exception");
        }
    }
}
