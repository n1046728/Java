* Predicate謂詞  
  返回boolean的函數  
  

1. findAny()  
As the name suggests, the findAny() method allows you to find any element from a Stream. **In a non-parallel operation, it will most likely return the first element in the Stream but there is no guarantee for this.**
For maximum performance when processing the parallel operation the result cannot be reliably determined.

2. findFirst()  
The findFirst() method finds the first element in a Stream. Obviously, this method is used when you specifically want the first element from a sequence.

```java
  List<Integer> list = Arrays.asList(1,3,5,10);
  Optional<Integer> num1= list.stream().parallel().filter(s->s>0).findAny();
  Optional<Integer> num2= list.stream().filter(s->s>0).findFirst();
		
  System.out.println(num1);// 1 or 3 or 5 or 10
  System.out.println(num2);// 1
```

3. boolean allMatch(Predicate<? super T> predicate)  
   Returns whether all elements of this stream match the provided predicate.  

4. anyMatch(Predicate<? super T> predicate)  
   Returns whether any elements of this stream match the provided predicate.

5. noneMatch(Predicate<? super T> predicate)  
   Returns whether no elements of this stream match the provided predicate.  
   
```java
 List<String> arr = Arrays.asList("b","b","b","b","a");
 boolean a = arr.stream().anyMatch(s->s.equals("a"));
 boolean b = arr.stream().allMatch(s->s.equals("b"));
 boolean c = arr.stream().noneMatch(s->s.equals("c"));
 
 System.out.println(a);//true
 System.out.println(b);//false
 System.out.println(c);//true
```
