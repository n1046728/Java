Encrypt Hibernate config
---
* Error hibernate-cfg..xml  
  [solution](https://stackoverflow.com/questions/8196370/hibernate-cfg-xml-not-found)
* Solved HibernateException: Access to DialectResolutionInfo cannot be null when ‘hibernate.dialect’ not set  
  [solution](https://www.journaldev.com/2897/hibernateexception-access-dialectresolutioninfo-cannot-null-hibernate-dialect-not-set)  
* [官網設定教學](http://www.jasypt.org/hibernate.html)  
  See section Encrypting the database password in hibernate.cfg.xml
  This encryptor object should have been registered beforehand as a Hibernate Encryptor-->see Without Spring section
* 步驟
1. 加密  
```cmd
java -cp jasypt-1.9.3.jar org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="1qaz2wsx" password=X6nVP89KZ8Ar
java -cp jasypt-1.9.3.jar org.jasypt.intf.cli.JasyptPBEStringDecryptionCLI input="tFJNNflAvewxidtlZ3U+P4hwjktpGUfN" password=X6nVP89KZ8Ar

```
2. 在hibernate.cfg.xml中的session-factory加入，若為c3p則加入EncryptedPasswordDriverManagerConnectionProvider   
```xml
    <property name="connection.provider_class">
      org.jasypt.hibernate4.connectionprovider.EncryptedPasswordDriverManagerConnectionProvider
    </property>
    <property name="connection.encryptor_registered_name">
      configurationHibernateEncryptor
    </property>
```
3. 在HibernateUtil.java中sessionFactory前加入
```java
    StandardPBEStringEncryptor configurationHibernateEncryptor = new StandardPBEStringEncryptor();
    HibernatePBEEncryptorRegistry registry = HibernatePBEEncryptorRegistry.getInstance();
    registry.registerPBEStringEncryptor("configurationHibernateEncryptor", configurationHibernateEncryptor);
    strongEncryptor.setPassword("X6nVP89KZ8Ar");
```  

* 發生問題  
  因為專案使用hibernate 4.3 但jasypt hibernate 從pom檔配置僅支援4.0，jar發生衝突，無法使用官網[配置方法](http://www.jasypt.org/hibernate.html)
* 教學參考  
  * [無框架設定完整作法](https://www.javaworld.com.tw/jute/post/view?bid=41&id=297336)  
  * [Hibernate4.x版替代官網的方法](https://github.com/hpadmanabhan/jasypt-hibernate4-ext)  
  * [spring設定](https://greddywork.gitlab.io/greddyblogs/2019/02/27/jasypt/)  
  * [不得已的作法](https://stackoverflow.com/questions/18636547/cannot-encrypt-password-in-configuration-file)
  
  
  
  Encrypting JDBC config
  ---
  [reference](https://www.jdev.it/encrypting-passwords-in-tomcat/)  
 * 步驟
  1. use Encryptor.java to encrypt password
  2. setting context.xml  
  ```xml
  <Resource name="jdbc/SRSDB"
          factory="EncryptedDataSourceFactory"
          ...
          password="82ea2bfa446b2cfsadfsdfdd83fadsfac0c7c4c"
          ...
   />
  ```
