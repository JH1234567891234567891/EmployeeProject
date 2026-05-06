package service;

import exception.EmployeeException;
import vo.EmployeeVO;

import java.io.*;
import java.util.ArrayList;

public class EmployeeService {
    private static EmployeeService instance = new EmployeeService();

    private ArrayList<EmployeeVO> list;

    private EmployeeService(){
        list = new ArrayList<>();
        //파일 로드해서 리스트에 초기화
        loadToCSV();
    }

    public ArrayList<EmployeeVO> getList() {
        return list;
    }

    private void loadToCSV() {
        try(FileReader fr = new FileReader("employee.csv");
            BufferedReader br = new BufferedReader(fr)) {
            br.readLine();//첫번째 줄인 필드 목록 미리 읽어서 건너뛰기
            while (true){
                String str = br.readLine();
                if(str == null) break;
//                System.out.println(str);
                String[] arr = str.split(",");
                list.add(new EmployeeVO(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]), arr[4]));
            }
            //사원 정보 로드 완료
            System.out.println("사원 정보 로드 완료");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void exportToCSV(){
        try (FileWriter fw = new FileWriter("employee.csv");
            PrintWriter pw = new PrintWriter(fw)) {

            list.forEach(item->pw.println(item.toString()));
            System.out.println("전체 사원 정보 저장 완료");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static EmployeeService getInstance() {
        if(instance == null) instance = new EmployeeService();
        return instance;
    }

    public void checkDuplicateEmployeeId(String id) throws EmployeeException{
//        id값만 넣기로 했으니 id값만으로 비교
        int idx = list.indexOf(new EmployeeVO(id,null,null,0,null));
        if(idx != -1) throw new EmployeeException("사원번호가 중복되었습니다.");

    }


    public boolean appendEmployee(EmployeeVO employeeVO) {
        return list.add(employeeVO);
    }

    public void deleteEmployee(String id) throws EmployeeException {
        if(! list.remove(new EmployeeVO(id,null,null,0,null)))
            throw new EmployeeException("삭제할 사원 정보가 없습니다.");
//        list.remove(list.stream().equals(id));

    }
}
