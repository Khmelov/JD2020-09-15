package by.it.hutnik.jd01_03;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.junit.Assert.*;

@SuppressWarnings("all")

//РїРѕСЃС‚Р°РІСЊС‚Рµ РєСѓСЂСЃРѕСЂ РЅР° СЃР»РµРґСѓСЋС‰СѓСЋ СЃС‚СЂРѕРєСѓ Рё РЅР°Р¶РјРёС‚Рµ Ctrl+Shift+F10
public class Test_jd01_03 {

    @Test(timeout = 5000)
    public void testTaskA1__InOut() throws Exception {
        Test_jd01_03 ok = run("", false);
        checkMethod(ok.aClass.getSimpleName(), "static getArray", String.class);
        double[] expArr = {0.1, 0.2, -0.2, -0.1};
        Method m = ok.aClass.getDeclaredMethod("getArray", String.class);
        System.out.println("РџСЂРѕРІРµСЂРєР° РІРІРѕРґР° РґР»СЏ РјР°СЃСЃРёРІР° РІРёРґР°:");
        System.out.println("0.1 0.2 -0.2 -0.1");
        double[] arr = (double[]) ok.invoke(m, null, new Object[]{"0.1 0.2 -0.2 -0.1"});
        assertArrayEquals("РќРµРІРµСЂРЅРѕ СЂР°Р±РѕС‚Р°РµС‚ РІРІРѕРґ", expArr, arr, 1e-9);
        System.out.println("РџСЂРѕРІРµСЂРєР° РІРІРѕРґР° РґР»СЏ РјР°СЃСЃРёРІР° Р·Р°РІРµСЂС€РµРЅР° СѓСЃРїРµС€РЅРѕ");
    }

    @Test(timeout = 5000)
    public void testTaskA2_printSimple__InOut() throws Exception {
        Test_jd01_03 ok = run("", false);
        checkMethod(ok.aClass.getSimpleName(), "static printArray", double[].class);
        Method m = ok.aClass.getDeclaredMethod("printArray", double[].class);
        System.out.println("РџСЂРѕРІРµСЂРєР° РІС‹РІРѕРґР° РґР»СЏ РјР°СЃСЃРёРІР°:");
        double[] arr = {1, 2, 3, 4};
        ok.invoke(m, null, new Object[]{arr});
        for (double a : arr) {
            //РїРµСЂРµРІРѕРґ РІ Integer С‚.Рє. Р·Р°СЂР°РЅРµРµ РЅРµРёР·РІРµСЃС‚РЅРѕ СЃ printf РёР»Рё РїСЂСЏРјРѕ Р±СѓРґРµС‚ СЃРґРµР»Р°РЅ РІС‹РІРѕРґ
            ok.include(Integer.toString((int) a));
        }
        System.out.println("РџСЂРѕРІРµСЂРєР° РІС‹РІРѕРґР° РґР»СЏ РјР°СЃСЃРёРІР° Р·Р°РІРµСЂС€РµРЅР° СѓСЃРїРµС€РЅРѕ");
    }

    @Test(timeout = 5000)
    public void testTaskA3_printWithNameAndCol__InOut() throws Exception {
        Test_jd01_03 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static printArray", double[].class, String.class, int.class);
        System.out.println("РџСЂРѕРІРµСЂРєР° РІС‹РІРѕРґР° РґР»СЏ РјР°СЃСЃРёРІР°:");
        double[] arr = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        ok.invoke(m, null, arr, "Massiv", 2);
        System.out.println("\n\nFind out with printf for:");
        for (double a : arr) {
            //РїРµСЂРµРІРѕРґ РІ Integer С‚.Рє. Р·Р°СЂР°РЅРµРµ РЅРµРёР·РІРµСЃС‚РЅРѕ СЃ printf РёР»Рё РїСЂСЏРјРѕ Р±СѓРґРµС‚ СЃРґРµР»Р°РЅ РІС‹РІРѕРґ
            String sf = String.format("%.1f", a);
            System.out.print(sf + " | ");
            ok.include(sf);
        }
        System.out.println("\nCheck printf ok");
        ok.include("\n").include("Massiv");
        System.out.println("РџСЂРѕРІРµСЂРєР° РІС‹РІРѕРґР° РґР»СЏ РјР°СЃСЃРёРІР° Р·Р°РІРµСЂС€РµРЅР° СѓСЃРїРµС€РЅРѕ");
        //С‚СѓС‚ РјРѕР¶РЅРѕ РїСЂРѕРІРµСЂРєСѓ РЅР° С‡РёСЃР»Рѕ РєРѕР»РѕРЅРѕРє СЃРґРµР»Р°С‚СЊ, РЅРѕ СЌС‚Рѕ РЅРµ С„Р°РєС‚, С‡С‚Рѕ Р±СѓРґРµС‚ РїСЂРѕСЃС‚Рѕ
    }

