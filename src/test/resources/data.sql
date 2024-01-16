insert into member(name, email) values ('martin', 'martin@fastcampus.com');
insert into member(name, email) values ('dennis', 'dennis@fastcampus.com');
insert into member(name, email) values ('sophia', 'sophia@slowcampus.com');
insert into member(name, email) values ('james', 'james@slowcampus.com');
insert into member(name, email) values ('martin', 'martin@another.com');

insert into publisher(name) values ('패스트캠퍼스');
insert into book(name, publisher_id, deleted, status) values ('JPA 초격차 패키지', 1, false, 100);
insert into book(name, publisher_id, deleted, status) values ('Spring Security 초격차 패키지', 1, false, 200);
insert into book(name, publisher_id, deleted, status) values ('SpringBoot 올인원 패키지', 1,  true, 100);
