package by.it.siarheikorbut.jd01_13;

/**
 * @author Siarhei Korbut
 * @see <a href="https://drive.google.com/file/d/1iSvqfSRLpPRwyPEKEaOLIa3-qSPVhXv5/view?usp=sharing">Задание JD01_13</a>
 */

class ArithmeticException extends Exception {

    public ArithmeticException() {
    }

    public ArithmeticException(String message) {
        super(message);
    }

    public ArithmeticException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArithmeticException(Throwable cause) {
        super(cause);
    }

    public ArithmeticException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}