    @Test(timeout = 5000)
    public void testTaskB1_findMin__Helper() throws Exception {
        Test_jd01_03 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static findMin", double[].class);
        double[] arr = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        double min = (double) ok.invoke(m, null, arr);
        Arrays.sort(arr);
        assertEquals("РњРёРЅРёРјСѓРј РЅР°Р№РґРµРЅ РЅРµРІРµСЂРЅРѕ", arr[0], min, 1e-10);
    }

    @Test(timeout = 5000)
    public void testTaskB2_findMax__Helper() throws Exception {
        Test_jd01_03 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static findMax", double[].class);
        double[] arr = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        double min = (double) ok.invoke(m, null, arr);
        Arrays.sort(arr);
        assertEquals("РњР°РєСЃРёРјСѓРј РЅР°Р№РґРµРЅ РЅРµРІРµСЂРЅРѕ", arr[arr.length - 1], min, 1e-10);
    }

    @Test(timeout = 5000)
    public void testTaskB3_sort__Helper() throws Exception {
        Test_jd01_03 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static sort", double[].class);
        double[] arr = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        double[] sorted = {0.1, 0.2, -0.2, -0.1, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        System.out.println("РСЃС…РѕРґРЅС‹Р№  РјР°СЃСЃРёРІ:" + Arrays.toString(arr));
        Arrays.sort(sorted);
        System.out.println("РћР¶РёРґР°РµС‚СЃСЏ РјР°СЃСЃРёРІ:" + Arrays.toString(sorted));
        ok.invoke(m, null, arr);
        System.out.println("  РџРѕР»СѓС‡РµРЅ РјР°СЃСЃРёРІ:" + Arrays.toString(arr));
        assertArrayEquals("РќРµРІРµСЂРЅРѕ СЂР°Р±РѕС‚Р°РµС‚ СЃРѕСЂС‚РёСЂРѕРІРєР°", sorted, arr, 1e-9);
        System.out.println("OK. РњР°СЃСЃРёРІ РѕС‚СЃРѕСЂС‚РёСЂРѕРІР°РЅ");
    }

    @Test(timeout = 5000)
    public void testTaskC1_mulMatrixAndVector__Helper() throws Exception {
        Test_jd01_03 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static mul", double[][].class, double[].class);
        System.out.println("РџСЂРѕРІРµСЂРёРј РїСЂРѕРёР·РІРµРґРµРЅРёРµ РјР°С‚СЂРёС†С‹ Рё РІРµРєС‚РѕСЂР°");
        double[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        double[] vector = {1, 2, 3};
        double[] res = (double[]) ok.invoke(m, null, matrix, vector);
        double[] exp = {
                1 * 1 + 2 * 2 + 3 * 3,
                4 * 1 + 5 * 2 + 6 * 3
        };
        System.out.println("{{1,2,3},{4,5,6}}*{1,2,3}={14,32}");
        System.out.println("РћР¶РёРґР°РµС‚СЃСЏ РјР°СЃСЃРёРІ " + Arrays.toString(exp));
        assertArrayEquals("РџСЂРѕРёР·РІРµРґРµРЅРёРµ РЅР°Р№РґРµРЅРѕ РЅРµРІРµСЂРЅРѕ", exp, res, 1e-10);
        System.out.println("РџСЂРѕРІРµСЂРєР° Р·Р°РІРµСЂС€РµРЅР° СѓСЃРїРµС€РЅРѕ.");
    }


    @Test(timeout = 5000)
    public void testTaskC2_mulMatrixAndMatrix__Helper() throws Exception {
        Test_jd01_03 ok = run("", false);
        Method m = checkMethod(ok.aClass.getSimpleName(), "static mul", double[][].class, double[][].class);
        System.out.println("РџСЂРѕРІРµСЂРёРј РїСЂРѕРёР·РІРµРґРµРЅРёРµ РјР°С‚СЂРёС†С‹ Рё РјР°С‚СЂРёС†С‹");
        double[][] left = {
                {1, 2, 3},
                {4, 5, 6}
        };

        double[][] right = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        double[][] res = (double[][]) ok.invoke(m, null, left, right);
        double[][] exp = {
                {22, 28},
                {49, 64}
        };
        System.out.println("{{1,2,3},{4,5,6}}*{{1,2},{3,4},{5,6}}={{22,28},{49,64}}");
        for (int i = 0; i < exp.length; i++) {
            System.out.println("РћР¶РёРґР°РµС‚СЃСЏ:  " + Arrays.toString(exp[i]));
            System.out.println("Р Р°СЃСЃС‡РёС‚Р°РЅРѕ: " + Arrays.toString(res[i]));
            assertArrayEquals("РџСЂРѕРёР·РІРµРґРµРЅРёРµ РЅР°Р№РґРµРЅРѕ РЅРµРІРµСЂРЅРѕ", exp[i], res[i], 1e-10);
        }
        System.out.println("\nРџСЂРѕРІРµСЂРєР° Р·Р°РІРµСЂС€РµРЅР° СѓСЃРїРµС€РЅРѕ.");
    }


    /*
===========================================================================================================
РќРР–Р• Р’РЎРџРћРњРћР“РђРўР•Р›Р¬РќР«Р™ РљРћР” РўР•РЎРўРћР’. РќР• РњР•РќРЇР™РўР• Р’ Р­РўРћРњ Р¤РђР™Р›Р• РќРР§Р•Р“Рћ.
РќРѕ РёР·СѓС‡РёС‚СЊ РєР°Рє РѕРЅ СЂР°Р±РѕС‚Р°РµС‚ - РјРѕР¶РЅРѕ, СЌС‚Рѕ РІСЃРµРіРґР° Р±СѓРґРµС‚ РїРѕР»РµР·РЅРѕ.
===========================================================================================================
 */
    //-------------------------------  РјРµС‚РѕРґС‹ ----------------------------------------------------------
    private Class findClass(String SimpleName) {
        String full = this.getClass().getName();
        String dogPath = full.replace(this.getClass().getSimpleName(), SimpleName);
        try {
            return Class.forName(dogPath);
        } catch (ClassNotFoundException e) {
            fail("\nERROR:РўРµСЃС‚ РЅРµ РїСЂРѕР№РґРµРЅ. РљР»Р°СЃСЃ " + SimpleName + " РЅРµ РЅР°Р№РґРµРЅ.");
        }
        return null;
    }

    private Method checkMethod(String className, String methodName, Class<?>... parameters) throws Exception {
        Class aClass = this.findClass(className);
        try {
            methodName = methodName.trim();
            Method m;
            if (methodName.startsWith("static")) {
                methodName = methodName.replace("static", "").trim();
                m = aClass.getDeclaredMethod(methodName, parameters);
                if ((m.getModifiers() & Modifier.STATIC) != Modifier.STATIC) {
                    fail("\nERROR:РњРµС‚РѕРґ " + m.getName() + " РґРѕР»Р¶РµРЅ Р±С‹С‚СЊ СЃС‚Р°С‚РёС‡РµСЃРєРёРј");
                }
            } else
                m = aClass.getDeclaredMethod(methodName, parameters);
            m.setAccessible(true);
            return m;

        } catch (NoSuchMethodException e) {
            System.err.println("\nERROR:РќРµ РЅР°Р№РґРµРЅ РјРµС‚РѕРґ " + methodName + " Р»РёР±Рѕ Сѓ РЅРµРіРѕ РЅРµРІРµСЂРЅР°СЏ СЃРёРіРЅР°С‚СѓСЂР°");
            System.err.println("ERROR:РћР¶РёРґР°РµРјС‹Р№ РєР»Р°СЃСЃ: " + className);
            System.err.println("ERROR:РћР¶РёРґР°РµРјС‹Р№ РјРµС‚РѕРґ: " + methodName);
            return null;
        }
    }

    private Method findMethod(Class<?> cl, String name, Class... param) {
        try {
            return cl.getDeclaredMethod(name, param);
        } catch (NoSuchMethodException e) {
            fail("\nERROR:РўРµСЃС‚ РЅРµ РїСЂРѕР№РґРµРЅ. РњРµС‚РѕРґ " + cl.getName() + "." + name + " РЅРµ РЅР°Р№РґРµРЅ\n");
        }
        return null;
    }

    private Object invoke(Method method, Object o, Object... value) {
        try {
            method.setAccessible(true);
            return method.invoke(o, value);
        } catch (Exception e) {
            System.out.println(e.toString());
            fail("\nERROR:РќРµ СѓРґР°Р»РѕСЃСЊ РІС‹Р·РІР°С‚СЊ РјРµС‚РѕРґ " + method.getName() + "\n");
        }
        return null;
    }


    //РјРµС‚РѕРґ РЅР°С…РѕРґРёС‚ Рё СЃРѕР·РґР°РµС‚ РєР»Р°СЃСЃ РґР»СЏ С‚РµСЃС‚РёСЂРѕРІР°РЅРёСЏ
    //РїРѕ РёРјРµРЅРё РІС‹Р·С‹РІР°СЋС‰РµРіРѕ РµРіРѕ РјРµС‚РѕРґР°, testTaskA1 Р±СѓРґРµС‚ СЂР°Р±РѕС‚Р°С‚СЊ СЃ TaskA1
    private static Test_jd01_03 run(String in) {
        return run(in, true);
    }

    private static Test_jd01_03 run(String in, boolean runMain) {
        Throwable t = new Throwable();
        StackTraceElement trace[] = t.getStackTrace();
        StackTraceElement element;
        int i = 0;
        do {
            element = trace[i++];
        }
        while (!element.getMethodName().contains("test"));

        String[] path = element.getClassName().split("\\.");
        String nameTestMethod = element.getMethodName();
        String clName = nameTestMethod.replace("test", "");
        clName = clName.replaceFirst(".+__", "");
        clName = element.getClassName().replace(path[path.length - 1], clName);
        System.out.println("\n---------------------------------------------");
        System.out.println("РЎС‚Р°СЂС‚ С‚РµСЃС‚Р° РґР»СЏ " + clName);
        if (!in.isEmpty()) System.out.println("input:" + in);
        System.out.println("---------------------------------------------");
        return new Test_jd01_03(clName, in, runMain);
    }

    //-------------------------------  С‚РµСЃС‚ ----------------------------------------------------------
    public Test_jd01_03() {
        //РљРѕРЅСЃС‚СЂСѓРєС‚РѕСЂ С‚РµСЃС‚РѕРІ
    }

    //РїРµСЂРµРјРµРЅРЅС‹Рµ С‚РµСЃС‚Р°
    private String className;
    private Class<?> aClass;
    private PrintStream oldOut = System.out; //РёСЃС…РѕРґРЅС‹Р№ РїРѕС‚РѕРє РІС‹РІРѕРґР°
    private PrintStream newOut; //РїРѕР»Рµ РґР»СЏ РїРµСЂРµС…РІР°С‚Р° РїРѕС‚РѕРєР° РІС‹РІРѕРґР°
    private StringWriter strOut = new StringWriter(); //РЅР°РєРѕРїРёС‚РµР»СЊ СЃС‚СЂРѕРєРё РІС‹РІРѕРґР°

    //РћСЃРЅРѕРІРЅРѕР№ РєРѕРЅСЃС‚СЂСѓРєС‚РѕСЂ С‚РµСЃС‚РѕРІ
    private Test_jd01_03(String className, String in, boolean runMain) {
        //this.className = className;
        aClass = null;
        try {
            aClass = Class.forName(className);
            this.className = className;

        } catch (ClassNotFoundException e) {
            fail("ERROR:РќРµ РЅР°Р№РґРµРЅ РєР»Р°СЃСЃ " + className + "/n");
        }
        InputStream reader = new ByteArrayInputStream(in.getBytes());
        System.setIn(reader);   //РїРµСЂРµС…РІР°С‚ СЃС‚Р°РЅРґР°СЂС‚РЅРѕРіРѕ РІРІРѕРґР°
        System.setOut(newOut);  //РїРµСЂРµС…РІР°С‚ СЃС‚Р°РЅРґР°СЂС‚РЅРѕРіРѕ РІС‹РІРѕРґР°

        if (runMain) //РµСЃР»Рё РЅСѓР¶РЅРѕ Р·Р°РїСѓСЃРєР°С‚СЊ, С‚Рѕ Р·Р°РїСѓСЃС‚РёРј, РёРЅР°С‡Рµ РѕСЃС‚Р°РІРёРј С‚РѕР»СЊРєРѕ РІС‹РІРѕРґ
            try {
                Class[] argTypes = new Class[]{String[].class};
                Method main = aClass.getDeclaredMethod("main", argTypes);
                main.invoke(null, (Object) new String[]{});
                System.setOut(oldOut); //РІРѕР·РІСЂР°С‚ РІС‹РІРѕРґР°, РЅСѓР¶РµРЅ, С‚РѕР»СЊРєРѕ РµСЃР»Рё Р±С‹Р» Р·Р°РїСѓСЃРє
            } catch (Exception x) {
                x.printStackTrace();
            }
    }

    //РїСЂРѕРІРµСЂРєР° РІС‹РІРѕРґР°
    private Test_jd01_03 is(String str) {
        assertTrue("ERROR:РћР¶РёРґР°РµС‚СЃСЏ С‚Р°РєРѕР№ РІС‹РІРѕРґ:\n<---РЅР°С‡Р°Р»Рѕ---->\n" + str + "<---РєРѕРЅРµС†--->",
                strOut.toString().equals(str));
        return this;
    }

    private Test_jd01_03 include(String str) {
        assertTrue("ERROR:РЎС‚СЂРѕРєР° РЅРµ РЅР°Р№РґРµРЅР°: " + str + "\n", strOut.toString().contains(str));
        return this;
    }

    private Test_jd01_03 exclude(String str) {
        assertTrue("ERROR:Р›РёС€РЅРёРµ РґР°РЅРЅС‹Рµ РІ РІС‹РІРѕРґРµ: " + str + "\n", !strOut.toString().contains(str));
        return this;
    }


    //Р»РѕРіРёС‡РµСЃРєРёР№ Р±Р»РѕРє РїРµСЂРµС…РІР°С‚Р° РІС‹РІРѕРґР°
    {
        newOut = new PrintStream(new OutputStream() {
            private byte bytes[] = new byte[1];
            private int pos = 0;

            @Override
            public void write(int b) throws IOException {
                if (pos==0 && b=='\r') //РїСЂРѕРїСѓСЃРє \r (С‡С‚РѕР±С‹ win mac Рё linux РѕРґРёРЅР°РєРѕРІРѕ СЂР°Р±РѕС‚Р°Р»Рё
                    return;
                if (pos == 0) { //РѕРїСЂРµРґРµР»РёРј РєРѕРґРёСЂРѕРІРєСѓ https://ru.wikipedia.org/wiki/UTF-8
                    if ((b & 0b11110000) == 0b11110000) bytes = new byte[4];
                    else if ((b & 0b11100000) == 0b11100000) bytes = new byte[3];
                    else if ((b & 0b11000000) == 0b11000000) bytes = new byte[2];
                    else bytes = new byte[1];
                }
                bytes[pos++] = (byte) b;
                if (pos == bytes.length) { //СЃРёРјРІРѕР» РіРѕС‚РѕРІ
                    String s = new String(bytes); //СЃРѕР±РµСЂРµРј РІРµСЃСЊ СЃРёРјРІРѕР»
                    strOut.append(s); //Р·Р°РїРѕРјРЅРёРј РІС‹РІРѕРґ РґР»СЏ С‚РµСЃС‚Р°
                    oldOut.append(s); //РєРѕРїРёСЋ РІ РѕР±С‹С‡РЅС‹Р№ РІС‹РІРѕРґ
                    pos = 0; //РіРѕС‚РѕРІРёРј РЅРѕРІС‹Р№ СЃРёРјРІРѕР»
                }

            }
        });
    }
}
