package weka;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import weka.filters.Filter;
import weka.filters.supervised.instance.StratifiedRemoveFolds;
import weka.filters.unsupervised.attribute.Remove;
 
public class Tree {
	Instances data;
	 Evaluation eval;
	
	public Tree() throws Exception {
	 DataSource source = new DataSource("/usr/users2/2015/up201504779/eclipse-workspace/IART/src/class_especie.arff");
	  data = source.getDataSet();

	 
	
	 // Set class to last attribute
	 if (data.classIndex() == -1)
	     data.setClassIndex(data.numAttributes() - 1);

	 // use StratifiedRemoveFolds to randomly split the data  
	 StratifiedRemoveFolds filter = new StratifiedRemoveFolds();

	 // set options for creating the subset of data
	 String[] options = new String[6];

	 options[0] = "-N";                 // indicate we want to set the number of folds                       
	 options[1] = Integer.toString(5);  // split the data into five random folds
	 options[2] = "-F";                 // indicate we want to select a specific fold
	 options[3] = Integer.toString(1);  // select the first fold
	 options[4] = "-S";                 // indicate we want to set the random seed
	 options[5] = Integer.toString(1);  // set the random seed to 1

	 filter.setOptions(options);        // set the filter options
	 filter.setInputFormat(data);       // prepare the filter for the data format    
	 filter.setInvertSelection(false);  // do not invert the selection

	 
	 
	 // apply filter for test data here
	 Instances test = Filter.useFilter(data, filter);

	 //  prepare and apply filter for training data here
	 filter.setInvertSelection(true); 
	 Instances train = Filter.useFilter(data, filter);
	 // invert the selection to get other data 
	 Classifier cls = new J48();
	 cls.buildClassifier(train);
	 // evaluate classifier and print some statistics
	 eval = new Evaluation(train);
	 
	 eval.evaluateModel(cls, test);
	
	
	// System.out.println(cls.toString());
	
  }
	
	public String getResults() throws Exception {
		String temp="";
		 temp+=data.toSummaryString();
		 temp+='\n';
		 temp+=eval.toSummaryString("\nResults\n======\n", false);
		 temp+='\n';
		 temp+=eval.toMatrixString("\nMatrix\n======\n");
		 temp+='\n';
		 temp+=eval.toClassDetailsString("\nClass Details\n======\n");
		 temp+='\n';
		 System.out.println(temp);
		 return temp; 
	}
	
	public static void main(String [] args) throws Exception {
		Tree t = new Tree();
		t.getResults();
	}
}