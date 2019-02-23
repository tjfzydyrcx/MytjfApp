package com.example.mytjfapp.MeiModel.算法;

import android.icu.util.ULocale;

/**
 * Created by Administrator on 2019-02-21 0021.
 * Java实现二叉树
 */

public class BinaryTree {
    int treeNode;
    BinaryTree leftTree;
    BinaryTree rightTree;
    public  BinaryTree(int Data){
        treeNode=Data;
        leftTree= null;
        rightTree=null;
    }


    public  void  insert(BinaryTree node,int data){
        if (data>node.treeNode){
            if (node.rightTree==null){
                rightTree=new BinaryTree(data);
            }else{
                this.insert(node.rightTree,data);
            }
        }else{

            if (node.leftTree==null){
                leftTree=new BinaryTree(data);
            }else{
                this.insert(node.leftTree,data);
            }
        }
    }
}
