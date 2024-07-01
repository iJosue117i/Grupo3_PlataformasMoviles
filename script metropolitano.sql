-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS metropolitano;

-- Usar la base de datos
USE metropolitano;

-- Crear la tabla usuarios con los campos simplificados
CREATE TABLE IF NOT EXISTS clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cli_nombre VARCHAR(100),
    cli_apellido VARCHAR(100),
    cli_correo VARCHAR(100) UNIQUE
);

CREATE TABLE IF NOT EXISTS tarjeta_metro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numero_tarjeta_metro VARCHAR(20) UNIQUE,
    id_usuario INT,
    id_tipo_tarjeta_metro INT,
    saldo DECIMAL(10, 2),
    FOREIGN KEY (id_usuario) REFERENCES clientes(id),
    FOREIGN KEY (id_tipo_tarjeta_metro) REFERENCES tipos_tarjeta_metro(id)
);

CREATE TABLE IF NOT EXISTS tipos_tarjeta_metro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50)
);

INSERT INTO tipos_tarjeta_metro (id, tipo) VALUES 
(1, 'Estándar'),
(2, 'Medio Pasaje Escolar'),
(3, 'Medio Pasaje Universitario');

-- tabla medios_pago para almacenar los datos de tarjetas de debito o credito
CREATE TABLE IF NOT EXISTS medios_pago (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_medio VARCHAR(20),
    numero_tarjeta VARCHAR(20),
    fecha_caducidad DATE,
    nombre_titular VARCHAR(100),
    codigo_cvv VARCHAR(4)
);

-- Tabla de transacciones para poder listar el historial de movimientos
CREATE TABLE IF NOT EXISTS transacciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_tarjeta INT,
    monto DECIMAL(10, 2),
    fecha_transaccion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    observaciones VARCHAR(255),
    id_medio_pago INT,
    FOREIGN KEY (id_tarjeta) REFERENCES tarjeta_metro(id),
    FOREIGN KEY (id_medio_pago) REFERENCES medios_pago(id)
);

-- registros de clientes
INSERT INTO clientes (id, cli_nombre, cli_apellido, cli_correo) VALUES 
(1, 'Juan', 'Pérez', 'juan.perez@example.com'),
(2, 'María', 'González', 'maria.gonzalez@example.com'),
(3, 'Carlos', 'López', 'carlos.lopez@example.com');

-- Datos de medios de pago
INSERT INTO medios_pago (id, tipo_medio, numero_tarjeta, fecha_caducidad, nombre_titular, codigo_cvv) 
VALUES 
(1, 'Tarjeta de Crédito', '1111222233334444', '2024-12-31', 'Juan Pérez', '123'),
(2, 'Tarjeta de Débito', '5555666677778888', '2025-06-30', 'María González', '456'),
(3, 'Tarjeta de Débito', '4444555577771111', '2025-09-02', 'Carlos López', '333');


select * from clientes;
select * from medios_pago;
select * from tarjeta_metro;


