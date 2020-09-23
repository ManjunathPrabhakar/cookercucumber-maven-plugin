![cooker_cucumber logo](miscellaneous/cooker-logo.png)  
  
<p align="left">  
    <a href="https://search.maven.org/search?q=g:%22com.github.manjunathprabhakar%22%20AND%20a:%22cooker-maven-plugin%22" alt="maven-release-version">  
        <img src="https://img.shields.io/maven-central/v/com.github.manjunathprabhakar/cooker-maven-plugin" /></a>  
    <a href="https://github.com/ManjunathPrabhakar/cookercucumber-maven-plugin/releases" alt="maven-release-version">  
                            <img src="https://img.shields.io/github/release-date/ManjunathPrabhakar/cookercucumber-maven-plugin" /></a>  
    <a href="https://github.com/ManjunathPrabhakar/cookercucumber-maven-plugin/commits/master" alt="maven-release-version">  
                        <img src="https://img.shields.io/github/last-commit/ManjunathPrabhakar/cookercucumber-maven-plugin" /></a>  
    <a href="https://github.com/ManjunathPrabhakar/cookercucumber-maven-plugin/graphs/contributors" alt="maven-release-version">  
                            <img src="https://img.shields.io/github/contributors/ManjunathPrabhakar/cookercucumber-maven-plugin" /></a>  
    <br>  
    <a href="https://img.shields.io/github/languages/count/ManjunathPrabhakar/cookercucumber-maven-plugin" alt="maven-release-version">  
            <img src="https://img.shields.io/github/languages/count/ManjunathPrabhakar/cookercucumber-maven-plugin" /></a>  
    <a href="https://img.shields.io/github/languages/top/ManjunathPrabhakar/cookercucumber-maven-plugin" alt="maven-release-version">  
                    <img src="https://img.shields.io/github/languages/top/ManjunathPrabhakar/cookercucumber-maven-plugin" /></a>  
    <a href="https://img.shields.io/github/languages/code-size/ManjunathPrabhakar/cookercucumber-maven-plugin" alt="maven-release-version">  
                <img src="https://img.shields.io/github/languages/code-size/ManjunathPrabhakar/cookercucumber-maven-plugin" /></a>  
    <a href="https://img.shields.io/github/repo-size/ManjunathPrabhakar/cookercucumber-maven-plugin" alt="maven-release-version">  
                    <img src="https://img.shields.io/github/repo-size/ManjunathPrabhakar/cookercucumber-maven-plugin" /></a>  
    <br>                  
    <a href="https://img.shields.io/github/license/ManjunathPrabhakar/cookercucumber-maven-plugin" alt="maven-release-version">  
                    <img src="https://img.shields.io/github/license/ManjunathPrabhakar/cookercucumber-maven-plugin" /></a>    
</p>  
     
>**This Plugin uses Gherkin Dependency 5.2.0**   
##### For newer version of Gherkin features please refer new plugin : [Click Here](https://github.com/ManjunathPrabhakar/cooker-new-version/)  
  
**CURRENTLY THIS AVAILABLE IN MAVEN CENTRAL** (Find the version above)  
  
## Features  
  
## Plugin Usage  
  
### Maven dependency  
  
```xml  
<dependency>  
	 <groupId>com.github.manjunathprabhakar</groupId>
	 <artifactId>cookercucumber-maven.plugin</artifactId> 
	 <version>(check version on top of the page)</version>
</dependency>  
```  

Complete POM plugin dependency
```xml 
 <plugin>
	 <groupId>com.github.manjunathprabhakar</groupId>
	 <artifactId>cooker-maven-plugin</artifactId>    
     <version>${cookercucumber.plugin.version}</version>    
            
     <configuration>    
	     <!--suppress UnresolvedMavenProperty -->    
         <tag>@E2E</tag>    
         <stepDefPackage>stepDefs</stepDefPackage>    
	     <templatePath>${project.basedir}\src\main\resources\templates\TestRunnerTemplate.template</templatePath>    
         <featuresPath>${project.basedir}\src\test\features</featuresPath>    
         <featureFilesGenDir>${project.basedir}\src\test\resources\generated\featureFiles\</featureFilesGenDir>    
         <testRunnersGenDir>${project.basedir}\src\test\java\generated\testRunners\</testRunnersGenDir>    
         <customPlaceHolders>    
			 <progAuthor>Manjunath</progAuthor>    
         </customPlaceHolders>    
     </configuration>
     
     <executions>    
	     <execution>    
	         <goals>    
	             <goal>cook</goal>    
             </goals>    
         </execution>    
     </executions>
       
</plugin>   
```  
  
