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

    Matrix multiply(Matrix X, Matrix Y){
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

    Matrix subtract(Matrix X, Matrix Y) {
        Matrix Z = new Matrix(X.rows, X.columns);
        for (int i = 0; i < X.rows; i++) {
            for (int j = 0; j < X.columns; j++) {
                Z.values[i][j] = X.values[i][j] - Y.values[i][j];
            }
        }
        return Z;
    }

    Matrix transpose(Matrix X){
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
}