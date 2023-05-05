package com.slager.dto;

import com.openpojo.reflection.*;
import com.openpojo.reflection.impl.*;
import com.openpojo.validation.*;
import com.openpojo.validation.test.impl.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class POJOTests {
    @Test
    public void testGettersSettersDTO(){
        //Arrange
        Validator validator = ValidatorBuilder.create().with(new SetterTester()).with(new GetterTester()).build();
        List<PojoClass> testClasses = PojoClassFactory.getPojoClasses("com.slager.dto", null);
        //Act

        //Assert
        validator.validate(testClasses);
    }
}
