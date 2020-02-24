--INSERT INTO coin2.abonent (n_abonent, name) VALUES (1,'a_name');
--INSERT INTO coin2.oivs (vo_id, vo_status) VALUES (1,'s');

--SELECT * FROM coin2.abonent;
--SELECT * FROM coin2.oivs;

--INSERT INTO coin2.rulon (vo_id, n_abonent) VALUES (1,1);

--SELECT * FROM coin2.rulon;

--============================================
--transaction (result=ОШИБКА:  текущая транзакция прервана, команды до конца блока транзакции игнорируются)
--BEGIN;
--INSERT INTO coin2.abonent (n_abonent, name) VALUES (2,'a_name');
--INSERT INTO coin2.rulon (vo_id, n_abonent) VALUES (1,1);
--DELETE FROM coin2.abonent WHERE n_abonent = 3;
--COMMIT;
--============================================
--Build data
INSERT INTO coin2.category (category_name) VALUES ('c1');
INSERT INTO coin2.category (category_name) VALUES ('c2');
INSERT INTO coin2.category (category_name) VALUES ('c3');
INSERT INTO coin2.category (category_name) VALUES ('c4');
INSERT INTO coin2.sub_category (category_id, sub_category_name) VALUES (1,'s11');
INSERT INTO coin2.sub_category (category_id, sub_category_name) VALUES (2,'s21');
INSERT INTO coin2.sub_category (category_id, sub_category_name) VALUES (3,'s31');
INSERT INTO coin2.sub_category (category_id, sub_category_name) VALUES (4,'s41');
INSERT INTO coin2.sub_category (category_id, sub_category_name) VALUES (4,'s42');
--ERROR INSERT INTO coin2.sub_category (category_id, sub_category_name) VALUES (5,'s42');
INSERT INTO coin2.operation (sub_category_id, original_message) VALUES (2,'message1');
INSERT INTO coin2.operation (sub_category_id, original_message) VALUES (3,'message2');
INSERT INTO coin2.operation (sub_category_id, original_message) VALUES (4,'message3');
INSERT INTO coin2.operation (sub_category_id, original_message) VALUES (5,'message4');
INSERT INTO coin2.operation (sub_category_id, original_message) VALUES (6,'message42');
--ERROR INSERT INTO coin2.operation (sub_category_id, original_message) VALUES (7,'message42');
DELETE FROM coin2.operation;
--============================================
--main select
SELECT * FROM coin2.operation, coin2.sub_category, coin2.category
WHERE operation.sub_category_id = sub_category.sub_category_id AND
sub_category.category_id = category.category_id;
--============================================
SELECT * FROM coin2.sub_category;
SELECT * FROM coin2.category;
SELECT * FROM coin2.user;
DELETE FROM coin2.category;
