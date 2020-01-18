package com.xiu.sparseArray;

import java.io.*;

public class SparseArray {
    public static void main(String[] args) throws IOException {
        int[][] chessArr=new int[11][11];
        chessArr[1][2]=1;
        chessArr[2][3]=2;
        chessArr[3][4]=2;
        for (int[] ints : chessArr) {
            for (int anInt : ints) {
//                System.out.print(anInt+"    ");
            }
            System.out.println();
        }
        //将二维数组转稀疏数组
        int sum=0;
        for (int[] ints : chessArr) {
            for (int anInt : ints) {
                if(anInt !=0){
                    sum++;
                }
            }
        }
        //2.创建稀疏数组
        int sparseArr[][]=new int[sum+1][3];
        //给稀疏数组赋值
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
        //将非0的值存入稀疏数组
        int count=0;//记录是第几个非0数据
        for (int i = 0; i <11; i++) {
            for (int j = 0; j <11 ; j++) {
                if(chessArr[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr[i][j];
                }
            }
        }
        for (int i = 0; i <sparseArr.length; i++) {
            for (int j = 0; j <sparseArr[i].length ; j++) {
//                System.out.print(sparseArr[i][j]+"    ");
            }
            System.out.println();
        }
    new SparseArray().saveToComputer(sparseArr);
    }

    /**
     * 将稀疏数组转换为二维数组
     * @param sparseArr
     * @return
     */
    public int[][] sparseToArray(int[][] sparseArr){
        //将稀疏数组转为二维数组
        int two[][]=new int[sparseArr[0][0]][sparseArr[0][1]];
        //将稀疏数组的值赋给二维数组
        for (int i = 1; i <sparseArr.length ; i++) {
            two[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        for (int i = 0; i <two.length; i++) {
            for (int j = 0; j <two[i].length ; j++) {
                System.out.print(two[i][j]+"    ");
            }
            System.out.println();
        }
        return two;
    }

    /**
     * 将将稀疏数组保存到磁盘上
     */
    public void saveToComputer(int[][] sparseArr) throws IOException {
        File file=new File("data.txt");
        file.createNewFile();
        FileWriter out = new FileWriter(file);

        FileOutputStream fileOutputStream= new FileOutputStream(file);
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        for (int i = 0; i <sparseArr.length ; i++) {
            for (int j = 0; j <sparseArr[i].length ; j++) {
                dataOutputStream.writeBytes(new String((""+sparseArr[i][j]+"    ").getBytes(), "gbk"));
            }
            dataOutputStream.writeBytes("\r\n");
            System.out.println("打印成功");
            out.close();
        }
        System.out.println("输出文件成功");
    }
}