Please clone , and run `MVN INSTALL` to install in your machine and Add entries in pom or pick the dependencies from central and add to pom  
  
> Features : > 1. Now Supports Excel Data for Cucumber Feature Files  
  
  
*THIS PLUGIN IS TESTED WITH VERSIONS MENTIONED IN THE CODE.  
And Tested in TESTNG Framework. Its works with JUNIT as well.*  
  
  
**FOR USAGE IN YOUR PROJECT (Refer Below Usage)**  
  
### USAGE IN MAVEN POM.XML  
  
 <plugin> <groupId>com.github.manjunathprabhakar</groupId>        <artifactId>cooker-maven-plugin</artifactId>    
        <version>2.0.5</version>    
            
        <configuration>    
            <!--suppress UnresolvedMavenProperty -->    
          <tag>@E2E</tag>    
            <stepDefPackage>stepDefs</stepDefPackage>    
            <templatePath>${project.basedir}\src\main\resources\templates\TestRunnerTemplate.template    
            </templatePath>    
            <featuresPath>${project.basedir}\src\test\features</featuresPath>    
            <featureFilesGenDir>${project.basedir}\src\test\resources\generated\featureFiles\    
            </featureFilesGenDir>    
            <testRunnersGenDir>${project.basedir}\src\test\java\generated\testRunners\</testRunnersGenDir>    
            <customPlaceHolders>    
                <progAuthor>Manjunath</progAuthor>    
            </customPlaceHolders>    
        </configuration>    
        <executions>    
            <execution>    
                <goals>    
                    <goal>cook</goal>    
                </goals>    
            </execution>    
        </executions>  
 </plugin>               
 ### USAGE OF EXCEL DATA(Supports *.xlsx & *xls only)  
  
1. If the Excel in project root folder  
  
Add this tag above scenario outline   
  
> @excel=root=book.xlsx=Sheet1  
  
2. If the Excel is in Other Folder, Please add like below  
  
> @excel=D:\MyDataFactory=book.xlsx=Sheet1  
  
3. When the plugin is run, the data in the excel is replaced with Examples data.  
  
Example :   
Original Feature File (test.feature)  
  
 @E2E1    Feature: Test Feature    
        
      Background: im a background    
        Given some five    
        Then go fly    
        
    #  Rule: some Rule  # This Plugin Doesnt SUpport Rule  
       @E2E    
      Scenario: Test New    
          Given hello world    
          Then Try me    
        
        @E2E @excel=root=book.xlsx=Sheet1    
      Scenario Outline: Test Scenario EXCEL    
          Given Some Given    
          When Some When "<MANJU>"    
          Then Some Then    
          And Some And    
        
        
          Examples:    
            | MANJU |    
            | data |    
        
      @E2E2   @excel=root=book.xlsx=Sheet1   
      Scenario Outline: Test Scenario New One    
          Given Some Given    
          When Some When "<MANJU>"    
          Then Some Then    
          And Some And    
            
      Examples:    
            | MANJU |    
             | data |  
  
In my project root folder i have an excel file with some data  
  
When i execute the plugin.  
Two files & Also, its corresponding Test Runner Files are also generated  like below:   
  
Feature File #1 (src/test/resources/generated/featureFiles/Test_Feature_BH5850.feature)  
  
 @E2E1    Feature: Test Feature    
    Background: im a background    
        
    Given some five    
    Then go fly    
        
    @E2E    
    Scenario: Test New    
        
    Given hello world    
    Then Try me  
  
