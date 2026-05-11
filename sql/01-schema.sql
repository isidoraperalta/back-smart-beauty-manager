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

-- Crear tabla categorias
CREATE TABLE IF NOT EXISTS categorias (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

-- Crear tabla tipos
CREATE TABLE IF NOT EXISTS tipos (
    id BIGSERIAL PRIMARY KEY,
    categoria_id BIGINT NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    activo BOOLEAN DEFAULT true,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id)
);

-- Crear tabla acciones
CREATE TABLE IF NOT EXISTS acciones (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

-- Crear tabla servicios (intermedia: tipo + accion = servicio específico)
CREATE TABLE IF NOT EXISTS servicios (
    id BIGSERIAL PRIMARY KEY,
    tipo_id BIGINT NOT NULL,
    accion_id BIGINT NOT NULL,
    precio BIGINT NOT NULL,
    duracion_minutos INTEGER NOT NULL,
    FOREIGN KEY (tipo_id) REFERENCES tipos(id),
    FOREIGN KEY (accion_id) REFERENCES acciones(id)
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