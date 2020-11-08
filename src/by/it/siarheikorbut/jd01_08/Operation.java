package by.it.siarheikorbut.jd01_08;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1jYVzPAxyV5XrFvrWvf-DEkSx9feVHEDz/view?usp=sharing">Задание JD01_08</a>
 */

interface Operation {
    Var add(Var other);

    Var sub(Var other);

    Var mul(Var other);

    Var div(Var other);

    String getYourClass(Var other);
}