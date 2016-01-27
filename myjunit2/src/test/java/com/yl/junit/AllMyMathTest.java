package com.yl.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Administrator on 2015/11/16.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({MyMathTest.class, MyMathParamTest.class})
public class AllMyMathTest {
}
