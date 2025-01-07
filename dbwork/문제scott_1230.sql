-- 12월 30일 오라클 문제

-- 1. 어떤 종류의 직업이 있는지 job을 한번씩만 출력하는데 직업의 오름차순으로 출력하시오
select job from emp group by job order by job;
select distinct job from emp order by job;

-- 2. ename에 대소문자 상관없이 's'를 포함하고 있는 데이터출력(컬럼:ename,job,sal)
select ename,job,sal from emp where ename LIKE '%S%' or ename LIKE '%s%';
select ename,job,sal from emp where lower(ename) like '%s%';

-- 3. ename의 3번째 글자가 L인 사람을 조회하시오(컬럼 :ename, sal, comm)
select ename,sal,comm from emp where ename LIKE '__L%';

-- 4. comm이 null이 아닌 사람 중에 sal이 1500 이상인 사람 출력(컬럼 : ename, sal, comm)
select ename,sal,comm from emp where comm is not NULL and sal>=1500;

-- 5. hiredate 입사일이 5월인 사람은 모두 출력(컬럼 : ename, hiredate, sal)
select ename,hiredate,sal from emp where (to_char(hiredate,'mm'))=5;
select ename,hiredate,sal from emp where (to_char(hiredate,'mm'))='05';

-- 6. hiredate 입사일이 1985-01-01 이후에 입사한사람 출력(컬럼 : ename, hiredate, sal)
select ename,hiredate,sal from emp where (to_char(hiredate,'yyyy-mm-dd'))>='1985-01-01';
select ename,hiredate,sal from emp where hiredate>='1985-01-01';

-- 7. sal이 1500~3000 사이인 사람을 출력하는데 관계연산자와 and를 이용해서 출력
select * from emp where SAL>=1500 AND SAL<=3000;

--8. 7번의 결과를 between 을 이용해서 출력(컬럼:ename,sal,mgr)
select ename,sal,mgr from emp where sal between 1500 and 3000;

--9. in을 이용해서 Job 이 clerk,president,manager 인 사람의 전체 컬럼을 모두 출력
select * from emp where job in('CLERK','PRESIDENT','MANAGER');

--10. ename,sal,comm,sal*comm 을 출력하는데 comm 이 null 인 경우 1로 번경해서 출력하고 계산하기
select ename,sal,NVL(comm,1),sal*NVL(comm,1) from emp;

--11. ename 이 ADAMS인 사람의 SAL보다 더 많이 받는사람 출력(컬럼명:ENAME,JOB,SAL)
select ename,job,sal from emp where sal>(select sal from emp where ename='ADAMS');

--12. 평균 SAL 보다 작은사람의 전체 컬럼 출력
select * from emp where sal<(select avg(sal) from emp);

--13. ENAME 이 A나 S나 M으로 시작하는 모든 사람 출력(컬럼:ENAME,JOB,SAL)
select ename,job,sal from emp where ename LIKE 'A%' or ename LIKE 'S%' or ename LIKE 'M%'; --in으로 하면 안됨

--14. MGR을 GROUP로 인원수와 평균 SAL 을 구하시오(평균 SAL 은 무조건 올림으로), mgr=null 값은 빼고
select mgr,count(*),ceil(avg(sal)) from emp where mgr is not null group by mgr;
select mgr,count(*),round(avg(sal),-1) from emp where mgr is not null group by mgr; --1원단위 반올림

--15. SCOTT 의 SAL 과 같은 SAL 을 받는 사람을 조회하십시오 (컬럼:ENAME,SAL)
select ename,sal from emp where sal=(select sal from emp where ename='SCOTT');

--16. ENAME 의 글자길이가 4글자인 사람만 조회(컬럼:ENAME,JOB)
select ename,job from emp where length(ename)=4;

--17. ENAME 의 3번째 글자가 R이거나 A 인사람 조회(컬럼:ENAME,JOB)
select ename,job from emp where ename like '__R%' or ename like '__A%';

--18. JOB 직업별로 인원수와 최고연봉을 출력하는데 직업의 오름차순으로 출력
select job 직업,count(*) 인원수,max(sal) 최고연봉 from emp group by job order by 직업;

--19. || 연산자를 이용하여 다음과 같이 하나의 컬럼으로 출력하시오(EMP 테이블로)
----    (예) SCOTT 의 직업은 CLERK 이며 입사년도는 1989년 05월입니다. (컬럼명은 자기소개)
select ''||ename||'의 직업은 '||job||'이며 입사년도는 '||hiredate||'입니다.' 자기소개 from emp;
select ename||'의 직업은 ' ||job||'이며 입사년도는 '||to_char(hiredate,'yyyy')||'년'
||to_char(hiredate,'mm')||'월입니다.' 자기소개 from emp;

