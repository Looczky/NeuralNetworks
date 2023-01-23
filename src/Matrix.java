import java.util.ArrayList;
import java.util.List;

public class Matrix{
    double[][] values;
    int rows, columns;

    Matrix(int rows, int columns){
        values = new double[rows][columns];
        this.rows = rows;
        this.columns = columns;

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                values[i][j] = (Math.random()*2)-1;
            }
        }
    }

    void add(Matrix X){
        if(columns != X.columns || rows != X.rows){
            System.out.println("Cannot add these two matrices.");
        }
        else{
            for(int i=0; i<rows; i++){
                for(int j=0; j<columns; j++){
                    this.values[i][j] += X.values[i][j];
                }
            }
        }
    }

    void add(double x){
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                this.values[i][j] += x;
            }
        }
    }

    void multiply(double x){
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                this.values[i][j] *= x;
            }
        }
    }

    void multiply(Matrix X){
        for(int i=0; i<X.rows; i++){
            for(int j=0; j<X.columns; j++){
                this.values[i][j] *= X.values[i][j];
            }
        }
    }

    static Matrix multiply(Matrix X, Matrix Y){
        Matrix Z = new Matrix(X.rows, Y.columns);
        for(int i=0; i<Z.rows; i++){
            for(int j=0; j<Z.columns; j++){
                double sum = 0;
                for(int k=0; k<X.columns; k++){
                    sum += X.values[i][k] * Y.values[k][j];
                }
                Z.values[i][j] = sum;
            }
        }
        return Z;
    }

    static Matrix subtract(Matrix X, Matrix Y) {
        Matrix Z = new Matrix(X.rows, X.columns);
        for (int i = 0; i < X.rows; i++) {
            for (int j = 0; j < X.columns; j++) {
                Z.values[i][j] = X.values[i][j] - Y.values[i][j];
            }
        }
        return Z;
    }

    static Matrix transpose(Matrix X){
        Matrix Z  = new Matrix(X.columns, X.rows);
        for (int i = 0; i < X.rows; i++) {
            for (int j = 0; j < X.columns; j++) {
                Z.values[j][i] = X.values[i][j];
            }
        }
        return Z;
    }

    void display(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++){
                System.out.print(values[i][j]+"  ");
            }
            System.out.println();
        }
    }
    
    
    void softplus() {
 	   for(int i = 0; i < rows; i++) {
 		   for (int j = 0; j < columns; j++) {
 			   this.values[i][j] = Math.log(1 + Math.exp(this.values[i][j]));
 			   
 		   }
 	   }
    }
    
    Matrix dsoftplus() {
 	   Matrix X = new Matrix(rows, columns);
 	   for (int i = 0; i < rows; i++) {
 		   for (int j = 0; j < columns; j++) {
 			   X.values[i][j] =1/(1 + Math.exp(-this.values[i][j]));
 		   }
 	   }
 	   return X;
    }
    
    void sigmoid() {
 	   for(int i = 0; i < rows; i++) {
 		   for (int j = 0; j < columns; j++) {
 			   this.values[i][j] = 1 / (1 + Math.exp(-this.values[i][j]));
 			
 		   }
 	   }
    }

    Matrix dsigmoid() {
 	   Matrix X = new Matrix(rows, columns);
 	   for (int i = 0; i < rows; i++) {
 		   for (int j = 0; j < columns; j++) {
 			   X.values[i][j] = (1 / (1 + Math.exp(-this.values[i][j]))) * (1 - 1 / (1 + Math.exp(-this.values[i][j])));
 		   }
 	   }
 	   return X;
    }
    

 	static Matrix fromArray(double[] x)
 	{
 		Matrix X = new Matrix(x.length,1);
 		for(int i =0;i<x.length;i++)
 			X.values[i][0]=x[i];
 		return X;
 		
 	}
 	
 	List<Double> toArray() {
 		List<Double> X = new ArrayList<Double>();
 		
 		for(int i = 0; i < rows; i++)
 		{
 			for(int j = 0; j < columns; j++)
 			{
 				X.add(values[i][j]);
 			}
 		}
 		return X;
 	}
}
