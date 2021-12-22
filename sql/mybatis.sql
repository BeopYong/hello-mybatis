-- ========================================================================
-- hello-mybatis
-- ========================================================================
-- student table 생성
create table student(
    no number,
    name varchar2(50) not null,
    tel char(11) not null,
    reg_date date default sysdate,
    constraint pk_student_no primary key (no)
);

create sequence seq_student_no;

insert into student(no, name, tel) values (seq_student_no.nextval, '가갸거겨', '01012341234');
insert into student(no, name, tel) values (seq_student_no.nextval, '다댜더뎌', '01012341234');
insert into student(no, name, tel) values (seq_student_no.nextval, '아야어여', '01012341234');
insert into student(no, name, tel) values (seq_student_no.nextval, '바뱌버벼', '01012341234');
insert into student(no, name, tel) values (seq_student_no.nextval, '카캬커켜', '01012341234');

select * from student;
commit;




-- ========================================================================
-- web계정에서 kh 계정의 일부테이블 사용하기
-- ========================================================================
select * from kh.employee;
select * from kh.department;
select * from kh.job;

-- =========kh계정 권한부여=============
--grant all on kh.employee to web;
--grant select on kh.department to web;
--grant select on kh.job to web;


-- synonym 동의어객체
-- 별칭객체
-- create synonym은 resource롤에 포함되지 않는 권한
create synonym emp for kh.employee;
create synonym dept for kh.department;
create synonym job for kh.job;

-- =========system계정 권한부여=============
--grant create synonym to web;

-- 조회
select * from emp;
select * from dept;
select * from job;

--commit;

select
    *
from(
    select
        emp.*,
        (select job_name from job where job_code = emp.job_code) job_name,
        (select dept_title from dept where dept_id = emp.dept_code) dept_title,
        decode(substr(emp_no, 8, 1), '1', '남', '3', '남', '여') gender
    from
        emp
)
where
    job_code in ('J2', 'J3', 'J4')
    and
    dept_code in ('D3', 'D4', 'D5');
