package com.qiuxk.learn_lamada.impl;

import com.qiuxk.learn_lamada.entity.Person;
import com.qiuxk.learn_lamada.entity.User;
import com.qiuxk.learn_lamada.service.ComplexListOperation;

import java.util.List;
import java.util.stream.Collectors;

public class ComplexListOpreationImpl implements ComplexListOperation {

    /**
     * user 的userId和 person的id 相同 返回list<user>集合
     *
     * @param userList
     * @param personList
     * @return
     */
    @Override
    public List<User> intersectionList(List<User> userList, List<Person> personList) {
        List<User> resList = userList.parallelStream().filter(item -> personList.stream().map(person -> person.getId()).collect(Collectors.toList())
                .contains(item.getUserId())).collect(Collectors.toList());
        return resList;
    }

    /**
     * 返回userList 中不和personList中id相同的集合
     *
     * @param userList
     * @param personList
     * @return
     */
    @Override
    public List<User> diffList(List<User> userList, List<Person> personList) {
        List<User> resList = userList.parallelStream().filter(item -> !personList.stream().
                map(person -> person.getId()).collect(Collectors.toList()).contains(item.getUserId())).collect(Collectors.toList());


        return resList;
    }

    @Override
    public List<User> unionList(List<User> userList, List<Person> personList) {
        List<User> person2UserList = personList.stream().map(person -> {
            User user = new User();
            user.setUserId(person.getId());
            user.setAge(person.getAge());
            user.setSex(person.getSex());
            return user;
        }).collect(Collectors.toList());
        userList.addAll(person2UserList);
        return userList;
    }

    @Override
    public List<User> unionListWithoutSame(List<User> userList, List<Person> personList) {
        /**personList 中独有的person对象  userList中没有的**/
        List<Person> onlyPersonList = personList.parallelStream().filter(person -> !userList.stream().map(
                user -> user.getUserId()).collect(Collectors.toList()).contains(person.getId())).collect(Collectors.toList());

        /**把onlyPersonList 转换成泛型为user的list**/
        List<User> person2UserList = onlyPersonList.stream().map(person -> {
            User user = new User();
            user.setUserId(person.getId());
            user.setSex(person.getSex());
            user.setAge(person.getAge());
            return user;

        }).collect(Collectors.toList());

        userList.addAll(person2UserList);


        return userList;
    }
}
