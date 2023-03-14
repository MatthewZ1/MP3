package helperMethod;

import java.util.ArrayList;

public class Utilz {
    public static int[][] ArrayList2Dint(ArrayList<Integer> list, int ySize, int xSize){
        int[][] newArr = new int[ySize][xSize];
        for(int i = 0; i < newArr.length; i++){
            for(int j = 0; j < newArr[0].length; j++){
                int index = i*ySize + j;
                newArr[i][j] = list.get(index);
            }
        }
        return newArr;
    }
    public static int[] twoDto1DIntArr(int[][] twoD){
        int[] oneD = new int[twoD.length * twoD[0].length];
        for(int i = 0; i < twoD.length; i++){
            for(int j = 0; j < twoD[0].length; j++){
                int index = i*twoD.length + j;
                oneD[index] = twoD[i][j];
            }
        }
        return oneD;
    }   
}
