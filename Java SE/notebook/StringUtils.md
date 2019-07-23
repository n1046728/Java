* ***isEmpty(CharSequence cs) and isBlank(CharSequence cs)***  
1. isEmpty(CharSequence cs)  
Checks if a CharSequence is empty ("") or null.  
  
2. isBlank(CharSequence cs)  
Checks if a CharSequence is empty (""), null or whitespace only.  
3. API  
https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/StringUtils.html
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
