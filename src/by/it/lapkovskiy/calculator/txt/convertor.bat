set path=C:\Program Files\Java\jdk1.8.0_181\bin
FOR %%I In (*.txt) DO (
native2ascii -encoding utf-8 %%I ../res/%%~nI.properties
)