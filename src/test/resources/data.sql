insert into member(name, email) values ('martin', 'martin@fastcampus.com');
insert into member(name, email) values ('dennis', 'dennis@fastcampus.com');
insert into member(name, email) values ('sophia', 'sophia@slowcampus.com');
insert into member(name, email) values ('james', 'james@slowcampus.com');
insert into member(name, email) values ('martin', 'martin@another.com');

insert into publisher(name) values ('패스트캠퍼스');
insert into book(name, publisher_id, deleted, status) values ('JPA 초격차 패키지', 1, false, 100);
insert into book(name, publisher_id, deleted, status) values ('Spring Security 초격차 패키지', 1, false, 200);
insert into book(name, publisher_id, deleted, status) values ('SpringBoot 올인원 패키지', 1,  true, 100);

insert into review(title, content, score, member_id, book_id) values ('내 인생을 바꾼 책', '너무 너무 좋았어요', 5.0, 1, 1);
insert into review(title, content, score, member_id, book_id) values ('아주 재미 있는 책', '너무 진도가 빨라요', 2.0, 1, 1);
insert into review(title, content, score, member_id, book_id) values ('우주의 신비', '흥미로워요', 3.0, 1, 1);

insert into comment(comment, review_id) values ('저도 좋았어요~~', 1);
insert into comment(comment, review_id) values ('저는 별로였는데요!!', 1);
insert into comment(comment, review_id) values ('저도 그냥 그랬어요', 2);
insert into comment(comment, review_id) values ('아주 좋았어요', 3);
