package org.example.array.medium;

public class RotateImageBy90Degree {
    public static void main(String[] args) {
        int [][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j]+"    ");
            }
            System.out.println();
        }
        System.out.println("****************************");
        int[][] arr1 = rotateArrayBrute(arr,n,m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr1[i][j]+"    ");
            }
            System.out.println();
        }
        System.out.println("##########################");

        int [][] arr2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int k = arr2.length;
        int l = arr2[0].length;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < l; j++) {
                System.out.print(arr2[i][j]+"    ");
            }
            System.out.println();
        }
        System.out.println("****************************");
        rotateArrayOptimal(arr2,k,l);
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < l; j++) {
                System.out.print(arr2[i][j]+"    ");
            }
            System.out.println();
        }
    }

    public static int[][] rotateArrayBrute(int [][] arr, int n, int m){
        int [][] arr1 = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr1[j][n-i-1]=arr[i][j];
            }
        }
        return  arr1;
    }

    public static void rotateArrayOptimal(int [][] arr, int n, int m){
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < m; j++) {
                int tmp = arr[j][i];
                arr[j][i]=arr[i][j];
                arr[i][j]=tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            int sp=0;
            int ep = arr[i].length-1;
            while(sp<=ep){
                int tmp=arr[i][sp];
                arr[i][sp]=arr[i][ep];
                arr[i][ep]=tmp;
                sp++;
                ep--;
            }

        }
    }

}
