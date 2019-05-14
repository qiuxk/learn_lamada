package com.qiuxk.learn_lamada.service;

import com.qiuxk.learn_lamada.exception.BaseException;

import java.util.List;

/**
 * 基于List泛型为String的list操作
 */

public interface ListOperation {


    /***
     * list的交集
     * @param list1
     * @param list2
     * @return
     */
    List<String> intersectionList(List<String> list1,List<String> list2);


    /***
     * list1 - list2 的集合
     * @param list1
     * @param list2
     * @return
     */
    List<String> diffList(List<String> list1,List<String> list2);


    /**
     * 并集
     * @param list1
     * @param list2
     * @return
     */
    List<String> unionList(List<String> list1,List<String> list2);


    /**
     * 并集 并且 去重
     * @param list1
     * @param list2
     * @return
     */
    List<String> unionListWithoutSame(List<String> list1,List<String> list2);

    /**
     * 求和
     * @param list1
     * @return
     */
    Integer sumAll(List<String> list1) throws BaseException;









}
