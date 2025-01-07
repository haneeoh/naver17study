-- emp 테이블로 연습
-- job 컬럼의 데이터중 중복되는 데이터는 한번만 출력해보자 distinct
select distinct job from emp; 
select distinct job,ename from emp; -- 다른 컬럼과 같이 쓸 경우 적용이 안되거나 오류가 날 수 있다.
select * from emp; --전체 컬럼 데이타 조회
select ename, job from emp; --일부 컬럼만 조회
select ename, job from emp order by ename; -- ename의 오름차순 조회(asc 오름차순 일 경우에는 생략 가능)
select ename, job from emp order by ename desc; -- ename의 내림차순 조회 (desc 경우 생략 불가능)

-- job 의 오름차순, 같은 job 일 경우는 ename 의 내림차순 조회
select job,ename from emp order by job,ename desc;
-- job 의 오름차순 같은 Job 일 경우도 enmae 의 오름차순 조회
select job,ename from emp order by job,ename;
-- 순서를 정할 때 컬럼명 대신 컬럼 번호로 해도 된다. (첫번째 컬럼은 1이다.emp 순이 아니라 출력한순서대로)
select job,ename from emp order by 1,2; -- job이 1, ename 이 2

--sal 의 오름차순 정렬
select * from emp order by 6; -- 6번째열 SAL 의 기준으로 오름차순 조회
select * from emp order by sal; -- 그러나 열이나 행이 바뀔 수 있으니 정확하게 쓰는게 가장 좋음

select ename,sal,comm,job,empno from emp order by 5;
select ename,sal,comm,job,empno from emp order by 1 desc;

-- where 조건문
select ename,job,sal,comm from emp where sal>=1500;
select ename,job,sal,comm from emp where ename='allen'; -- 데이터는 대소문자 정확히 써야한다
select ename,job,sal,comm from emp where ename='ALLEN';

-- ENAME 이 A 로 시작하는 데이터 조회
select ename,job,sal,comm from emp where ename LIKE 'A%'; -- 'ㅁ%' ㅁ으로 시작하는 것 찾기
-- ENAME 에 A 가 포함되는 데이터 조회
select ename,job,sal,comm from emp where ename LIKE '%A%'; -- '%ㅁ%' ㅁ이 포함된 것 찾기
-- ENAME 에 A 로 시작하거나 S 로 시작하는 데이터 조회
select ename,job,sal,comm from emp where ename LIKE 'A%' or ename LIKE 'S%'; -- 값만 두번 쓰는것 X 컬럼명까지 써줘야함
-- ENAME 에 A와 S를 모두 포함하는 데이터만 출력
select ename,job,sal,comm from emp where ename LIKE '%S%' and ename LIKE '%A%';

-- ENAME 의 두번째 글자가 A 인 사람만 조회
select ename,job,sal,comm from emp where ename LIKE '_A%'; -- _는 한 글자를 의미
-- ENAME 의 세번째 글자가 A 이거나 세번째가 A 인 사람만 조회 이름 오름차순
select ename,job,sal,comm from emp where ename LIKE '_A%' or ename LIKE'__A%' order by ename;
-- ename 이 N 이나 K로 끝나는 사람만 조회
select ename,job,sal,comm from emp where ename LIKE '%N' or ename LIKE '%K';
-- job이 analyst 이면서 sal 이 1500 이상인 사람 조회
select ename,job,sal,comm from emp where job='ANALYST' and SAL>=1500;

--SAL 1200~2000 사이값 조회
select ename,job,sal,comm from emp where SAL>1200 AND SAL<=2000; --방법1
select ename,job,sal,comm from emp where SAL between 1200 and 2000; --방법2

--JOB 이 MANAGER, SALESMAN, ANALYST 이 3가지 직업의 사람을 조회
select ename,job,sal,comm from emp where job='MANAGER' OR job='SALESMAN' or job='ANALYST'; --방법1
select ename,job,sal,comm from emp where job IN ('MANAGER','SALESMAN','ANALYST');

