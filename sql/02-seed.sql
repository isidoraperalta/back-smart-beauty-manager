-- Smart Beauty Manager - Seed Data
-- Script de datos de ejemplo
-- Ejecutar en: Desarrollo y Testing SOLAMENTE
-- ⚠️ NO ejecutar en Producción

-- Insertar datos de ejemplo de clientes
INSERT INTO clientes (nombre, email, telefono, direccion, ciudad, notas) 
VALUES 
('María García', 'maria@example.com', '555-0001', 'Calle Mayor 123', 'Madrid', 'Cliente frecuente'),
('Carlos López', 'carlos@example.com', '555-0002', 'Avenida Central 456', 'Barcelona', 'Nuevo cliente'),
('Ana Martínez', 'ana@example.com', '555-0003', 'Plaza Principal 789', 'Valencia', 'Cliente VIP'),
('Sofia Rodríguez', 'sofia.r@example.com', '555-0004', 'Calle Libertad 234', 'Sevilla', 'Cliente regular'),
('Juan Fernández', 'juan.f@example.com', '555-0005', 'Paseo del Prado 567', 'Madrid', 'Nuevo'),
('Luisa Pérez', 'luisa.p@example.com', '555-0006', 'Avenida Diagonal 890', 'Barcelona', 'VIP'),
('Raúl Sánchez', 'raul.s@example.com', '555-0007', 'Calle Comercial 111', 'Valencia', 'Regular'),
('Mercedes Díaz', 'mercedes.d@example.com', '555-0008', 'Plaza Mayor 222', 'Bilbao', 'Cliente nuevo'),
('Javier Moreno', 'javier.m@example.com', '555-0009', 'Calle Principal 333', 'Alicante', 'Frecuente'),
('Isabel Gómez', 'isabel.g@example.com', '555-0010', 'Avenida Reina Sofía 444', 'Málaga', 'VIP'),
('Antonio Ruiz', 'antonio.r@example.com', '555-0011', 'Calle Mercado 555', 'Córdoba', 'Nuevo'),
('Beatriz Álvarez', 'beatriz.a@example.com', '555-0012', 'Paseo del Parque 666', 'Murcia', 'Regular'),
('Fernando Castillo', 'fernando.c@example.com', '555-0013', 'Calle Rosario 777', 'Valladolid', 'Cliente nuevo'),
('Natalia Jiménez', 'natalia.j@example.com', '555-0014', 'Avenida del Puerto 888', 'Palma', 'Frecuente'),
('Marcos Vázquez', 'marcos.v@example.com', '555-0015', 'Calle Nueva 999', 'Toledo', 'VIP'),
('Laura Herrera', 'laura.h@example.com', '555-0016', 'Plaza de la Revolución 101', 'Zaragoza', 'Nuevo'),
('Sergio Blanco', 'sergio.b@example.com', '555-0017', 'Calle del Sol 202', 'Salamanca', 'Regular'),
('Valentina Ortiz', 'valentina.o@example.com', '555-0018', 'Avenida Iberia 303', 'Oviedo', 'Cliente nuevo'),
('Ricardo Molina', 'ricardo.m@example.com', '555-0019', 'Calle Marina 404', 'Almería', 'Frecuente'),
('Camila Navarro', 'camila.n@example.com', '555-0020', 'Paseo Colón 505', 'Baleares', 'VIP'),
('Mateo Iglesias', 'mateo.i@example.com', '555-0021', 'Calle Comercio 606', 'Cuenca', 'Nuevo'),
('Adriana Reyes', 'adriana.r@example.com', '555-0022', 'Avenida Libertador 707', 'Guadalajara', 'Regular'),
('Cristian Acosta', 'cristian.a@example.com', '555-0023', 'Calle Frontera 808', 'Jaén', 'Cliente nuevo'),
('Victoria Santos', 'victoria.s@example.com', '555-0024', 'Plaza Central 909', 'León', 'Frecuente'),
('Andrés Cabrera', 'andres.c@example.com', '555-0025', 'Calle Histórica 1010', 'Segovia', 'VIP'),
('Daniela Fuentes', 'daniela.f@example.com', '555-0026', 'Avenida Industrial 1111', 'Ávila', 'Nuevo'),
('Eduardo Vargas', 'eduardo.v@example.com', '555-0027', 'Calle Flores 1212', 'Lugo', 'Regular'),
('Florencia Rivera', 'florencia.r@example.com', '555-0028', 'Paseo Marítimo 1313', 'Tarragona', 'Cliente nuevo'),
('Gustavo Ponce', 'gustavo.p@example.com', '555-0029', 'Calle Histórica 1414', 'Pontevedra', 'Frecuente'),
('Hortensia Mendoza', 'hortensia.m@example.com', '555-0030', 'Avenida Central 1515', 'Burgos', 'VIP'),
('Ignacio Campos', 'ignacio.c@example.com', '555-0031', 'Calle del Arte 1616', 'León', 'Nuevo'),
('Julieta Acuña', 'julieta.a@example.com', '555-0032', 'Plaza Histórica 1717', 'Soria', 'Regular'),
('Konstantin Romero', 'konstantin.r@example.com', '555-0033', 'Calle Vieja 1818', 'Teruel', 'Cliente nuevo');

