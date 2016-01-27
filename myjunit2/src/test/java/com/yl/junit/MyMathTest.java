package com.yl.junit;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2015/11/8.
 */
public class MyMathTest {

    private int beforeNum = 0;
    private int afterNum = 0;
    private static int s_beforeNum = 0;
    private static int s_afterNum = 0;

    public MyMathTest(){
        System.out.println("MyMathTest");
    }

    /*@BeforeClass
    public static void classMethodBefore(){
        System.out.println("classMethodBefore");
    }*/

    /*@BeforeClass
    public static void classMethodBefore2(){
        System.out.println("classMethodBefore2");
    }*/

    /*@AfterClass
    public static void classMethodAfter(){
        System.out.println("classMethodAfter");
    }*/

    /*@AfterClass
    public static void classMethodAfter2(){
        System.out.println("classMethodAfter2");
    }*/

    /*@Before
    public void setUp() throws Exception {
        ++beforeNum;
        System.out.println("beforeNum: " + beforeNum);
        ++s_beforeNum;
        System.out.println("s_beforeNum:" + s_beforeNum);
    }*/

    /*@Before
    public void setup2() throws Exception{
        System.out.println("setup2()");
    }*/

    /*@After
    public void tearDown() throws Exception {
        --afterNum;
        System.out.println("afterNum:" + afterNum);
        --s_afterNum;
        System.out.println("s_afterNum:" + s_afterNum);
    }*/

    /*@After
    public void tearDown2() throws Exception{
        System.out.println("tearDown2");
    }*/

    @Test
    public void testSum() throws Exception {

    }

    @Test
    public void testMinus() throws Exception {
        assertEquals(3, new MyMath().minus(5, 2));
    }

    /*@Ignore("testIgnore")
    public void testIgnore(){
        System.out.println("testIgnore");
    }*/

    @Ignore("testIgnore2")
    @Test
    public void testIgnore2(){
        System.out.println("testIgnore2");
    }

    @Test
    public void testDivision() throws Exception {
        assertEquals(4.0, new MyMath().division(8, 2), 0.000000001);
    }

    @Test(expected = Exception.class)
    public void testDivisionException() throws Exception {
        new MyMath().division(3, 0);
        fail("除数为0，但没抛出异常");
    }

    @Test(timeout = 4000)
    public void testDivisionTimeout(){
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}