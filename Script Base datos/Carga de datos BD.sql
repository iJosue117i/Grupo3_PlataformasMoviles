INSERT INTO tipo_tarj_metro VALUES(NULL, 'estudiante');
INSERT INTO tipo_tarj_metro VALUES(NULL, 'regular');
SELECT * FROM tipo_tarj_metro;

INSERT INTO tarjeta_metro VALUES(null, '2.8', '1');
INSERT INTO tarjeta_metro VALUES(null, '4.6', '2');
INSERT INTO tarjeta_metro VALUES(null, '1.0', '1');
INSERT INTO tarjeta_metro VALUES(null, '4.5', '2');
INSERT INTO tarjeta_metro VALUES(null, '3.8', '1');
SELECT * FROM tarjeta_metro;

INSERT INTO pago_debito VALUES(null, '87437823', '2025-05-21','655') ;
INSERT INTO pago_debito VALUES(null, '32940239', '2026-07-09','322') ;
INSERT INTO pago_debito VALUES(null, '12938123', '2028-10-13','455') ;
SELECT * FROM pago_debito;


INSERT INTO recargas VALUES('1', '1','1','2014-06-21','5.0','Recarga exitosa');
INSERT INTO recargas VALUES('2', '2','2','2014-01-13','8.0','Recarga exitosa');
INSERT INTO recargas VALUES('3', '1','3','2014-04-11','3.0','Recarga fallida');
INSERT INTO recargas VALUES('4', '2','1','2014-03-09','1.0','Recarga exitosa');
INSERT INTO recargas VALUES('5', '1','3','2014-02-04','9.0','Recarga exitosa');
SELECT * FROM recargas;


INSERT INTO cliente VALUES(null, 'Carlos', 'Bautista', 'CarlosB@hotmail.com', '1234', '1');
INSERT INTO cliente VALUES(null, 'Vanesa', 'Perez', 'VanesaP@hotmail.com', '098778', '2');
INSERT INTO cliente VALUES(null, 'Juana', 'Villacorta', 'JuanaV@hotmail.com', '18984', '3');
INSERT INTO cliente VALUES(null, 'José', 'Vasquez', 'JoseV@hotmail.com', '34432', '4');
INSERT INTO cliente VALUES(null, 'Edgar', 'Alarcon', 'EdgarA@hotmail.com', '123123', '5');
SELECT * FROM cliente;