package com.example.mytjfapp.MeiModel.算法;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2019-02-21 0021.
 */

public class BinaryTreeOrder {


    public static void preOrder(BinaryTree root) {
       if (root!=null){
           System.out.print(root.treeNode+"-");
           preOrder(root.leftTree);
           preOrder(root.rightTree);
       }
    }

    public static void inOrder(BinaryTree root) {
        if (root!=null){

            inOrder(root.leftTree);
            System.out.print(root.treeNode+"-");
            inOrder(root.rightTree);
        }
    }
    public static void postOrder(BinaryTree root) {
        if (root!=null){

            postOrder(root.leftTree);
            postOrder(root.rightTree);
            System.out.print(root.treeNode+"-");
        }
    }
    public static void main(String[] args) {
        int[] array = { 12, 76, 35, 22, 16, 48, 90, 46, 9, 40 };
        BinaryTree root = new BinaryTree(array[0]); // 创建二叉树
        for (int i = 1; i < array.length; i++) {
            System.out.println("array[i]："+array[i]);
            root.insert(root, array[i]); // 向二叉树中插入数据
        }
        System.out.println("先序遍历：");
        preOrder(root);
        System.out.println();
        System.out.println("中序遍历：");
        inOrder(root);
        System.out.println();
        System.out.println("后序遍历：");
        postOrder(root);
    }
}