package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;
import android.test.ApplicationTestCase;

import org.mockito.Mock;

import java.util.concurrent.TimeUnit;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    EndpointsAsyncTask task;
    String result;
    @Mock
    Context mockContext;
    public ApplicationTest() {

        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        result = null;
        task = new EndpointsAsyncTask(){
            @Override
            protected void onPostExecute(String joke){
            }
        };
    }
    public void testAsyncReturnType() {

        try{
            task.execute(mockContext);
            result = task.get(10, TimeUnit.SECONDS);


        }catch (Exception e){
            fail("Timed out");
        }
        assertNotNull(result);
    }
}