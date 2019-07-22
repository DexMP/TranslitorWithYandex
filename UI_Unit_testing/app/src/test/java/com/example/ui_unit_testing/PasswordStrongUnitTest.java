package com.example.ui_unit_testing;

import android.util.Log;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * create by DexMP
 */
public class PasswordStrongUnitTest {
    @Test
    public void addition_isCorrect() {
        /*Стандартная проверка того что 2 + 2 = 4, используется для проверки работы самих юнит тестов, если не работает, то беда(((*/
        assertEquals(4, 2 + 2);
    }

    @Test
    public void passwordIsStrong() {
        try {
            //Проверка на длину пароля
            assertFalse(Registration.isStrongPassword("A1"));

            //Проверка на содержание букв
            assertFalse(Registration.isStrongPassword("23123"));

            //Проверка на содержание цифр
            assertFalse(Registration.isStrongPassword("fffhhfhfhfhf"));

            //Проверка на отсутствие пробелов
            assertFalse(Registration.isStrongPassword("Friday 100801"));

            //Проверка на принятие правильного значения
            assertTrue(Registration.isStrongPassword("Friday100801"));

        } catch (Exception e){

            /*Если вдруг падает функция выведет сообщение в логи почему упало*/
            Log.println(1, "Password don't strong", e.getMessage());
        }
    }
}