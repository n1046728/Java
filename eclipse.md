Eclipse
===
Setting
---
* Windows->Preference->General->Workspace->Text file encoding->utf8
* Windows->Preference->General->Web->CSS files ->Encoding->utf8
* Windows->Preference->General->Web->HTML files ->Encoding->utf8
* Windows->Preference->General->Web->JSP files ->Encoding->utf8
* Windows->Preference->General->Appearance->Colors and Fonts->Text Font->Consolas 14  
* Windows->Preference->General->Appearance->Colors and Fonts->Dialog Font->Consolas 10  
* Windows->Preference->General->Appearance->Theme->Dark  
* Windows->Preference->General->WebBrowser>Chrome  
* Window->Preferences->Java>Editor->Content Assist->Auto Activation Trigger for java ->.abcdefghijklmnopqrstuvwxyz
* Windows->Preference->->Server->Runtime->Add->select Tomcat version ->Browser C:\apache-tomcat-9.0.21  

[Where is Eclipse deploy web application–Tomcat](https://www.mkyong.com/eclipse/where-is-eclipse-deploy-web-application-tomcat/)
---
* double click tomcat server->Open launch configuration->Arguments->see VM arguments:  
ex. C:\your_workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps

[Dynamic Web Project not picking up changes in jsp or java code](https://stackoverflow.com/questions/6179621/eclipse-dynamic-web-project-not-picking-up-changes-in-jsp-or)
---
* Project -> BuildAutomatically
* Server -> Publishing -> check Automatically publish when resource change
* if only jsp/js not change , try clearing out your cache on browser
