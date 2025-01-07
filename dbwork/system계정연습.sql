-- 주석처리 
-- system 에 등록된 table 들 확인하기
-- 커서가 있는 곳의 sql 문 실행 단축키는 : ctrl+enter
select * from tab; -- 이어지는 명령어가 있으면 세미콜론 필요

-- 등록된 user(계정)들 확인
select username from dba_users; -- dba_users 테이블에서 username 이라는 컬럼만 확인하
기
-- dba_users 라는 테이블에는 어떤 컬럼이 있을까?
desc dba_users; -- 기본 구조만 확인(데이타는 확인안됨)
select username,account_status from dba_users; -- 계정과 Lock 상태 알아보기

-- scott 계정에 비번은 tiger 로 생성해보자
create user scott identified by tiger;  -- 오류발생 12버전부터

-- 12버전부터는 user명에 공통문자열 c##이 들어가야한다.
-- 일단 c##scott/ 비번은 tiger 로 만들어보자
create user c##scott identified by tiger;

-- c##scott 계정을 삭제 후 공통문자열을 안넣고도 생성하는 방법으로 다시 생성해보자
drop user c##scott;

alter session set "_ORACLE_SCRIPT"=true; -- session 변경

drop user scott;
-- C## 공통문자열을 빼고 다시 생성해보자 (scott/tiger)

create user scott identified by tiger;

-- angel/a1234로 만들어보자
create user angel identified by a1234;

select username,account_status from dba_users;

-- angel 계정에 lock 설정
alter user angel account lock;

-- angel 계정에 lock 설정 해제
alter user angel account unlock;

-- scott 와 angel 계정에 기본 권한을 주자
grant connect,resource to angel;
grant connect,resource to scott;

-- 생성된 계정에서 테이블을 생성하고 데이터를 추가하려고 하면 table space 에 대한 오류 발생
-- table space를 unlimit 로 설정 (system 계정에서만 할 수 있다.)
alter user angel default tablespace users quota unlimited on users;
alter user scott default tablespace users quota unlimited on users;

-- angel 의 비밀번호를 a1234 에서 pw1234 로 변경해보자(system 에서 가능)
alter user angel identified by pw1234;



