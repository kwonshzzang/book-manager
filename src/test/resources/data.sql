insert into member(name, email) values ('martin', 'martin@fastcampus.com');
insert into member(name, email) values ('dennis', 'dennis@fastcampus.com');
insert into member(name, email) values ('sophia', 'sophia@slowcampus.com');
insert into member(name, email) values ('james', 'james@slowcampus.com');
insert into member(name, email) values ('martin', 'martin@another.com');

insert into publisher(name) values ('패스트캠퍼스');
insert into book(name, publisher_id, deleted) values ('JPA 초격차 패키지', 1, false);
insert into book(name, publisher_id, deleted) values ('Spring Security 초격차 패키지', 1, false);
insert into book(name, publisher_id, deleted) values ('SpringBoot 올인원 패키지', 1,  true);
