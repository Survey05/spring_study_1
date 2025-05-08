package com.example.spring_test.common;

public class Constants {

    public enum ExceptionClass {

        PRODUCT("product"), ORDER("Oreder"), PROVIDER("Provider");

        private String exceptionClass;

        ExceptionClass(String exceptionClass) { this.exceptionClass = exceptionClass; }

        public String getExceptionClass() { return exceptionClass; }

        @Override
        public String toString() { return getExceptionClass() + " Exception. "; }

    }

}
