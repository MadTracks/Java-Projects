public class SpiralIterator {
    public SpiralIterator(int row,int column,int[][] array){
        boolarray=new boolean[row][column];
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                boolarray[i][j]=false;
            }
        }
        maxrow=row;
        maxcolumn=column;
        itarray=array;
    }
    public boolean hasNext(int row, int column){
        if(column<maxcolumn-1 && !boolarray[row][column+1]){
            return true;
        }
        else if(row<maxrow-1 && !boolarray[row+1][column]){
            return true;
        }
        else if(column>0 && !boolarray[row][column-1]){
            return true;
        }
        else if(row>0 && !boolarray[row-1][column]){
            return true;
        }
        return false;
    }
    public int next(int row,int column){
        System.out.printf("%d ",itarray[row][column]);
        boolarray[row][column]=true;
        if(!hasNext(row,column)){
            return 1;
        }
        else if(column<maxcolumn-1 && !boolarray[row][column+1]){
            if(row>0 && !boolarray[row-1][column]){
                next(row-1,column);
            }
            else {
                next(row, column + 1);
            }
        }
        else if(row<maxrow-1 && !boolarray[row+1][column]){
            next(row+1,column);
        }
        else if(column>0 && !boolarray[row][column-1]){
            next(row,column-1);
        }
        else if(row>0 && !boolarray[row-1][column]){
            next(row-1,column);
        }
        return 0;
    }
    private boolean[][] boolarray;
    private int maxcolumn;
    private int maxrow;
    private int[][] itarray;
}
