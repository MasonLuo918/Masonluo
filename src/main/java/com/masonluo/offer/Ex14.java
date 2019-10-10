package com.masonluo.offer;

public class Ex14 {
    public static int maxProductAfterCutting_dynamic_programming(int length){
        // �����2��3�Ļ���ֱ�ӷ���
        if(length < 2){
            return 0;
        }
        if(length == 2){
            return 1;
        }
        if(length == 3){
            return 2;
        }
        int[] products = new int[length + 1];
        // �����Ӿֲ�����Ϊ1��2��3  ���о�������
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for(int i = 4; i <= length; i++){
            max = 0;
            for(int j = 1; j <= i / 2; j++){
                int product = products[j] * products[i - j];
                if(max < product)
                    max = product;
            }
            products[i] = max;
        }
        max = products[length];
        return max;
    }

    public static int maxProductAfterCutting_greed(int length){
        if(length < 2){
            return 0;
        }
        if(length == 2){
            return 1;
        }
        if(length == 3){
            return 2;
        }

        // �����ܶ�ļ�ȥ����Ϊ3���ֶ�
        int timeOf3 = length / 3;
        // ���������ʣ�µĳ���Ϊ4�� �����ټ�����Ϊ3�����Ӷ�
        if(length - timeOf3 * 3 == 1){
            timeOf3 -=1;
        }
        int timeOf2 = (length - timeOf3 * 3) / 2;
        return (int)(Math.pow(3, timeOf3)) * (int)(Math.pow(2, timeOf2));
    }

    public static void main(String[] args) {
        System.out.println(maxProductAfterCutting_dynamic_programming(8));
        System.out.println(maxProductAfterCutting_greed(8));
    }
}