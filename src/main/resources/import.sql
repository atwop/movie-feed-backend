create table IF NOT EXISTS movies (
id varchar(255),
title varchar(255),
punctuation float,
dateCreated timestamp,
status varchar(20)
);
delete from movies;
insert into movies(id,title,punctuation,dateCreated,status) values('redsde23','enemy', 7.5, '2012-09-17 18:47:52.69','ACTIVE');
insert into movies(id,title,punctuation,dateCreated,status) values('redsde24','interstellar', 9.1,'2012-09-17 18:47:52.69', 'ACTIVE');