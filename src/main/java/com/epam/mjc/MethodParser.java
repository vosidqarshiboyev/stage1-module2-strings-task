package com.epam.mjc;

import java.util.Arrays;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        MethodSignature methodSignature;
        System.out.println(signatureString);
        String mofifiers="publicprivateprotected";
        List<String>list= Arrays.asList(signatureString.split(" "));
        System.out.println(list);
        if(!mofifiers.contains(list.get(0))){
            methodSignature=new MethodSignature(list.get(1).trim().substring(0,list.get(1).indexOf("(")));
            methodSignature.setMethodName(list.get(1).trim().substring(0,list.get(1).indexOf("(")));
            methodSignature.setReturnType(list.get(0));
            methodSignature.setAccessModifier(null);
            return methodSignature;
        }
        else{
            methodSignature=new MethodSignature(list.get(2).trim().substring(0,list.get(2).indexOf("(")));
            methodSignature.setAccessModifier(list.get(0));
            methodSignature.setReturnType(list.get(1));
            methodSignature.setMethodName(list.get(2).trim().substring(0,list.get(2).indexOf("(")));
            return methodSignature;

        }
    }
    public static void main(String args[]){
        MethodParser m=new MethodParser();
        m.parseFunction("String repeat(String value, int times)");

    }
}
