
CREATE DATABASE IF NOT EXISTS metropolitano;

USE metropolitano;

CREATE TABLE IF NOT EXISTS clientes (
    cli_id INT NOT NULL AUTO_INCREMENT,
    cli_nombre VARCHAR(100)NOT NULL,
    cli_apellido VARCHAR(100)NOT NULL,
    cli_correo VARCHAR(100) NOT NULL,
    PRIMARY KEY(cli_id)
);

CREATE TABLE IF NOT EXISTS tipos_tarjeta_metro (
    tipos_tarjeta_metro_id INT NOT NULL AUTO_INCREMENT,
    tipo VARCHAR(50) NOT NULL,
	PRIMARY KEY (tipos_tarjeta_metro_id)
);

CREATE TABLE IF NOT EXISTS tarjeta_metro (
    tarjeta_metro_id INT NOT NULL AUTO_INCREMENT,
    numero_tarjeta_metro VARCHAR(20) NOT NULL,
    id_usuario INT NOT NULL,
    id_tipo_tarjeta_metro INT NOT NULL,
    saldo DECIMAL(10, 2) NOT NULL,
	PRIMARY KEY(tarjeta_metro_id),
    FOREIGN KEY (id_usuario) REFERENCES clientes(cli_id),
    FOREIGN KEY (id_tipo_tarjeta_metro) REFERENCES tipos_tarjeta_metro(tipos_tarjeta_metro_id)
);

INSERT INTO tipos_tarjeta_metro (tipos_tarjeta_metro_id, tipo) VALUES 
(null, 'Estándar'),
(null, 'Medio Pasaje Escolar'),
(null, 'Medio Pasaje Universitario');

-- tabla medios_pago para almacenar los datos de tarjetas de debito o credito
CREATE TABLE IF NOT EXISTS medios_pago (
    medios_pago_id INT NOT NULL AUTO_INCREMENT,
    tipo_medio VARCHAR(20)NOT NULL,
    numero_tarjeta VARCHAR(20)NOT NULL,
    fecha_caducidad DATE NOT NULL,
    nombre_titular VARCHAR(100)NOT NULL,
    codigo_cvv VARCHAR(4),
    PRIMARY KEY (medios_pago_id)
);

-- Tabla de transacciones para poder listar el historial de movimientos
CREATE TABLE IF NOT EXISTS transacciones (
    transacciones_id INT NOT NULL AUTO_INCREMENT,
    id_tarjeta INT NOT NULL,
    monto DECIMAL(10, 2) NOT NULL,
    fecha_transaccion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    observaciones VARCHAR(255) NOT NULL,
    id_medio_pago INT NOT NULL,
    PRIMARY KEY (transacciones_id),
    FOREIGN KEY (id_tarjeta) REFERENCES tarjeta_metro(tarjeta_metro_id),
    FOREIGN KEY (id_medio_pago) REFERENCES medios_pago(medios_pago_id)
);

-- registros de clientes
INSERT INTO clientes (cli_id, cli_nombre, cli_apellido, cli_correo) VALUES 
(null, 'Juan', 'Pérez', 'juan.perez@example.com'),
(null, 'María', 'González', 'maria.gonzalez@example.com'),
(null, 'Carlos', 'López', 'carlos.lopez@example.com');

-- Datos de medios de pago
INSERT INTO medios_pago (medios_pago_id, tipo_medio, numero_tarjeta, fecha_caducidad, nombre_titular, codigo_cvv) 
VALUES 
(null, 'Tarjeta de Crédito', '1111222233334444', '2024-12-31', 'Juan Pérez', '123'),
(null, 'Tarjeta de Débito', '5555666677778888', '2025-06-30', 'María González', '456'),
(null, 'Tarjeta de Débito', '4444555577771111', '2025-09-02', 'Carlos López', '333');


select * from clientes;
select * from medios_pago;
select * from tarjeta_metro;

drop database metropolitano


