# Introduction #

You need to download [scriptella](http://scriptella.javaforge.com/download.html), [sqlsheet driver](http://code.google.com/p/sqlsheet/downloads) and it's [dependencies](HowToGetDependecies.md).


# Details #

Follow the steps:
  * Download [scriptella](http://scriptella.javaforge.com/download.html) binary distribution
  * Unpack it and add a ${SCRIPTELLA\_DIR}/bin to a system PATH variable
    1. Use set PATH=%PATH%;SCRIPTELLA\_DIR\bin for Windows
    1. Use export PATH=${PATH}:SCRIPTELLA\_DIR/bin for Unix
  * Check if JRE has been installed correctly by running:
```
java -version 
```
  * Check if scriptella has been installed correctly by running:
```
scriptella -version 
```
  * Put [sqlsheet](http://code.google.com/p/sqlsheet/downloads) driver to  the ${SCRIPTELLA\_DIR}/lib directory
  * Put sqlsheet driver [dependencies](HowToGetDependecies.md) to the ${SCRIPTELLA\_DIR}/lib directory
  * Put [janino.jar](http://dist.codehaus.org/janino/changelog.html) and [commons-compiler.jar](http://dist.codehaus.org/janino/changelog.html) to the ${SCRIPTELLA\_DIR}/lib directory
  * Download [test](http://code.google.com/p/sqlsheet/downloads/detail?name=xls_test.xml) script
  * Execute test script:
```
scriptella xls_test.xml 
```
  * Check generated XLS/XLSX files
  * Enjoy!