--EMPNO 가 7654,7788,7844,7902 인 사람을 조회
select empno,ename,job,sal,comm from emp where empno IN(7654,7788,7844,7902);

--COMM 이 NULL 인 데이터만 조회
select ename,job,sal,comm from emp where comm is NULL;

--COMM 이 NULL 이 아닌 데이터만 조회
select ename,job,sal,comm from emp where comm is not NULL;

--MGR 이 NULL 이 아닌 경우만 조회
select * from emp where mgr is not null;

--comm이 null 인 경우는 0으로 출력 mgr이 null 인 경우는 1000
select ename,job,sal,NVL(mgr,1000),NVL(comm,0) from emp;-- ->NVL(comm,0) null 값을 0으로 출력한다.

select sal,comm,sal+comm from emp; -- null+숫자=null
--위의 경우 sal+comm 이 경우 comm이 null 이면 0으로 계산
select sal,comm,sal+NVL(comm,0) from emp;

-- 컬럼제목에 별칭 주기(alias)
select ename as "사원명",sal as"월급여" from emp; --생략없이 alias 지정하는 방법 유일하게 "" 들어갈 수 있는 부분
select ename "사원명",sal "월급여" from emp; --as 생략하고 alias 지정하는 방법
select ename 사원명,sal 월급여 from emp; -- alias 에 공백이 없는 경우는 "" 도 생략 가능
select ename "사원 이름",sal "월 급여" from emp; --중간에 공백이 있는 경우 "" 반드시 넣어야함


--총 레코드 갯수(데이타 갯수)
select count(*) from emp; --이 경우는 컬럼명이 count(*)
select count(*) count from emp; -- 이 경우는 컬럼명이 count
select count(*) 총갯수 from emp; -- 컬럼명 총갯수

select sal,comm,sal+NVL(comm,0) sum from emp; -- sal+NVL(comm,0) 컬럼명은 sum 으로 변경
select sal 월급여,comm 커미션,sal+NVL(comm,0) 총금액 from emp; --컬럼명을 한글로

--문자열을 컬럼에 추가시 || 연산자 사용
select '제 이름은 '||ename||'입니다' 자기소개 from emp; -- ->자기소개를 빼면 컬럼이름이 앞내용이 되므로 제목 써주는것이 좋음

--내 직업은 salseman 이고 내 월 급여는 1600입니다. 라고 컬럼명 "자기소개" 에 나오도록 작성
select '내 직업은 '||job||'이고, 내 월 급여는 '||sal||'$ 입니다' 자기소개 from emp;

-- sal 이 1500~2000 사이가 아닌 경우만 조회
select * from emp where sal not between 1500 and 2000;

--not in 을 사용하여 job 이 salesman, clerk 가 아닌 경우만 조회
select * from emp where job not in('SALESMAN','CLERK');

-- GROUP 함수 (COUNT,SUM,AVG,MAX,MIN)
select count(*) from emp; --전체 데이터 수
select sum(sal) from emp; --sal 의 총 합계
select avg(sal) from emp; --sal 의 평균, 소숫점 이하가 너무 많이 나온다
select round(avg(sal),2) from emp; --sal 의 평균을 구하는데 소숫점 이하 2자리로 구한다
select max(sal) from emp; --최고 급여액수

--평균 급여보다 sal 이 더 높은 사람을 조회하시오
select * from emp where sal>(select avg(sal) from emp);

--scott 의 직업과 같은 직업을 가진 사람을 조회하시오
select * from emp where job=(select job from emp where ename='SCOTT');

--scott 의 mgr 과 같은 mgr을 가진 사람
select * from emp where mgr=(select mgr from emp where ename='SCOTT');

--group by 출력하려는 내용만 적용할 수 있음
select job from emp group by job; --job 이 그룹별로 나열

--job 의 group별로 인원수를 구해보자 & 제목에 별칭 부여
select job 직업 ,count(*) 인원수 from emp group by job;

--job 의 group 별 인원수를 구해보자(인원이 3명 이상인 경우에만 조회) 그룹함수 조건은 having
select job,count(*) from emp group by job having count(job)>=3;

