package com.sathish.ds.Arrays;



public class Arrays {
    public static void main(String[] args) {
        int[] noArray = {10,20,20,20,30,30};
        //System.out.println(findLargestEleIndexInArr(noArray));
        //deleteEleFromArray(noArray,10);
        //printSecLarEleArrIdx(noArray);
        //checkIfArraySorted(noArray);
        //reverseAnArray(noArray);
        //removeDuplicatesFromSorArr(noArray);
        //removeDuplicatesFromSorArr1(noArray);
        moveZerosToEnd();
    }

    /**
     * //time complexity worst case o(n) and if array is sorted o(1)
     * @param noArray
     * @return
     */
    public static int findLargestEleIndexInArr(int[] noArray){
        int idx =0;
       for(int i=0;i< noArray.length;i++){
           if(noArray[i]>noArray[idx]){
               idx=i;
           }
       }
       return idx;
    }

    public static void deleteEleFromArray(int[] noArray,int noToBeDeleted){
        boolean isEleFound=false;
        for(int i=0;i<noArray.length;i++){
            if(isEleFound){
                noArray[i-1]=noArray[i];
                noArray[i]=0;
            }
            if(noArray[i]==noToBeDeleted){
                isEleFound=true;
            }
        }
        if(isEleFound){
            System.out.println(java.util.Arrays.toString(noArray));
        }
        else {
            System.out.println("Element To Be Deleted Not Found");
        }
    }

    public static void printSecLarEleArrIdx(int[] noArray){
        int lar=-1,nexLar=-1;
        for(int no : noArray){
            if(no>lar){
                nexLar=lar;
                lar=no;
            }
            else{
                if(no>nexLar && no!=lar){
                    nexLar=no;
                }
            }
        }
        System.out.println("Second Largest No In Array is : "+nexLar);

    }

    public static void checkIfArraySorted(int noArray[]){
        //time complexity  O(n/2)
        int i=0, j = noArray.length-1;
        while (j>i){
            if(noArray[i]>=noArray[j]){
                System.out.println("No");
                return;
            }
            else{
                i++;
                j--;
            }
        }
        System.out.println("yes");
    }

    public static void reverseAnArray(int noArray[]){
        //time complexity  O(n/2)
        int i=0,j=noArray.length-1,temp;
        while(j>i){
            temp=noArray[i];
            noArray[i]=noArray[j];
            noArray[j]=temp;
            i++;
            j--;
        }
        System.out.println(i);
        System.out.println(java.util.Arrays.toString(noArray));
    }

    public static void removeDuplicatesFromSorArr(int[] noArray1){
        int[] noArray = {10,20,30,40};
        int len=noArray.length;
        for (int i=0;i<noArray.length-1;i++){
            if(noArray[i]==noArray[i+1]){
               while(i+1<noArray.length){
                   if(noArray[i]!=noArray[i+1]){
                       break;
                   }
                   i++;
                   --len;
               }
            }
        }
        System.out.println(len);
    }
    public static void removeDuplicatesFromSorArr1(int[] noArray1){
        int[] noArray = {10,10,30,40};
        int res =1;
        for (int i=1;i<noArray.length;i++){
            if(noArray[i]!=noArray[res-1]){
                noArray[res]=noArray[i];
                res++;
            }
        }
        System.out.println(java.util.Arrays.toString(noArray));
    }

    public static void moveZerosToEnd(){
        int[] noArray = {0,8,0,10,0,0};
        int res=0;
        for(int i=0;i<noArray.length-1;i++){
            if(noArray[i]!=0){
                int temp = noArray[res];
                noArray[res]=noArray[i];
                noArray[i]=temp;
                res++;
            }
        }
        System.out.println(java.util.Arrays.toString(noArray));
    }

}
