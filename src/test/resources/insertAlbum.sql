insert into albums(naam,artiestid)
values ('test', (select id from artiesten where naam='test'));

insert into tracks(naam,tijd,albumid)
values ('test',10,(select id from albums where naam='test'));