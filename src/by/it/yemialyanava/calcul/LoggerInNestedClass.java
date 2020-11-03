package by.it.yemialyanava.calcul;

 class LoggerInNestedClass {

        static class SingletonHolder {
            public static final LoggerInNestedClass HOLDER_INSTANCE = new LoggerInNestedClass();
        }

         static LoggerInNestedClass getInstance() {

            return SingletonHolder.HOLDER_INSTANCE;
        }
}