Runner File #1 (src/test/java/generated/testRunners/Test_Feature_BH5850.java)  
  
 package generated.testRunners;        
    import io.cucumber.testng.AbstractTestNGCucumberTests;    
    import io.cucumber.testng.CucumberOptions;    
    import org.testng.annotations.DataProvider;    
        
    @CucumberOptions(    
            features = "G:/IntelliJWorkspace/cooker-new-version-example-project/src/test/resources/generated/featureFiles/Test_Feature_BH5850.feature",    
            glue = {"stepDefs"},    
            plugin = {"customReporters.CustomReporter","pretty","json:target/cucumber-reports/output.json"},    
            strict = true,    
            dryRun = false,    
            monochrome = false    
    )    
    public class Test_Feature_BH5850 extends AbstractTestNGCucumberTests {   
        //Created : Sun Aug 16 10:40:50 IST 2020    
     //Triggered By : Manjunath    
      @Override    
            @DataProvider(parallel = true)    
            public Object[][] scenarios() {    
                return super.scenarios();    
            }    
    }      
    //Plugin Created by : Manjunath Prabhakar   
    // Auto Generated by Cooker Cucumber Maven Plugin  
  
File #2 (src/test/resources/generated/featureFiles/Test_Feature_IU3429.feature)  
**NOTICE THE EXAMPLES DATA HAS BEEN REPLACED**  
  
 @E2E1    Feature: Test Feature    
    Background: im a background    
        
    Given some five    
    Then go fly    
        
    @E2E    
    @excel=root=book.xlsx=Sheet1    
    Scenario Outline: Test Scenario EXCEL    
        
    Given Some Given    
    When Some When "<MANJU>"    
    Then Some Then    
    And Some And    
    Examples:    
    |MANJU|    
    |new|    
    |dew|    
    |few|    
    |skew|    
    |phew!|  
  
  
Runner File #2 (src/test/java/generated/testRunners/Test_Feature_IU3429.java)  
  
 package generated.testRunners;        
    import io.cucumber.testng.AbstractTestNGCucumberTests;    
    import io.cucumber.testng.CucumberOptions;    
    import org.testng.annotations.DataProvider;    
        
    @CucumberOptions(    
            features = "G:/IntelliJWorkspace/cooker-new-version-example-project/src/test/resources/generated/featureFiles/Test_Feature_IU3429.feature",    
            glue = {"stepDefs"},    
            plugin = {"customReporters.CustomReporter","pretty","json:target/cucumber-reports/output.json"},    
            strict = true,    
            dryRun = false,    
            monochrome = false    
    )    
    public class Test_Feature_IU3429 extends AbstractTestNGCucumberTests {    
        
        //Created : Sun Aug 16 10:40:50 IST 2020    
     //Triggered By : Manjunath    
      @Override    
     @DataProvider(parallel = true)    
            public Object[][] scenarios() {    
                return super.scenarios();    
            }    
        
    }    
        
        
    //Plugin Created by : Manjunath Prabhakar    
        
    // Auto Generated by Cooker Cucumber Maven Plugin  
  
  
Example of Template Directory: (Customizable as per TestNG/JUNIT, Customizable with runner file])  
(src/main/resources/templates/TestRunnerTemplate.template)  
  
 package generated.testRunners;        
    import io.cucumber.testng.AbstractTestNGCucumberTests;    
    import io.cucumber.testng.CucumberOptions;    
    import org.testng.annotations.DataProvider;  //Optional  
     @CucumberOptions(    
            features = [COOKER:FEATUREFILE],    
            glue = {[COOKER:GLUE]},    
            plugin = {"customReporters.CustomReporter","pretty","json:target/cucumber-reports/output.json"},  //Optional  
 strict = true,  //Optional dryRun = false,  //Optional monochrome = false  //Optional )    public class [COOKER:RUNNERCLASS] extends AbstractTestNGCucumberTests {    
        
        //Created : [COOKER:TIMESTAMP]  //Optional  
 //Triggered By : [COOKER:PROGAUTHOR]   //Added from POM.XML //Optional         @Override  //Optional  
 @DataProvider(parallel = true) //Optional public Object[][] scenarios() {  //Optional return super.scenarios();  //Optional }  //Optional     }    
        
        
    //Plugin Created by : [COOKER:PLUGIN_OWNER] //Optional