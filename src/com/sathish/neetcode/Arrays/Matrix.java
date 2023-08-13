package com.sathish.neetcode.Arrays;

import java.util.*;
import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        int a[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        Matrix m = new Matrix();
//        m.matrixSnakeTraversal(a);
//        m.matrixBoundaryTraversal(a);
//        m.printMatrix(a);
//       System.out.println(" ");
//        m.printMatrix(m.matrixTranspose(a));
//        System.out.println(m.isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}}));


//                new char[][]{
//                {'.','.','.','.','5','.','.','1','.'},{'.','4','.','3','.','.','.','.','.'},{'.','.','.','.','.','3','.','.','1'}
//                ,{'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'}
//                ,{'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}}));

    }
    public void printMatrix(int a[][]){
        for (int[] ints : a) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + " ");
            }
        }
    }
    public void matrixSnakeTraversal(int a[][]){
        for(int i =0 ;i< a.length;i++){
            for (int j =0;j<a[i].length;j++){
                if((i+1)%2==0) {
                    System.out.print(a[i][a[i].length - j - 1]+" ");
                }
                else{
                    System.out.print(a[i][j]+" ");
                }
            }
        }
    }

    public void matrixBoundaryTraversal(int a[][]){
        for(int i =0;i<a.length;i++){
            System.out.print(a[0][i]+" ");
        }
        for(int i =1;i<a.length;i++){
            System.out.print(a[i][a.length-1]+" ");
        }
        for(int i = a.length-2;i>=0;i--){
            System.out.print(a[a.length-1][i]+" ");
        }
        for(int i = a.length-2;i>=0;i--){
            System.out.print(a[i][0]+" ");
        }


    }

    public int[][] matrixTranspose(int a[][]){
        for(int i =0;i<a.length;i++){
            for(int j =i;j<a[i].length;j++){
                int temp;
                temp = a[j][i];
                a[j][i] = a[i][j];
                a[i][j]=temp;
            }
        }
        return a;
    }
    public Boolean isValidSudoku(char board[][]){
        Map<String, HashSet<Character>> checkSet = new HashMap<>();
        for(int i = 0;i<board.length;i++){
            Map<Character,String> rowCheckSet = new HashMap<>();
            Map<Character,String> columnCheckSet = new HashMap<>();

            for(int j=0;j<board[i].length;j++) {

                if (board.length != board[i].length) {
                    return false;
                }
                if(board[i][j]!='.'){
                    if(rowCheckSet.containsKey(board[i][j])){
                        return false;
                    }
                    rowCheckSet.put(board[i][j],".");
                    String str = String.valueOf(i/3)+ j / 3;
                    checkSet.putIfAbsent(str,new HashSet<>());
                    if(!checkSet.get(str).add(board[i][j])){
                        return false;
                    }
                }
                if(board[j][i]!='.'){
                    if(columnCheckSet.containsKey(board[j][i])){
                        return false;
                    }
                    columnCheckSet.put(board[j][i],".");
                }

            }

        }
        return true;
    }


}
