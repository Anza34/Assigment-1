/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.login;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Student
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class SignupTest {

    Signup signup = new Signup();

    @Test
    public void testUsernameCorrect() {
        assertTrue(signup.checkUserName("ky_l"));
    }

    @Test
    public void testUsernameIncorrect() {
        assertFalse(signup.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testPasswordComplexitySuccess() {
        assertTrue(signup.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordComplexityFailure() {
        assertFalse(signup.checkPasswordComplexity("password"));
    }

    @Test
    public void testPhoneNumberSuccess() {
        assertTrue(signup.checkCellPhoneNumber("+27838968976"));
    }
}