--job 의 group 별 인원수를 구해보자(인원이 3명 이상인 경우에만 조회 인원순으로 출력)
select job 직업,count(*) 인원수 from emp group by job having count(job)>=3 order by count(*); --1
select job 직업,count(*) 인원수 from emp group by job having count(job)>=3 order by 인원수; --2
select job 직업,count(*) 인원수 from emp group by job having count(job)>=3 order by 2; --3

--직업별 인원수, 최저연봉, 최고연봉, 평균연봉(소숫점이하없이) 를 구하시오
select job 직업,count(*) 인원수,min(sal) 최저연봉,max(sal) 최고연봉, round(avg(sal),0) 평균연봉 from emp group by job order by 직업;

-- 48페이지 숫자함수
select abs(-5),abs(5) from dual; -- 5 5 절대값 출력
-- round 반올림 ceil 올림 floor 내림
select round(3.6,0),ceil(3.6),floor(3.6) from dual;
select round(3.4,0),ceil(3.4),floor(3.4) from dual;
select round(328947, -2) from dual; --뒤에서 두번째 자리에서 반올림
select round(328967, -2) from dual;

select round(avg(sal)),ceil(avg(sal)),floor(avg(sal)) from emp;

--power(m,n):m의 n승값을 구함 mod(m,n):m을 n으로 나눈 나머지
select power(3,3),mod(10,3) from dual;

--문자함수 concat(두문자더하기),lower(소문자),upper(대문자),initcap(첫글자만대문자)
select ename,concat(ename,'님'),lower(ename),upper(ename),initcap(ename) from emp;

select lpad(sal,10,'*') from emp; -- 총 10자리에 남는 부분을 *로 채움(왼쪽부터)
select rpad(sal,10,'*') from emp; -- 총 10자리에 남는 부분을 *로 채움(오른쪽부터)

select substr('HAPPY DAY',7,3) from dual; -- 7번 글자부터 3글자 추출
select substr('HAPPY DAY',-6,3) from dual; --뒤에서 6번째글자부터 3글자

--emp table 의 ename 에서 왼쪽에서 3글자를 추출후 총 7자리중 우측 빈 공간은 *로 채워서 출력
select rpad(substr(ename,1,3),7,'*') 이름 ,sal from emp;

--length 길이구하기
select ename 이름, length(ename) 문자길이 from emp;

--replace 대치 HAPPY 를 good 으로 변경
select replace('HAPPY DAY','HAPPY','good') from dual;

--trim : 앞뒤 공백 제거
select '*'||'     le su ji    '||'*' from dual;
select '*'||trim('     le su ji    ')||'*' from dual; --앞뒤 공백이 제거됨

--일단 현재 날짜를 나타내는 sysdate
select sysdate from dual;--현재 날짜
select sysdate+7 from dual; --오늘로부터 7일 뒤 날짜
select sysdate+1 from dual; --내일날짜

--to_char 함수를 이용해서 원하는 날짜 모양으로 출력해보자 ->자바에서는 string 타입으로 얻어짐
select to_char(sysdate,'yyyy-mm-dd') from dual;
-- mm:월 mi:분 hh:12시간표시 am또는pm:오전이나 오후 표시
select to_char(sysdate,'yyyy-mm-dd am hh:mi') from dual;
select to_char(sysdate,'yyyy-mm-dd hh24:mi') from dual;

--현재 월 추출
select to_char(sysdate, 'mm') from dual;
select to_char(to_date('2024-5-10'),'mm') from dual;

--emp 의 hiredate 는 날짜타입이다
select to_char(hiredate, 'yyyy-mm-dd') 입사일 from emp;

SELECT * FROM EMP WHERE HIREDATE BETWEEN TO_DATE('1981-02-20', 'YYYY-MM-DD') AND TO_DATE('1981-02-21', 'YYYY-MM-DD') + 0.999999;
SELECT * FROM EMP WHERE HIREDATE BETWEEN TO_DATE('1981-02-20', 'YYYY-MM-DD') AND TO_DATE('1981-02-21', 'YYYY-MM-DD') + 0.444444;




