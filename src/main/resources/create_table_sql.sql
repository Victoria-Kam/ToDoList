create table task(
   idTask serial primary key,
   idTaskType integer,
  title varchar(50),
  content varchar(255),
  idTaskStatus integer)


create table task_type(
  idTaskType integer primary key,
  name varchar(50)
)
--Обновлени таблицы task, добавление вторичного ключа idTaskType для связи с таблицей task_type
alter table task add constraint idTaskType foreign key (idTaskType) references task_type (idTaskType)


create table task_status(
   idTaskStatus integer primary key,
   name varchar(50)
)
--Обновлени таблицы task, добавление вторичного ключа idTaskStatus для связи с таблицей task_status
alter table task add constraint idTaskStatus foreign key (idTaskStatus) references task_status (idTaskStatus)


