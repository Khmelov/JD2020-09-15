package by.it.fedorinhyk.calc;

interface Operation {
    CreateVar add(CreateVar other) throws CalcException;

    CreateVar sub(CreateVar other) throws CalcException;

    CreateVar mul(CreateVar other) throws CalcException;

    CreateVar div(CreateVar other) throws CalcException;
}