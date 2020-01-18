package com.xiu.recursion;

/**
 * 迷宫问题
 * 二维数组模拟迷宫
 */
public class Migong {

    public static void main(String[] args) {
        //地图
        int[][] map=new int[8][7];
        //墙为1
        for (int i = 0; i <7 ; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        for (int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        //障碍
        map[3][1]=1;
        map[3][2]=1;
        findWay(map, 1, 1);
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt+"    ");
            }
            System.out.println();
        }
    }

    /**
     *使用递归回溯
     * 0 表示还没经过的位置
     * 2表示通路
     * 3表示已经走过，但是走不通
     * 策略：先走 下->右->上->左
     *
     * @param map 地图
     * @param i  从哪个位置开始
     * @param j
     * @return 找到终点返回true
     */
    public static boolean findWay(int[][] map,int i,int j){
        if(map[6][5]==2){
            return true;//通路了
        }else{
            if(map[i][j]==0){
                //还没有走过
                //按照策略走
                map[i][j]=2;//先假设该点可以走通
                if(findWay(map, i+1, j)){
                    return true;//向下走
                }else if(findWay(map, i, j+1)){
                    return true;//向右走
                }else if(findWay(map, i-1, j)){
                    return true;//向上走
                }else if (findWay(map, i,j-1 )){
                    return true;//向左走
                }else{
                    //如果进到这里说明这个点走不通
                    map[i][j]=3;
                }
            }else{
                return false;
            }
        }
        return false;
    }

    /**
     * 改变策略：改成上->右->下->左
     * @param map
     * @param i
     * @param j
     * @return
     */
    /*public static boolean findWay2(int[][] map,int i,int j){
        if(map[6][5]==2){
            return true;//通路了
        }else{
            if(map[i][j]==0){
                //还没有走过
                //按照策略走
                map[i][j]=2;//先假设该点可以走通
                if(findWay(map, i-1, j)){
                    return true;//向上走
                }else if(findWay(map, i, j+1)){
                    return true;//向右走
                }else if(findWay(map, i+1, j)){
                    return true;//向下走
                }else if (findWay(map, i,j-1 )){
                    return true;//向左走
                }else{
                    //如果进到这里说明这个点走不通
                    map[i][j]=3;
                }
            }else{
                return false;
            }
        }
        return false;
    }*/
}
