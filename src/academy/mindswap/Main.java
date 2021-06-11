package academy.mindswap;

import academy.mindswap.db.DB;

import java.time.Year;


public class Main {

    public static void main(String[] args) {

        EmployeeAnalyzer analyzer = new EmployeeAnalyzer();
        //4
        int year = Year.now().getValue();
        System.out.println(analyzer.countEmployeesByWorkAgeMoreThan(DB.getHrDepartment(), year, 4));
        //Reina Hopkins
        System.out.println(analyzer.getEmployeesNameBySalaryAboveOrEqual(DB.getHrDepartment(), 1500));
        //Reina,Brian,Frank
        System.out.println(analyzer.getOldestNEmployees(DB.getHrDepartment(), 3));
        //Edna Heller
        System.out.println(analyzer.getFirstEmployeeOlderThan(DB.getHrDepartment(), 24));
        //1327.7777777777778
        System.out.println(analyzer.getAverageSalary(DB.getHrDepartment()));
        //James, Mary
        System.out.println(analyzer.findCommonNamesInDepartments(DB.getHrDepartment(), DB.getSalesDepartment()));
    }
}
