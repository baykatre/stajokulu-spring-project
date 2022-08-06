INSERT INTO VEHICLE (plate) VALUES ('34 TL 34');

INSERT INTO DELIVERY_POINT (id, name, supported_shipment_type) VALUES (1, 'Branch', 'P');
INSERT INTO DELIVERY_POINT (id, name) VALUES (2, 'Distribution Center');
INSERT INTO DELIVERY_POINT (id, name, supported_shipment_type) VALUES (3, 'Transfer Center', 'B');

INSERT INTO BAG (barcode, delivery_point_value, status) VALUES ('C725799', 2, 'C');
INSERT INTO BAG (barcode, delivery_point_value, status) VALUES ('C725800', 3, 'C');

INSERT INTO PACKAGE (barcode, weight, delivery_point_value, status) VALUES ('P7988000121', 5, 1, 'C');
INSERT INTO PACKAGE (barcode, weight, delivery_point_value, status) VALUES ('P7988000122', 5, 1, 'C');
INSERT INTO PACKAGE (barcode, weight, delivery_point_value, status) VALUES ('P7988000123', 9, 1, 'C');
INSERT INTO PACKAGE (barcode, weight, delivery_point_value, status) VALUES ('P8988000120', 33, 2, 'C');
INSERT INTO PACKAGE (barcode, weight, delivery_point_value, status) VALUES ('P8988000121', 17, 2, 'C');
INSERT INTO PACKAGE (barcode, weight, delivery_point_value, status) VALUES ('P8988000122', 26, 2, 'C');
INSERT INTO PACKAGE (barcode, weight, delivery_point_value, status) VALUES ('P8988000123', 35, 2, 'C');
INSERT INTO PACKAGE (barcode, weight, delivery_point_value, status) VALUES ('P8988000124', 1, 2, 'C');
INSERT INTO PACKAGE (barcode, weight, delivery_point_value, status) VALUES ('P8988000125', 200, 2, 'C');
INSERT INTO PACKAGE (barcode, weight, delivery_point_value, status) VALUES ('P8988000126', 50, 2, 'C');
INSERT INTO PACKAGE (barcode, weight, delivery_point_value, status) VALUES ('P9988000126', 15, 3, 'C');
INSERT INTO PACKAGE (barcode, weight, delivery_point_value, status) VALUES ('P9988000127', 16, 3, 'C');
INSERT INTO PACKAGE (barcode, weight, delivery_point_value, status) VALUES ('P9988000128', 55, 3, 'C');
INSERT INTO PACKAGE (barcode, weight, delivery_point_value, status) VALUES ('P9988000129', 28, 3, 'C');
INSERT INTO PACKAGE (barcode, weight, delivery_point_value, status) VALUES ('P9988000130', 17, 3, 'C');

INSERT INTO BAG_PACKAGE_LIST (bag_barcode, package_list_barcode) values ('C725799', 'P8988000122');
INSERT INTO BAG_PACKAGE_LIST (bag_barcode, package_list_barcode) values ('C725799', 'P8988000126');
INSERT INTO BAG_PACKAGE_LIST (bag_barcode, package_list_barcode) values ('C725800', 'P9988000128');
INSERT INTO BAG_PACKAGE_LIST (bag_barcode, package_list_barcode) values ('C725800', 'P9988000129');

update package set bag_barcode = 'C725799' where barcode in ('P8988000122', 'P8988000126');
update package set bag_barcode = 'C725800' where barcode in ('P9988000128', 'P9988000129');

update package set status = 'LIB' where barcode in ('P8988000122', 'P8988000126', 'P9988000128', 'P9988000129')

