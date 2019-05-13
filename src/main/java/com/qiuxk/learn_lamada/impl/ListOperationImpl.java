package com.qiuxk.learn_lamada.impl;

import com.qiuxk.learn_lamada.service.ListOperation;

import java.util.List;
import java.util.stream.Collectors;

public class ListOperationImpl implements ListOperation {



    /***
     * list的交集
     * @param list1
     * @param list2
     * @return
     */
   public List<String> intersectionList(List<String> list1, List<String> list2){
       List<String> resList = list1.stream().filter(item -> list2.contains(item)).collect(Collectors.toList());

       resList.parallelStream().forEach(System.out::println );
       return resList;
    }


    /***
     * list1 - list2 的集合
     * @param list1
     * @param list2
     * @return
     */
   public List<String> diffList(List<String> list1,List<String> list2){
       List<String> reslist = list1.stream().filter(item -> !list2.contains(item)).collect(Collectors.toList());
       reslist.parallelStream().forEach(System.out::println);

       return reslist;
    }


    /**
     * 并集
     * @param list1
     * @param list2
     * @return
     */
    public List<String> unionList(List<String> list1,List<String> list2){
        List<String> collect1 = list1.parallelStream().collect(Collectors.toList());
        List<String>  collect2 = list2.parallelStream().collect(Collectors.toList());
        collect1.addAll(collect2);
        return collect1;
    }


    /**
     * 并集 并且 去重
     * @param list1
     * @param list2
     * @return
     */
    public  List<String> unionListWithoutSame(List<String> list1,List<String> list2){
        List<String> collect1 = list1.parallelStream().collect(Collectors.toList());
        List<String>  collect2 = list2.parallelStream().collect(Collectors.toList());
        collect1.addAll(collect2);
        List<String> resList = collect1.parallelStream().distinct().collect(Collectors.toList());
        return resList;
    }

}
