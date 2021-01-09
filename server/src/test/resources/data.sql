
insert into person (id, age, blood_type, name) values (1, 20, 'O', 'SON');
insert into person (id, age, blood_type, name) values (2, 25, 'A', 'KIM');
insert into person (id, age, blood_type, name) values (3, 30, 'A', 'PARK');
insert into person (id, age, blood_type, name) values (4, 35, 'B', 'YOON');
insert into person (id, age, blood_type, name) values (5, 40, 'AB', 'POUL');

select * from block;
insert into block (id, name) values (1, 'PARK');
insert into block (id, name) values (2, 'YOON');

update person set block_id = 1 where id= 3;
update person set block_id = 2 where id= 4;
