**学习lamada表达式**

##### 	1.基本接口

```java
1.Predicate<T>接口的中的方法， 逻辑判断，调用接口中test方法，返回boolean  用predicate接口进行判断
2.Supplier<T> 接口 只有get()方法 返回T	
3.Consumer<T> 接口  没有返回值 常用accept 方法 只接受 不返回   forEach()方法的参数就是Consumer接口
4.Function<T, R>接口，  有R apply(T t)方法，接受T  返回 R
```

**2.排序相关接口**

```java
Comparable 接口，实现这个接口的类，
只有一个方法compareTo，a > b 返回1，a<b  返回-1，a =b 返回0
实现这个接口的类，例如Person类，则List<Person>，可以直接Collections.sort（List<Person>）或者Arrays.sort进行排序
```



```java
Comparator比较器接口，这个类没有实现Comparable接口，需要实现compareTo(T 01,T 02)接口，
```

```java

```
