# [실습 문제] 사원 관리 프로그램 (Employee Management System)

`StudentProject_ver3`의 아키텍처(Controller 패턴, 싱글톤, 인터페이스 활용)를 바탕으로, **Exception, List, SimpleDateFormat, Calendar**를 적용한 사원 관리 프로그램을 작성하세요.

## 1. 프로젝트 구조 및 패키지
- `vo.EmployeeVO`: 사원 정보를 담는 클래스
- `service.EmployeeService`: 사원 리스트 관리 및 비즈니스 로직 (싱글톤)
- `controller.Controller`: 인터페이스
- `controller.HandlerMapping`: 컨트롤러 생성 (싱글톤)
- `controller.*Controller`: 각 기능을 수행하는 구현체들
- `main.EmployeeMain`: 프로그램 실행부
- `exception.EmployeeException`: 사용자 정의 예외 클래스 (선택 사항)

## 2. 요구 사항 및 상세 설계

### ① vo.EmployeeVO (Value Object)
- **필드**: 
    - `String id` (사번 - 중복 불가, `final`)
    - `String name` (이름)
    - `String position` (직급: 사원, 대리, 과장, 부장 등)
    - `int salary` (연봉)
    - `Calendar hireDate` (입사일 - **java.util.Calendar 사용**)
- **메서드**:
    - 모든 필드를 초기화하는 생성자
    - Getter / `updateEmployee(name, position, salary)` 메서드
    - `printInfo()`: 사원 정보를 출력
    - `equals()`, `hashCode()` 오버라이딩 (사번 기준)

### ② service.EmployeeService (Singleton)
- `ArrayList<EmployeeVO>`를 사용하여 사원 데이터를 관리합니다.
- 생성자에서 샘플 데이터 3개 이상을 초기화하세요. (입사일 설정 시 `Calendar` 활용)

### ③ 핵심 기능 및 학습 포인트 적용

#### **[등록] EmployeeInsertController**
- 사번, 이름, 직급, 연봉을 입력받습니다.
- **SimpleDateFormat 활용**: 입사일을 `yyyy-MM-dd` 형식의 문자열로 입력받으세요.
- **Exception 처리**: 
    - `sc.nextLine()`으로 받은 문자열을 `SimpleDateFormat.parse()` 할 때 발생하는 `ParseException`을 `try-catch`로 처리하세요.
    - 예외 발생 시 "날짜 형식이 올바르지 않습니다 (yyyy-MM-dd). 다시 등록해주세요." 메시지를 출력하고 리턴하세요.

#### **[조회] EmployeeAllPrintController**
- 모든 사원 정보를 출력합니다.
- **SimpleDateFormat 활용**: `Calendar` 타입인 `hireDate`를 `yyyy-MM-dd` 형식으로 변환하여 출력하세요.
- **근속 연수 계산 (Bonus)**: 현재 날짜(`Calendar.getInstance()`)의 연도와 입사일 연도를 비교하여 `[근속 N년차]`를 함께 표시하세요.

#### **[검색] EmployeeSearchController**
- 사번을 입력받아 해당 사원을 검색하여 정보를 출력합니다.

#### **[삭제] EmployeeDeleteController**
- 사번을 입력받아 리스트에서 삭제합니다.

---

## 3. 실행 예시 (Main Menu)
```text
-- 사원 관리 프로그램 --
1. 사원 정보 등록
2. 사원 정보 삭제
3. 사원 정보 수정
4. 사원 정보 검색 (사번)
5. 전체 사원 조회
0. 프로그램 종료
원하시는 메뉴번호를 입력하세요 : 
```

## 4. 힌트
- `Calendar`를 `Date`로 변환할 때는 `cal.getTime()`을 사용합니다.
- `Date`를 `Calendar`에 설정할 때는 `cal.setTime(date)`를 사용합니다.
- `SimpleDateFormat`의 `parse()` 메서드는 `java.util.Date`를 반환합니다.
