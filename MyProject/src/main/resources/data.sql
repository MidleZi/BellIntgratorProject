INSERT INTO `bellintegrator`.`authusers` (`login`, `password`) VALUES ('admin', 'admin');
INSERT INTO `bellintegrator`.`authusers` (`login`, `password`) VALUES ('user', 'user');

INSERT INTO `bellintegrator`.`countries` (`code`, `name`) VALUES ('643', 'Российская Федерация');
INSERT INTO `bellintegrator`.`countries` (`code`, `name`) VALUES ('860', 'Республика Узбекистан');

INSERT INTO `bellintegrator`.`docs` (`code`, `name`) VALUES ('03', 'Свидетельство о рождении');
INSERT INTO `bellintegrator`.`docs` (`code`, `name`) VALUES ('07', 'Военный билет');
INSERT INTO `bellintegrator`.`docs` (`code`, `name`) VALUES ('08', 'Временное удостоверение, выданное взамен военного билета');
INSERT INTO `bellintegrator`.`docs` (`code`, `name`) VALUES ('10', 'Паспорт иностранного гражданина');
INSERT INTO `bellintegrator`.`docs` (`code`, `name`) VALUES ('11', 'Свидетельство о рассмотрении ходатайства о признании лица      ');
INSERT INTO `bellintegrator`.`docs` (`code`, `name`) VALUES ('12', 'Вид на жительство в Российской Федерации');
INSERT INTO `bellintegrator`.`docs` (`code`, `name`) VALUES ('13', 'Удостоверение беженца');
INSERT INTO `bellintegrator`.`docs` (`code`, `name`) VALUES ('15', 'Разрешение на временное проживание в Российской Федерации');
INSERT INTO `bellintegrator`.`docs` (`code`, `name`) VALUES ('18', 'Свидетельство о предоставлении временного убежища на территории');
INSERT INTO `bellintegrator`.`docs` (`code`, `name`) VALUES ('21', 'Паспорт гражданина Российской Федерации');
INSERT INTO `bellintegrator`.`docs` (`code`, `name`) VALUES ('24', 'Удостоверение личности военнослужащего Российской Федерации');
INSERT INTO `bellintegrator`.`docs` (`code`, `name`) VALUES ('91', 'Инные документы');

INSERT INTO `bellintegrator`.`organization` (`name`, `fullName`, `inn`, `kpp`, `adress`, `phone`, `isActive`) VALUES ('BellIntegrator', 'ООО "Белл Интегратор"', '7777777777', '777777777', 'Москва', '+7 (495) 777-77-77', 'true');
INSERT INTO `bellintegrator`.`organization` (`name`, `fullName`, `inn`, `kpp`, `adress`, `phone`, `isActive`) VALUES ('McDonald''s', 'ООО "Макдональдс"', '7788888888', '778888888', 'Москва', '+7 (495) 888-88-88', 'true');

INSERT INTO `bellintegrator`.`office` (`orgId`, `name`, `adress`, `phone`, `isAtive`) VALUES ('1', 'офис1', 'Москва', '+7(495) 777-77-77', 'true');
INSERT INTO `bellintegrator`.`office` (`orgId`, `name`, `adress`, `phone`, `isAtive`) VALUES ('1', 'офис2', 'Пенза', '+7 (8412) 555-555', 'true');
INSERT INTO `bellintegrator`.`office` (`orgId`, `name`, `adress`, `phone`, `isAtive`) VALUES ('2', 'ресторан 1', 'Москва, ул. Лескова', '+7 (495) 888-88-78', 'true');
INSERT INTO `bellintegrator`.`office` (`orgId`, `name`, `adress`, `phone`, `isAtive`) VALUES ('2', 'Ресоран 2', 'Москва, ул Вучетича', '+7 (495) 888-88-98', 'false');

INSERT INTO `bellintegrator`.`user` (`officeId`, `firstName`, `secondName`, `middleName`, `position`, `phone`, `docName`, `docNamber`, `docDate`, `citizenshipName`, `citizenshipCode`, `isIdentified`) VALUES ('1', 'Василий', 'Васильев', 'Васильевич', 'Менеджер', '+7 (999_ 998-98-98', 'Паспорт', '7788 546546', '2014-02-15', 'Российское', '643', 'true');
INSERT INTO `bellintegrator`.`user` (`officeId`, `firstName`, `secondName`, `middleName`, `position`, `phone`, `docName`, `docNamber`, `docDate`, `citizenshipName`, `citizenshipCode`, `isIdentified`) VALUES ('1', 'Петр', 'Петров', 'Петрович', 'Начальник', '+7 (999) 999-99-65', 'Паспорт', '7744 789789', '2012-05-04', 'Российское', '643', 'true');
INSERT INTO `bellintegrator`.`user` (`officeId`, `firstName`, `secondName`, `middleName`, `position`, `phone`, `docName`, `docNamber`, `docDate`, `citizenshipName`, `citizenshipCode`, `isIdentified`) VALUES ('2', 'Станислав', 'Петькин', 'Васильевич', 'Директор', '+7 (555) 555-55-55', 'Паспорт', '6554 123456', '2010-07-02', 'Российское', '643', 'true');
INSERT INTO `bellintegrator`.`user` (`officeId`, `firstName`, `secondName`, `middleName`, `position`, `phone`, `docName`, `docNamber`, `docDate`, `citizenshipName`, `citizenshipCode`, `isIdentified`) VALUES ('2', 'Владимир', 'Путин', 'Владимирович', 'Менеджер', '+7 (222) 222-22-22', 'Паспорт', '4658 987654', '2009-05-06', 'Российское', '643', 'true');
INSERT INTO `bellintegrator`.`user` (`officeId`, `firstName`, `secondName`, `middleName`, `position`, `phone`, `docName`, `docNamber`, `docDate`, `citizenshipName`, `citizenshipCode`, `isIdentified`) VALUES ('3', 'Любовь', 'Петушкова', 'Альбертовна', 'Управляющий', '+7 (111) 111-11-11', 'Паспорт', '1221 658975', '2004-08-06', 'Российское', '643', 'true');
INSERT INTO `bellintegrator`.`user` (`officeId`, `firstName`, `secondName`, `middleName`, `position`, `phone`, `docName`, `docNamber`, `docDate`, `citizenshipName`, `citizenshipCode`, `isIdentified`) VALUES ('3', 'Мария', 'Филипова', 'Александровна', 'Кассир', '+7 (555) 546-89-78', 'Паспорт', '6556 987458', '2007-04-15', 'Российское', '643', 'true');
INSERT INTO `bellintegrator`.`user` (`officeId`, `firstName`, `secondName`, `middleName`, `position`, `phone`, `docName`, `docNamber`, `docDate`, `citizenshipName`, `citizenshipCode`, `isIdentified`) VALUES ('3', 'Айгуль', 'Агазамад', 'Рафиковна', 'Уборщица', '+7 (568) 236-52-47', 'Паспорт', 'СА 1580788', '1984-06-16', 'Узбекистан', '860', 'false');
INSERT INTO `bellintegrator`.`user` (`officeId`, `firstName`, `secondName`, `middleName`, `position`, `phone`, `docName`, `docNamber`, `docDate`, `citizenshipName`, `citizenshipCode`, `isIdentified`) VALUES ('4', 'Геннадий', 'Маталлов', 'Вольфрамович', 'Директор', '+7 (123)123-45-67', 'Паспорт', '6554 456321', '1987-04-17', 'Роосийское', '643', 'true');