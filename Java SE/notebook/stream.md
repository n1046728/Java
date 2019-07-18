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
