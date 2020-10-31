package by.it.yemialyanava.calcul;

public interface MessagesNames {
    String UNKNOWN_VARIABLE = "unknownVariable";
    String FILE_ERROR = "fileError";
    String MISSING_FILE = "missingFile";
    String ABSTRACT_VAR = "abstractVar";
    String ERROR = "error";

    //Information about operations(+-*/)
    String ADD_IMPOSSIBLE = "addImpossible";
    String SUB_IMPOSSIBLE = "subImpossible";
    String MUL_IMPOSSIBLE = "mulImpossible";
    String DIV_IMPOSSIBLE = "divImpossible";
    String DIVISION_BY_ZERO = "divisionByZero";
    String ER_MUL_BY_ZERO = "erMulByZero";

    //Information about Matrix and Vectors
    String ERROR_VECTOR_MATRIX_LENGTH = "errorVectorMatrixLength";
    String EQUALITY_VECTORS_AND_MATRIX = "equalityVectorsAndMatrix";
    String ADD_VECTOR_AND_MATRIX = "addVectorAndMatrix";
    String SUB_MATRIX_FROM_VECTOR = "subMatrixFromVector";
    String MUL_VECTOR_BY_MATRIX = "mulVectorByMatrix";
    String DIVISION_VECTOR_BY_VECTOR_OR_VECTOR_BY_MATRIX = "divisionVectorByVectorOrVectorByMatrix";
    String ER_SUB_VECTOR_FROM_MATRIX = "erSubVectorFromMatrix";

    //Information about Matrix
    String DIVISION_WITH_MATRIX = "divisionWithMatrix";
    String ER_STRING_IN_MATRIX = "erStringInMatrix";
    String ER_ROW_IN_MATRIX = "erRowInMatrix";
    String ER_DIV_IN_MATRIX = "erDivInMatrix";

    //Information about Vectors
    String VECTORSLENGTH = "vectorsLength";
}
