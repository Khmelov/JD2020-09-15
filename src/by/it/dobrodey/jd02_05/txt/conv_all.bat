REM Universal convertor (for new txt)
REM set JDK8 Path for this file
set path="C:\Users\Olga\.jdks\adopt-openjdk-1.8.0_265\bin"

D:\java\students\JD2020-09-15\src\by\it\dobrodey\jd02_05\txt>
REM find and convert all *.txt files
FOR %%I In (*.txt) DO (
native2ascii.exe -encoding utf-8 %%I ../resources/%%~nI.properties
)
