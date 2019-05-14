package com.qiuxk.learn_lamada.impl;

import com.qiuxk.learn_lamada.exception.BaseException;
import com.qiuxk.learn_lamada.service.ListOperation;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @Override
    public Integer sumAll(List<String> list1) throws BaseException {

       /* IntStream intStream = list1.stream().mapToInt((i) -> new Integer(i));
        IntSummaryStatistics summaryStatistics = intStream.summaryStatistics();


        summaryStatistics.getSum();//求和
        summaryStatistics.getAverage()//平均值
        summaryStatistics.getMax();//最大值
        summaryStatistics.getMin();//最小值*/

    /*    Optional<List<String>> opsList = Optional.ofNullable(list1);
         opsList.ifPresent(i ->i.stream().map( j -> Integer.valueOf(j)).collect(Collectors.toList()).
                stream().reduce((a,b)->a+b).orElse(new Integer("0")));*/
        Optional.ofNullable(list1).orElseThrow(BaseException::new);
        Optional<Integer> reduce = list1.stream().map(i -> Integer.valueOf(i)).collect(Collectors.toList()).stream().reduce((a, b) -> a + b);
        return  reduce.orElse(null);
    }

}
