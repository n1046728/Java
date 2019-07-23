* ***isEmpty(CharSequence cs) and isBlank(CharSequence cs)***
isEmpty(CharSequence cs)  
Checks if a CharSequence is empty ("") or null.  

isBlank(CharSequence cs)  
Checks if a CharSequence is empty (""), null or whitespace only.  

```java
  //isBlank()
  boolean a = StringUtils.isBlank("");//true
	boolean b = StringUtils.isBlank("  ");//true
  boolean c = StringUtils.isBlank(null);//true
	boolean d = StringUtils.isBlank("james");//false
  System.out.println(a+" "+b+" "+c+" "+d);
  
  //isEmpty()
  boolean a = StringUtils.isEmpty("");//true
	boolean b = StringUtils.isEmpty("  ");//false
	boolean c = StringUtils.isEmpty(null);//true
  boolean d = StringUtils.isEmpty("james");//false
	System.out.println(a+" "+b+" "+c+" "+d);
  
```
