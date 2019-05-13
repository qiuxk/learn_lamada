package com.qiuxk.learn_lamada.service;

import com.qiuxk.learn_lamada.entity.Person;
import com.qiuxk.learn_lamada.entity.User;

import java.util.List;

public interface ComplexListOperation {


    /***
     * list的交集  user的id和 person的id相同
     * @param userList
     * @param personList
     * @return
     */
    List<User> intersectionList(List<User> userList, List<Person> personList);


    /***
     * list1 - list2 的集合
     * @param userList
     * @param personList
     * @return
     */
    List<User> diffList(List<User> userList, List<Person> personList);


    /**
     * 并集
     * @param userList
     * @param personList
     * @return
     */
    List<User> unionList(List<User> userList, List<Person> personList);


    /**
     * 并集 并且 去重
     * @param userList
     * @param personList
     * @return
     */
    List<User> unionListWithoutSame(List<User> userList, List<Person> personList);

}
