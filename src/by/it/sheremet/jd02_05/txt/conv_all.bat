REM Universal convertor (for new txt)
REM set JDK8 Path for this file
PATH=E:\Java\jdk1.8.0_144\bin

REM find and convert all *.txt files
FOR %%I In (*.txt) DO (
native2ascii.exe -encoding utf-8 %%I ../resources/%%~nI.properties
)
