[![cooker_cucumber logo](miscellaneous/cooker-logo.png)](https://manjunathprabhakar.github.io/cookercucumber-maven-plugin/)  
  
<p align="left">
    <a href="#" alt="maven-release-version">  
        <img src="https://img.shields.io/github/workflow/status/ManjunathPrabhakar/cookercucumber-maven-plugin/CookerCucumberReleaseWorkflow" /></a>
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

# Contents 

- [Plugin Features](#plugin-features)
    - [Capablity #1(Cooker Main Plugin)](#capability-1-cooker-main)
    - [Capablity #2(Cooker Reporter Plugin)](#capability-2-cooker-reporter)
- [Plugin Usage](#plugin-usage)
    - [Maven Dependency](#maven-dependency)
    - [Usage with Individual Capability](#usage-with-individual-capability)
    - [Usage with Combined Capability](#usage-with-combined-capabilities)
- [Template](#template)
    - [TestNG Template](#testng-template-format-)
    - [JUnit Template](#junit-template-format-)
    - [Note on Place Holders](#note-on-place-holder-)
- [Usage of Data from File](#usage-of-data-from-files-for-scenario-outline)
    - [Excel Usage](#excel-file-supports-xlsx--xls-only)
    - [CSV Usage](#csv-file-supports-csv-with-delimitercommasemi-colonpipe)
    - [TXT Usage](#text-file-supports-txt-with-exact-copy-like-examples)
- [Example Project](#example-project)
- [Appendix](#appendix)
    - [Limitations](#limitations)
    - [Versions](#version)
    - [License](#license)
    - [Credits](#credits)
---
  
## Plugin Features  

- This plugin give's two different capabilities which can be combined/used individually.

### Capability #1 (COOKER MAIN)
#### Filter-Select-Generate(FSG) Features/Scenarios into it's smallest piece for Execution
#### FSG is dependent on the Cucumber Tag mentioned

- Skim all feature files and get those needed for execution only.
- Scenario's are selected through Cucumber Tags and Seprate Feature Files are created.
- Supports Usage of Data from Flat Files (Excel, CSV, Txt) for scenario Outlines
 
### Capability #2 (COOKER REPORTER)
#### Parse & Generate Execution Summary Report
#### This is dependent on JSON files generated by cucumber

- Read all JSON files in the directory
- Parse & Generate Summary report of all features in Console (Current Feature Only)
- Stand alone Detailed Graphical UI HTML Report (Future Release)  

---

## Plugin Usage

This Plugin can be used either with combined capabilities or individual capability

### Maven dependency  
  
```xml  
<dependency>  
	 <groupId>com.github.manjunathprabhakar</groupId>
	 <artifactId>cookercucumber-maven.plugin</artifactId> 
	 <version>${cookercucumber.plugin.version}</version>
</dependency>  
```  

### Usage with Individual Capability

1. Use only [COOKER MAIN(FSG)](#capability-1-cooker-main):

  Complete POM plugin dependency
  ```xml 
   <plugin>
       <groupId>com.github.manjunathprabhakar</groupId>
       <artifactId>cooker-maven-plugin</artifactId>    
       <version>${cookercucumber.plugin.version}</version>    

       <executions>    
            <execution>    
            <id>cooker-main-plugin</id> 	       
            <phase>initilize</phase>
            <goals>    
                <goal>cook</goal>    
            </goals> 
            <configuration>
                
                <!-- MANDATORY COOKER MAIN PROPERTIES -->
                    
                <!--suppress UnresolvedMavenProperty -->    
                <tags>@E2E</tags>    
                <stepDefPackage>stepDefs</stepDefPackage>    
                <templatePath>${project.basedir}\src\main\resources\templates\TestRunnerTemplate.template</templatePath>    
                <featuresPath>${project.basedir}\src\test\features</featuresPath>    
                <featureFilesGenDir>${project.basedir}\src\test\resources\generated\featureFiles\</featureFilesGenDir>    
                <testRunnersGenDir>${project.basedir}\src\test\java\generated\testRunners\</testRunnersGenDir>    
                
                <!-- OPTIONAL COOKER MAIN PROPERTIES -->
                
                <customPlaceHolders>    
                    <progAuthor>Manjunath</progAuthor>    
                </customPlaceHolders>    
            </configuration>
          
         </execution>    
       </executions>
         
  </plugin>   
  ```  

2. Use only [COOKER REPORTER(PG)](#capability-2-cooker-reporter):

Complete POM plugin dependency
  ```xml 
   <plugin>
       <groupId>com.github.manjunathprabhakar</groupId>
       <artifactId>cooker-maven-plugin</artifactId>    
       <version>${cookercucumber.plugin.version}</version>    

       <executions>    
            <execution>    
            <id>cooker-reporter-plugin</id> 	       
            <phase>post-integration-test</phase>
            <goals>    
                <goal>cook-report</goal>    
            </goals> 
            <configuration>
                
                <!-- MANDATORY COOKER REPORTER PROPERTIES -->
                      
                <jsonPath>${project.build.directory}\cucumber-reports</jsonPath>    
                
            </configuration>
          
         </execution>    
       </executions>
         
  </plugin>   
  ```  

### Usage with Combined Capabilities

1. Use both [COOKER MAIN(FSG)](#capability-1-cooker-main) and [COOKER REPORTER(PG)](#capability-2-cooker-reporter) together:

 Complete POM plugin dependency
  ```xml 
   <plugin>
       <groupId>com.github.manjunathprabhakar</groupId>
       <artifactId>cooker-maven-plugin</artifactId>    
       <version>${cookercucumber.plugin.version}</version>    

       <executions>    
            <execution>    
            <id>cooker-main-plugin</id> 	       
            <phase>initilize</phase>
            <goals>    
                <goal>cook</goal>    
            </goals> 
            <configuration>
                
                <!-- MANDATORY COOKER MAIN PROPERTIES -->
                    
                <!--suppress UnresolvedMavenProperty -->    
                <tags>@E2E</tags>    
                <stepDefPackage>stepDefs</stepDefPackage>    
                <templatePath>${project.basedir}\src\main\resources\templates\TestRunnerTemplate.template</templatePath>    
                <featuresPath>${project.basedir}\src\test\features</featuresPath>    
                <featureFilesGenDir>${project.basedir}\src\test\resources\generated\featureFiles\</featureFilesGenDir>    
                <testRunnersGenDir>${project.basedir}\src\test\java\generated\testRunners\</testRunnersGenDir>    
                
                <!-- OPTIONAL COOKER MAIN PROPERTIES -->
                
                <customPlaceHolders>    
                    <progAuthor>Manjunath</progAuthor>    
                </customPlaceHolders>    
            </configuration>
          
         </execution>  
         
         <executions>    
            <execution>    
            <id>cooker-reporter-plugin</id> 	       
            <phase>post-integration-test</phase>
            <goals>    
                <goal>cook-report</goal>    
            </goals> 
            <configuration>
                
                <!-- MANDATORY COOKER REPORTER PROPERTIES -->
                      
                <jsonPath>${project.build.directory}\cucumber-reports</jsonPath>    
                
            </configuration>
          
         </execution>  
  
       </executions>
         
  </plugin>   
  ```  

Pick the latest Dependencies from Maven Central and Add to your POM.xml under `<build>` section  
 
 
 >Note : Please use it with Surefire Plugin / Failsafe Plugin. Example for Surefire Given Below
 
 
```xml
 <plugin>
     <groupId>org.apache.maven.plugins</groupId>
     <artifactId>maven-surefire-plugin</artifactId>
     <version>3.0.0-M4</version>
     <configuration>
        <testFailureIgnore>true</testFailureIgnore> <!-- Optional, To not fail the build if any test failure, so our cooker reporter can run -->
        <!--  <parallel>all</parallel>-->
        <useUnlimitedThreads>true</useUnlimitedThreads>
        <useSystemClassLoader>false</useSystemClassLoader>
        <forkCount>1</forkCount>
        <reuseForks>true</reuseForks>
        <parallel>methods</parallel>
        <!-- <parallel>classes</parallel>-->
        <!-- <threadCount>4</threadCount>-->
        <threadCount>1</threadCount> <!-- Number of Browser Instances-->
        <!-- <classesDirectory>-->
        <!--    src/test/java/TestRunners/-->
        <!-- </classesDirectory>-->
        <!-- <includes>-->
        <!--    <include>**/src/test/java/generated/testRunners/**.java</include>-->
        <!-- </includes>-->
        <suiteXmlFiles>
            <suiteXmlFile>TestNg.xml</suiteXmlFile>
        </suiteXmlFiles>
    </configuration>
    <executions>
        <execution>
            <goals>
                <goal>test</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```
---
 
## Template

Template is a blueprint of Test Runner Files stored in (*.template). Can be used with any Testing Framework wich supports Test Runner for BDD Cucumber.

### TestNG Template Format :

<pre>
package generated.testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = <b>[COOKER:FEATUREFILE]</b>, 
        glue = {<b>[COOKER:GLUE]</b>}, 
        plugin = {"pretty","json:target/cucumber-reports/<b>[COOKER:RUNNERCLASS]</b>.json"}, 
)
public class <b>[COOKER:RUNNERCLASS]</b> extends AbstractTestNGCucumberTests { 

    //Created : <b>[COOKER:TIMESTAMP]</b>  
    //Triggered By : <b>[COOKER:PROGAUTHOR]</b> 

}
 
//Plugin Created by : <b>[COOKER:PLUGIN_OWNER]</b>
</pre>

### JUnit Template Format :  
   
<pre>
package com.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = <b>[COOKER:FEATUREFILE]</b>, 
        glue = {<b>[COOKER:GLUE]</b>}, 
        plugin = {"pretty","json:target/cucumber-reports/<b>[COOKER:RUNNERCLASS]</b>.json"}, 
)
public class <b>[COOKER:RUNNERCLASS]</b> {
     //Created : <b>[COOKER:TIMESTAMP]</b>  
     //Triggered By : <b>[COOKER:PROGAUTHOR]</b>
}

//Plugin Created by : <b>[COOKER:PLUGIN_OWNER]</b>
</pre>   

### Note on Place Holder :    

1. Plugin placeholder

| Place Holder | Usage Type | data          | Example After Replacing |
|-------------|:-----:|:---:|:------------:|   
|[COOKER:FEATUREFILE]| mandatory| replaced with generated feature file name| absolutepath:Login_Test_Feature_JI9876.feature |
|[COOKER:GLUE]| mandatory | replaced with data passed in `stepDefPackage`| "stepDefs" |
|[COOKER:RUNNERCLASS]| mandatory |  replaced with generated feature file name| Login_Test_Feature_JI9876
|[COOKER:TIMESTAMP]| optional | replaced with timestamp of when the actual runner is created| Thu Sep 24 11:35:58 IST 2020 |
|[COOKER:PLUGIN_OWNER]|optional| reaplaced with plugin owner name | Manjunath Prabhakar |

2. Custom Placeholder(s)

Passed in POM as below
```xml
<customPlaceHolders>    
    <progAuthor>Manjunath</progAuthor>    
</customPlaceHolders>  
```
Usage : `[COOKER:PROGAUTHOR]` will be replaced with `Manjunath`- 

---

## Usage of Data from Files for Scenario Outline

> Use Below @excel/@csv/@plain as Scenario Tags for Scenario outline

### Excel File (Supports *.xlsx & *xls only)

**Syntax** : `@excel=path=fileNameWithExtension=sheetName`

Example # 1 :
 
`@excel=root=myExcelData.xlsx=userData`

here,
Path is root, Therefore project root is taken

Example # 2 :
 
`@excel=D:\MyDataFactory=book.xlsx=Sheet1`

here,
Path is not root, Therefore specified path is taken

### CSV File (Supports *.csv with delimiter(comma/semi-colon/pipe))

**Syntax** : `@csv=path=fileNameWithExtension=delimiter`

Example # 1 :
 
`@csv=root=myCSVdata.csv=,`

### Text File (Supports *.txt with Exact Copy like Examples)

**Syntax** : `@plain=path=fileNameWithExtension`

Example # 1 :
 
`@plain=root=myExampleData.txt`

---

## Example Project

Please check out [this example]() for Complete Example on Usage of this Plugin 

---

## Appendix

### Limitations

>**This Plugin uses Gherkin Dependency 5.2.0, Doesn't Support RULE in feature file**   
##### For newer version of Gherkin features please refer new plugin : [Click Here](https://github.com/ManjunathPrabhakar/cooker-new-version/)  

### Version

Developed with Below Tools & Version(s):

**Technical Stack**

1. Java >= v7
2. Maven >= v3.6.3
3. IntelliJ Community Edition >= v2020
4. Git >= v2.27.0

### License

© Copyright 2020 [Manjunath Prabhakar](manjunath189@gmail.com)

This plugin uses [Apache License,Version 2.0](LICENSE)
You may use this feature as per the license and provide credits for the Developer.
This Software is distributed under the License and is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.

### Credits



<p>
Thank you <a href="#" alt="maven-release-version">    
        <img width="30" height="30" src="https://www.shareicon.net/data/256x256/2017/06/05/886723_heart_512x512.png" /></a>
</p>


- [StackEdit](https://github.com/benweet/stackedit) for helping to edit markdown files.
- [Benjamin Bischoff](https://github.com/laxersaz) for inspiring to develop this plugin.  

---