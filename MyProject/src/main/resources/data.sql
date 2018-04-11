INSERT INTO `account` ( `name`, `login`, `version`, `password`) VALUES ( 'admin', 'admin', '0', 'admin');
INSERT INTO `account` ( `name`, `login`, `version`, `password`) VALUES ('user', 'user', '0', 'user');

INSERT INTO `countries` (`code`, `version`, `name`) VALUES ('643', '0', 'Российская Федерация');
INSERT INTO `countries` (`code`, `version`, `name`) VALUES ('860', '0', 'Республика Узбекистан');

INSERT INTO `docs` (`code`, `version`, `name`) VALUES ('03', '0', 'Свидетельство о рождении');
INSERT INTO `docs` (`code`, `version`, `name`) VALUES ('07', '0', 'Военный билет');
INSERT INTO `docs` (`code`, `version`, `name`) VALUES ('08', '0', 'Временное удостоверение, выданное взамен военного билета');
INSERT INTO `docs` (`code`, `version`, `name`) VALUES ('10', '0', 'Паспорт иностранного гражданина');
INSERT INTO `docs` (`code`, `version`, `name`) VALUES ('11', '0', 'Свидетельство о рассмотрении ходатайства о признании лица      ');
INSERT INTO `docs` (`code`, `version`, `name`) VALUES ('12', '0', 'Вид на жительство в Российской Федерации');
INSERT INTO `docs` (`code`, `version`, `name`) VALUES ('13', '0', 'Удостоверение беженца');
INSERT INTO `docs` (`code`, `version`, `name`) VALUES ('15', '0', 'Разрешение на временное проживание в Российской Федерации');
INSERT INTO `docs` (`code`, `version`, `name`) VALUES ('18', '0', 'Свидетельство о предоставлении временного убежища на территории');
INSERT INTO `docs` (`code`, `version`, `name`) VALUES ('21', '0', 'Паспорт гражданина Российской Федерации');
INSERT INTO `docs` (`code`, `version`, `name`) VALUES ('24', '0', 'Удостоверение личности военнослужащего Российской Федерации');
INSERT INTO `docs` (`code`, `version`, `name`) VALUES ('91', '0', 'Инные документы');

INSERT INTO `organization` (`version`, `name`, `fullname`, `inn`, `kpp`, `address`, `phone`, `isactive`) VALUES ('0', 'BellIntegrator', 'ООО "Белл Интегратор"', '7777777777', '777777777', 'Москва', '+7 (495) 777-77-77', 'true');
INSERT INTO `organization` (`version`, `name`, `fullname`, `inn`, `kpp`, `address`, `phone`, `isactive`) VALUES ('0', 'McDonald''s', 'ООО "Макдональдс"', '7788888888', '778888888', 'Москва', '+7 (495) 888-88-88', 'true');
INSERT INTO `organization` (`version`, `name`, `fullname`, `inn`, `kpp`, `address`, `phone`, `isactive`) VALUES (0, 'test', 'test', 9876543210 , 876543210, 'test', 'test', false);

INSERT INTO `office` (`version`, `orgid`, `name`, `address`, `phone`, `is_active`) VALUES ('0', '1', 'офис1', 'Москва', '+7(495) 777-77-77', 'true');
INSERT INTO `office` (`version`, `orgid`, `name`, `address`, `phone`, `is_active`) VALUES ('0', '1', 'офис2', 'Пенза', '+7 (8412) 555-555', 'true');
INSERT INTO `office` (`version`, `orgid`, `name`, `address`, `phone`, `is_active`) VALUES ('0', '2', 'ресторан 1', 'Москва, ул. Лескова', '+7 (495) 888-88-78', 'true');
INSERT INTO `office` (`version`, `orgid`, `name`, `address`, `phone`, `is_active`) VALUES ('0', '2', 'Ресоран 2', 'Москва, ул Вучетича', '+7 (495) 888-88-98', 'false');

INSERT INTO `users` (`version`, `officeid`, `firstname`, `secondname`, `middlename`, `position`, `phone`, `doctype`, `docnumber`, `docdate`, `citizenshipcode`, `isidentified`) VALUES ('0', '1', 'Василий', 'Васильев', 'Васильевич', 'Менеджер', '+7 (999) 998-98-98', '21', '7788 546546', '2014-02-15', '643', 'true');
INSERT INTO `users` (`version`, `officeid`, `firstname`, `secondname`, `middlename`, `position`, `phone`, `doctype`, `docnumber`, `docdate`, `citizenshipcode`, `isidentified`) VALUES ('0', '1', 'Петр', 'Петров', 'Петрович', 'Начальник', '+7 (999) 999-99-65', '21', '7744 789789', '2012-05-04', '643', 'true');
INSERT INTO `users` (`version`, `officeid`, `firstname`, `secondname`, `middlename`, `position`, `phone`, `doctype`, `docnumber`, `docdate`, `citizenshipcode`, `isidentified`) VALUES ('0', '2', 'Станислав', 'Петькин', 'Васильевич', 'Директор', '+7 (555) 555-55-55', '21',  '6554 123456', '2010-07-02', '643', 'true');
INSERT INTO `users` (`version`, `officeid`, `firstname`, `secondname`, `middlename`, `position`, `phone`, `doctype`, `docnumber`, `docdate`, `citizenshipcode`, `isidentified`) VALUES ('0', '2', 'Владимир', 'Путин', 'Владимирович', 'Менеджер', '+7 (222) 222-22-22', '21', '4658 987654', '2009-05-06', '643', 'true');
INSERT INTO `users` (`version`, `officeid`, `firstname`, `secondname`, `middlename`, `position`, `phone`, `doctype`, `docnumber`, `docdate`, `citizenshipcode`, `isidentified`) VALUES ('0', '3', 'Любовь', 'Петушкова', 'Альбертовна', 'Управляющий', '+7 (111) 111-11-11', '21', '1221 658975', '2004-08-06', '643', 'true');
INSERT INTO `users` (`version`, `officeid`, `firstname`, `secondname`, `middlename`, `position`, `phone`, `doctype`, `docnumber`, `docdate`, `citizenshipcode`, `isidentified`) VALUES ('0', '3', 'Мария', 'Филипова', 'Александровна', 'Кассир', '+7 (555) 546-89-78', '21', '6556 987458', '2007-04-15', '643', 'true');
INSERT INTO `users` (`version`, `officeid`, `firstname`, `secondname`, `middlename`, `position`, `phone`, `doctype`, `docnumber`, `docdate`, `citizenshipcode`, `isidentified`) VALUES ('0', '3', 'Айгуль', 'Агазамад', 'Рафиковна', 'Уборщица', '+7 (568) 236-52-47', '10', 'СА 1580788', '1984-06-16', '860', 'false');
INSERT INTO `users` (`version`, `officeid`, `firstname`, `secondname`, `middlename`, `position`, `phone`, `doctype`, `docnumber`, `docdate`, `citizenshipcode`, `isidentified`) VALUES ('0', '4', 'Геннадий', 'Маталлов', 'Вольфрамович', 'Директор', '+7 (123)123-45-67', '21', '6554 456321', '1987-04-17', '643', 'true');
