-- Smart Beauty Manager - Database Schema
-- Script de creación de tablas y constraints
-- Ejecutar en: Producción y Desarrollo

-- Crear tabla clientes
CREATE TABLE IF NOT EXISTS clientes (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    telefono VARCHAR(255) NOT NULL,
    direccion VARCHAR(255),
    ciudad VARCHAR(255),
    notas TEXT
);

-- Crear tabla servicios
CREATE TABLE IF NOT EXISTS servicios (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    precio NUMERIC(19,2) NOT NULL,
    duracion_minutos INTEGER NOT NULL,
    activo BOOLEAN DEFAULT true
);

-- Crear tabla citas
CREATE TABLE IF NOT EXISTS citas (
    id BIGSERIAL PRIMARY KEY,
    cliente_id BIGINT NOT NULL,
    servicio_id BIGINT NOT NULL,
    fecha_hora TIMESTAMP NOT NULL UNIQUE,
    estado VARCHAR(255) NOT NULL,
    descuento BIGINT,
    notas TEXT,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id),
    FOREIGN KEY (servicio_id) REFERENCES servicios(id)
);
