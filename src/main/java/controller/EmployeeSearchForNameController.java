package controller;

import exception.EmployeeException;
import service.EmployeeService;
import vo.EmployeeVO;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeSearchForNameController implements Controller {
    @Override
    public void execute(Scanner sc) {
        System.out.println("사원 정보를 검색합니다.......");
        System.out.print("검색할 사원 이름 : ");
        String name = sc.nextLine();

        try {
//            ArrayList<EmployeeVO> list =
//                    EmployeeService.getInstance().searchForNameEmployee(name);
//            list.forEach(item -> System.out.println(item));

            EmployeeService.getInstance().searchForNameEmployee(name)
                    .forEach(item -> System.out.println(item));
        } catch (EmployeeException e) {
            System.out.println(e.getMessage());
        }

    }
}
