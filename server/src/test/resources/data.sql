
insert into person (id, name, year_of_birthday, month_of_birthday, day_of_birthday) values (1, 'SON', 1988, 8, 5);
insert into person (id, name, year_of_birthday, month_of_birthday, day_of_birthday) values (2, 'KIM', 1990, 2, 3);
insert into person (id, name, year_of_birthday, month_of_birthday, day_of_birthday) values (3, 'PARK', 1992, 8, 15);
insert into person (id, name, year_of_birthday, month_of_birthday, day_of_birthday) values (4, 'YOON', 1995, 12, 8);
insert into person (id, name, year_of_birthday, month_of_birthday, day_of_birthday) values (5, 'POUL', 1972, 7, 23);
select * from block;
insert into block (id, name) values (1, 'PARK');
insert into block (id, name) values (2, 'YOON');

update person set block_id = 1 where id= 3;
update person set block_id = 2 where id= 4;
