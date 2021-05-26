package com.rakib.salarymanagement.util;

public final class UrlConstraint {
    private UrlConstraint() {
    }

    private static final String VERSION = "/v1";
    private static final String API = "/api";

    public static class BankManagement {
        public static final String ROOT = VERSION + API + "/banks";
        public static final String DELETE = "/{bankId}";
        public static final String GET = "/{bankId}";
        public static final String PUT = "/{bankId}";
    }

    public static class LowestSalaryManagement {
        public static final String ROOT = VERSION + API + "/lowestSalary";
        public static final String DELETE = "/{lowestSalaryId}";
        public static final String GET = "/{lowestSalaryId}";
        public static final String PUT = "/{lowestSalaryId}";

    }

    public static class EmployeeManagement {
        public static final String ROOT = VERSION + API + "/employee";
        public static final String DELETE = "/{employeeId}";
        public static final String GET = "/{employeeId}";
        public static final String PUT = "/{employeeId}";

    }
}
