package controller;

import service.EmployeeService;
import vo.EmployeeVO;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintAllController implements Controller {
    @Override
    public void execute(Scanner sc) {
        System.out.println("전체 사원 정보를 출력합니다......");
        ArrayList<EmployeeVO> list = EmployeeService.getInstance().getList();

        for (EmployeeVO vo : list){
            System.out.println(vo);
        }
        System.out.println();
    }
}