-- Insertar datos de ejemplo de categorias
INSERT INTO categorias (nombre)
VALUES 
('Pestañas'),
('Uñas'),
('Masaje Facial');

-- Insertar datos de ejemplo de tipos
INSERT INTO tipos (categoria_id, nombre, descripcion, activo)
VALUES 
-- Categoría Pestañas (1)
(1, 'Pestañas Naturales', 'Extensión de pestañas volumen natural', true),
(1, 'Volumen Ruso', 'Extensión de pestañas volumen ruso', true),
-- Categoría Uñas (2)
(2, 'Uñas de Gel', 'Manicura con uñas de gel', true),
(2, 'Uñas Acrílicas', 'Manicura con uñas acrílicas', true),
-- Categoría Masaje Facial (3)
(3, 'Masaje Relajante', 'Masaje facial relajante y descontraete', true),
(3, 'Masaje Profundo', 'Masaje facial profundo y revitalizante', true);

-- Insertar datos de ejemplo de acciones
INSERT INTO acciones (nombre)
VALUES 
('Poner'),
('Retocar'),
('Retirar'),
('Otro'),
('No aplica');

-- Insertar datos de ejemplo de servicios (intermedia: tipo + accion)
INSERT INTO servicios (tipo_id, accion_id, precio, duracion_minutos)
VALUES 
-- Pestañas Naturales (tipo_id=1)
(1, 1, 50000, 60),
(1, 2, 25000, 30),
(1, 3, 15000, 20),
-- Volumen Ruso (tipo_id=2)
(2, 1, 65000, 75),
(2, 2, 30000, 35),
(2, 3, 15000, 20),
-- Uñas de Gel (tipo_id=3)
(3, 1, 40000, 45),
(3, 2, 20000, 25),
(3, 3, 15000, 20),
-- Uñas Acrílicas (tipo_id=4)
(4, 1, 45000, 50),
(4, 2, 22000, 28),
(4, 3, 15000, 20),
-- Masaje Relajante (tipo_id=5)
(5, 5, 60000, 60),
(5, 5, 30000, 30),
-- Masaje Profundo (tipo_id=6)
(6, 5, 75000, 75),
(6, 5, 35000, 40);

-- Insertar datos de ejemplo de citas
INSERT INTO citas (cliente_id, servicio_id, fecha_hora, estado, descuento, notas) 
VALUES 
-- Pestañas Naturales
(1, 1, '2026-05-10 10:00:00', 'confirmada', 0, 'Seda sintética. Alérgica a pegamentos a base de formol'),
(2, 2, '2026-05-10 14:30:00', 'confirmada', 0, 'Cliente prefiere extensiones más densas'),
(3, 3, '2026-05-11 15:00:00', 'pendiente', 0, 'Llegar 5 min antes. Ojo derecho sensible'),
-- Volumen Ruso
(4, 4, '2026-05-11 09:30:00', 'confirmada', 0, 'Primer servicio. Consultar densidad preferida'),
(5, 5, '2026-05-11 11:00:00', 'confirmada', 5000, 'Aficionada a volumen extremo. Oferta especial'),
(6, 6, '2026-05-12 10:30:00', 'confirmada', 0, 'Servicio rápido. Cliente con prisa'),
-- Uñas de Gel
(7, 7, '2026-05-12 13:00:00', 'pendiente', 0, 'Color neutro. Uñas frágiles naturalmente'),
(8, 8, '2026-05-12 16:00:00', 'confirmada', 10000, 'Clienta VIP. Descuento aplicado'),
(9, 9, '2026-05-13 09:00:00', 'confirmada', 0, 'Paciencia con puntas delicadas al retirar'),
-- Uñas Acrílicas
(10, 10, '2026-05-13 11:30:00', 'confirmada', 5000, 'Primer servicio. Color gradiente'),
(11, 11, '2026-05-13 14:00:00', 'pendiente', 0, 'Clienta regular. Mismo diseño que última vez'),
(12, 12, '2026-05-14 10:00:00', 'confirmada', 0, 'Cuidado con superficie delgada'),
-- Masaje Relajante
(13, 13, '2026-05-14 15:30:00', 'confirmada', 10000, 'Tensión en cervicales. Presión media-fuerte'),
(14, 14, '2026-05-14 12:00:00', 'confirmada', 5000, 'Cliente regular. Aroma de lavanda'),
-- Masaje Profundo
(15, 15, '2026-05-15 09:30:00', 'confirmada', 0, 'Contracturas en espalda. Masaje terapéutico'),
(16, 16, '2026-05-15 13:00:00', 'pendiente', 0, 'Sin aceites. Reacción alérgica previa'),
(17, 14, '2026-05-15 15:00:00', 'confirmada', 0, 'Cliente migrañosa. Enfoque en sienes'),
(18, 13, '2026-05-16 10:00:00', 'confirmada', 10000, 'Estrés laboral. Sesión completa relajante'),
(19, 11, '2026-05-16 12:30:00', 'confirmada', 5000, 'Cliente VIP con descuento'),
(20, 2, '2026-05-16 14:00:00', 'confirmada', 0, 'Cliente habitual. Extensiones sofisticadas');
