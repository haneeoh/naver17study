-- 전체 table 확인하기
show tables;
-- 현재 날짜와 시간 구하기 (모두 같은값)
select now() from dual;
select sysdate() from dual;
select current_timestamp() from dual;

-- 날짜 함수들
select year(now()) from dual; -- year(날짜) : 2025 숫자로 반환
select month(now()) from dual; -- month(날짜) : 1월을 숫자로 반환
select day(now()) from dual; -- 일
select dayofmonth(now()) from dual; -- 일
select monthname(now()) from dual; -- 월을 영어로
select dayname(now()) from dual; -- 요일을 영어로

-- date_format(날짜,'형식') -> 오라클의 to_char 과 같다
select date_format(now(),'%Y-%m-%d') from dual; -- %Y(년도 4자리)//%y(년도 2자리),%M(월을 영어로 반환)//%m(월 숫자로),%d(날짜)//%D 는 2nd
select date_format(now(),'%y-%M-%D') from dual;
select date_format(now(),'%Y-%m-%d %H:%i') from dual; -- %H(24시간 기준 시간)//%h(12시간,AMPM 표시는 모르겠음), %i(분 숫자 표시)=%I
select date_format(now(),'%Y년%m월%d일 %H시%i분') from dual; -- 한글도 출력

-- 문자 함수들
-- concat(a,b): 문자열결합,여러개도 가능하다(오라클은2개만 가능)
select concat('Happy','Day') from dual;
select concat('Happy','Day','!!') from dual;
-- replace('문자열','기존문자열','새로운문자열'):문자열 변경
select replace('bitcamp','bit','비트') from dual;
-- instr('문자열','찾는문자열'):위치반환
select instr('김영희','영희') from dual; -- 2 (2번째에 있다는 의미)
select instr('김영희','철수') from dual; -- 0 (없다는 의미)
-- left('문자열',갯수):왼쪽에서 추출
-- right('문자열',갯수):오른쪽에서 추출
-- mid('문자열','시작위치',갯수):시작위치부터 갯수만큼 추출
-- substring('문자열','시작위치',갯수):시작위치부터 갯수만큼 추출
select left('Have a nice day',4) from dual; -- Have
select right('Have a nice day',3) from dual; -- day
select mid('Have a nice day',8,4) from dual; -- nice
select substring('Have a nice day',13,3) from dual; -- day

-- ltring,rtrim,trim : 공백제거
select concat('*',ltrim('      Happy      '),'*') from dual;
select concat('*',rtrim('      Happy      '),'*') from dual;
select concat('*',trim('      Happy      '),'*') from dual;

-- lower,lcase:소문자변환 / upper,ucase:대문자변환 / reverse: 거꾸로
select lower('HappY dAy HahA') from dual;
select lcase('HappY dAy HahA') from dual;
select upper('HappY dAy HahA') from dual;
select ucase('HappY dAy HahA') from dual;
select reverse('HappY dAy HahA') from dual;

-- 조건함수
-- if(조건식,'참','거짓')
select if(100>200,'맞음','틀림') from dual;
select if(100>200,'맞음','틀림') result from dual; -- 컬럼제목변경 result

-- ifnull(컬럼값,널일때의 대치값) :오라클의NVL 과같다
select ifnull(null,1) from dual; -- 1
select ifnull('mija',1) from dual; -- mija

-- 숫자함수
-- abs : 절대값
select abs(6),abs(-6) from dual;
-- ceiling : 무조건올림 / floor : 무조건 내림 / round :반올림
select ceiling(3.1), floor(3.1) from dual;
select ceiling(3.9), floor(3.9) from dual;
select round(3.16,1) from dual; -- 소숫점 첫째자리까지 반올림
select round(567892,-2) from dual; -- 정수 뒤에서 두번째자리 까지 반올림

-- pow : 지수승, mod: 나머지
select pow(2,3), mod(10,3) from dual; -- 2의3승 / 10을 3으로나눈 나머지

-- greatest(숫자1,숫자2,...): 가장 큰 숫자 구하기
-- least(숫자1,숫자2,...): 가장 작은 숫자 구하기
select greatest(100,34,56,200,49) from dual;
select least(100,34,56,200,49) from dual;

-- 연습용 테이블 생성
create table study502.shop(
	idx smallint auto_increment primary key,
    sangpum varchar(30),
    su smallint default 1,
    danga int,
    ipgoday datetime);


create table study502.person(
	num smallint auto_increment primary key,
    name varchar(20),
    age smallint default 1,
    hp varchar(20),
    blood varchar(6));





