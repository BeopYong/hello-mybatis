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










