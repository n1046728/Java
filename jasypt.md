Encrypt Hibernate config
---
* Error hibernate-cfg..xml  
  [solution](https://stackoverflow.com/questions/8196370/hibernate-cfg-xml-not-found)
* Solved HibernateException: Access to DialectResolutionInfo cannot be null when ‘hibernate.dialect’ not set  
  [solution](https://www.journaldev.com/2897/hibernateexception-access-dialectresolutioninfo-cannot-null-hibernate-dialect-not-set)  
* 發生問題  
  因為專案使用hibernate 4.3 但jasypt hibernate 從pom檔配置僅支援4.0，jar發生衝突，無法使用官網[配置方法](http://www.jasypt.org/hibernate.html)
* 替代方案參考  
  [參考1](https://greddywork.gitlab.io/greddyblogs/2019/02/27/jasypt/)  
  [參考2](https://www.javaworld.com.tw/jute/post/view?bid=41&id=297336)
  
