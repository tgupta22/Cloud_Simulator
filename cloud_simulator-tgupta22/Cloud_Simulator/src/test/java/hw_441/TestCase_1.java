package hw_441;


import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class TestCase_1 {

    /**
     * Below are the test cases that check and test different aspects of Cloud Simulation.
     * @throws Exception
     */


    @Test
    public void testhw1() throws  Exception{

        hw1 testCase = new hw1();
        String checking = testCase.checktest("Pass the Test Case");

        Assert.assertThat(checking, CoreMatchers.is("Pass"));
    }
    @Test
    public void testhw1_2() throws  Exception{

        hw1 testCase = new hw1();
        String checking_2 = testCase.checktest2("Pass the Test Case");

        Assert.assertThat(checking_2, CoreMatchers.is("Correct number of VM's"));
    }

    @Test
    public void testhw1_3() throws  Exception{

        hw1 testCase = new hw1();
        String checking_3 = testCase.checktest3("Pass the Test Case");

        Assert.assertThat(checking_3, CoreMatchers.is("Correct Number of Hosts"));
    }


    @Test
    public void testhw1_4() throws  Exception{

        hw1 testCase = new hw1();
        String checking_2 = testCase.checktest4("Pass the Test Case");

        Assert.assertThat(checking_2, CoreMatchers.is("Correct Number of Bandwidth"));
    }

    @Test
    public void testhw1_5() throws  Exception{

        hw1 testCase = new hw1();
        String checking_2 = testCase.checktest5("Pass the Test Case");

        Assert.assertThat(checking_2, CoreMatchers.is("Correct RAM"));
    }

    @Test
    public void testhw1_6() throws  Exception{

        hw1 testCase = new hw1();
        String checking_2 = testCase.checktest6("Pass the Test Case");

        Assert.assertThat(checking_2, CoreMatchers.is("Correct Memory Storage"));
    }

    @Test
    public void testhw1_7() throws  Exception{

        hw1 testCase = new hw1();
        String checking_2 = testCase.checktest7("Pass the Test Case");

        Assert.assertThat(checking_2, CoreMatchers.is("Correct RAM"));
    }



    @Test
    public void testhw1_8() throws  Exception{

        hw1 testCase = new hw1();
        String checking_2 = testCase.checktest8("Pass the Test Case");

        Assert.assertThat(checking_2, CoreMatchers.is("Correct PES"));
    }



}