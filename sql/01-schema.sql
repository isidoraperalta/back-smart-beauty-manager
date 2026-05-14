-- Smart Beauty Manager - Database Schema
-- Script de creación de tablas y constraints
-- Ejecutar en: Producción y Desarrollo

CREATE TABLE IF NOT EXISTS clientes (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    telefono VARCHAR(255) NOT NULL,
    direccion VARCHAR(255),
    fecha_nacimiento DATE,
    notas TEXT
);

CREATE TABLE IF NOT EXISTS categorias (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tipos (
    id BIGSERIAL PRIMARY KEY,
    categoria_id BIGINT NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    activo BOOLEAN DEFAULT true,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);

CREATE TABLE IF NOT EXISTS acciones (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS servicios (
    id BIGSERIAL PRIMARY KEY,
    tipo_id BIGINT NOT NULL,
    accion_id BIGINT NOT NULL,
    precio BIGINT NOT NULL,
    duracion_minutos INTEGER NOT NULL,
    dias_para_retocar INTEGER,
    FOREIGN KEY (tipo_id) REFERENCES tipos(id),
    FOREIGN KEY (accion_id) REFERENCES acciones(id),
    CONSTRAINT uq_servicios_tipo_accion UNIQUE (tipo_id, accion_id)
);

CREATE TABLE IF NOT EXISTS citas (
    id BIGSERIAL PRIMARY KEY,
    cliente_id BIGINT NOT NULL,
    servicio_id BIGINT NOT NULL,
    fecha_hora TIMESTAMP NOT NULL UNIQUE,
    estado VARCHAR(20) DEFAULT 'AGENDADA',
    lugar VARCHAR(20) DEFAULT 'LOCAL',
    descuento BIGINT,
    cargo_extra BIGINT,
    valor_total BIGINT,
    dias_para_retocar INTEGER,
    notas TEXT,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id),
    FOREIGN KEY (servicio_id) REFERENCES servicios(id)
);

CREATE TABLE IF NOT EXISTS usuarios (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);
