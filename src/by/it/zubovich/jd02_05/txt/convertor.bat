set path="c:\Users\maer1\.jdks\corretto-1.8.0_272\bin"

native2ascii -encoding utf-8 language.txt ../res/language.properties
native2ascii -encoding utf-8 language_be_BY.txt ../res/language_be_BY.properties
native2ascii -encoding utf-8 language_en_US.txt ../res/language_en_US.properties
native2ascii -encoding utf-8 language_ru_Ru.txt ../res/language_ru_Ru.properties
FOR %%I In (*.txt) DO (
native2ascii.exe -encoding utf-8 %%I ../res/%%~nI.properties
)
