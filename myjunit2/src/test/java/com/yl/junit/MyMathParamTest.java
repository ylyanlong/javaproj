package com.yl.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2015/11/16.
 */
@RunWith(Parameterized.class)
public class MyMathParamTest {
    private int param1;
    private int param2;
    private int result;

    public MyMathParamTest(int p_param1, int p_param2, int p_result){
        param1 = p_param1;
        param2 = p_param2;
        result = p_result;
    }

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
                {1, 3, 4},
                {2, 8, 10},
                {11, 5, 16}
        });
    }

    @Test
    public void testSum() throws Exception {
        assertEquals(result, new MyMath().sum(param1, param2) );
    }
}