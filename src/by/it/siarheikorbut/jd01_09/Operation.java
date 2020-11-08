package by.it.siarheikorbut.jd01_09;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1C-wHpUcHtxb-Qq0lfyExNQsYeKr3yIPh/view?usp=sharing">Задание JD01_09</a>
 */


interface Operation {
    Var add(Var other);

    Var sub(Var other);

    Var mul(Var other);

    Var div(Var other);
}