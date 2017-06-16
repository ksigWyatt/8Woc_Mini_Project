import static java.lang.Math.*;

public class ErrorCalc
	{
		public static void main (String[] args)
		{
			double[] actual = { 2.3, 3.4 , 4.5, 5.6, 6.7, 7.8, 8.9 };
			double[] test = { 3, 3.4 , 4.5, 100, 6.7, 7.8, 9 };
			int i;
			double sum = 0;
                        double adder;
			//add difference squared
			for (i = 0; i < actual.length; i ++)
			{
				
				adder = pow(actual[i]-test[i], 2);
				sum = sum + adder;
			}
			//sqrt sum
			double difference = sqrt(sum);
			System.out.println(actual.length + "is length of actual values");
			//255^2 * 100 is max difference
			//divide distance by max difference
			
			System.out.println("Resulting difference is " + difference);
		}
		
		//TO_DO: pass in hashmap for training set rather than int array, then have it return a character
		public double calculateConfidence(int[] traingSet, int[] imageSet){
			public static final MAX_RANGE = 2550; //sqrt(100 * pow(255, 2))
			int sum = 0; 
			//create for loop that iterates through each element in a hasmap 
			for(int index = 0; index < trainingSet.length; index++){  //for loop for iterating through each element in the training set hash map
				//calculate variable range
				for(int imgIndex = 0; imgIndex < imageSet.length; imgIndex++){
					adder = pow(trainingSet[imgIndex] - imageSet[imgIndex]); //WILL CHANGE
					sum = sum + adder;
			}
		}
	}