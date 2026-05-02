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

-- Insertar datos de ejemplo de servicios
INSERT INTO servicios (nombre, descripcion, precio, duracion_minutos, activo) 
VALUES 
('Corte de Cabello', 'Corte y estilo personalizado', 25.00, 45, true),
('Tratamiento Facial', 'Limpieza profunda y revitalización', 45.00, 60, true),
('Masaje Relajante', 'Masaje de cuerpo completo relajante', 60.00, 90, true),
('Tinte de Cabello', 'Tinte y matización del color', 35.00, 60, true),
('Depilación', 'Depilación en zonas diversas', 20.00, 30, true);

-- Insertar datos de ejemplo de citas
INSERT INTO citas (cliente_id, servicio_id, fecha_hora, estado, descuento, notas) 
VALUES 
(1, 1, '2026-04-25 10:00:00', 'confirmada', 5000, 'Corte regular'),
(2, 2, '2026-04-25 14:30:00', 'confirmada', 0, 'Primera cita'),
(3, 3, '2026-04-26 15:00:00', 'pendiente', 0, 'Requiere confirmación'),
(4, 4, '2026-04-26 09:30:00', 'confirmada', 0, 'Tinte refrescante'),
(5, 5, '2026-04-26 11:00:00', 'confirmada', 5000, 'Depilación piernas'),
(6, 1, '2026-04-27 10:30:00', 'confirmada', 0, 'Corte y peinado'),
(7, 2, '2026-04-27 13:00:00', 'pendiente', 0, 'Tratamiento facial'),
(8, 3, '2026-04-27 16:00:00', 'confirmada', 10000, 'Masaje relajante'),
(9, 4, '2026-04-28 09:00:00', 'confirmada', 0, 'Tinte y mechas'),
(10, 5, '2026-04-28 11:30:00', 'confirmada', 5000, 'Depilación axilas'),
(11, 1, '2026-04-28 14:00:00', 'pendiente', 0, 'Corte desvanecido'),
(12, 2, '2026-04-29 10:00:00', 'confirmada', 0, 'Limpieza profunda'),
(13, 3, '2026-04-29 15:30:00', 'confirmada', 10000, 'Masaje espalda'),
(14, 4, '2026-04-29 12:00:00', 'confirmada', 5000, 'Tinte castaño'),
(15, 5, '2026-04-30 09:30:00', 'confirmada', 0, 'Depilación bikini'),
(16, 1, '2026-04-30 13:00:00', 'pendiente', 0, 'Corte moderno'),
(17, 2, '2026-04-30 15:00:00', 'confirmada', 0, 'Revitalización facial'),
(18, 3, '2026-05-01 10:00:00', 'confirmada', 10000, 'Masaje completo'),
(19, 4, '2026-05-01 12:30:00', 'confirmada', 5000, 'Tinte oscuro'),
(20, 5, '2026-05-01 14:00:00', 'confirmada', 0, 'Depilación brazos'),
(21, 1, '2026-05-02 09:00:00', 'confirmada', 0, 'Corte clásico'),
(22, 2, '2026-05-02 11:00:00', 'pendiente', 0, 'Tratamiento completo'),
(23, 3, '2026-05-02 16:00:00', 'confirmada', 10000, 'Masaje terapéutico'),
(24, 4, '2026-05-02 13:30:00', 'confirmada', 5000, 'Tinte y alisado'),
(25, 5, '2026-05-03 10:30:00', 'confirmada', 0, 'Depilación total'),
(26, 1, '2026-05-03 12:00:00', 'confirmada', 0, 'Corte y tinte'),
(27, 2, '2026-05-03 14:30:00', 'confirmada', 0, 'Facial con masaje'),
(28, 3, '2026-05-04 11:00:00', 'pendiente', 10000, 'Masaje relajante'),
(29, 4, '2026-05-04 15:00:00', 'confirmada', 5000, 'Tinte y peinado'),
(30, 5, '2026-05-04 09:00:00', 'confirmada', 0, 'Depilación piernas'),
(31, 1, '2026-05-05 10:30:00', 'confirmada', 0, 'Corte desvanecido'),
(32, 2, '2026-05-05 13:00:00', 'confirmada', 0, 'Limpieza facial'),
(33, 3, '2026-05-05 15:30:00', 'confirmada', 10000, 'Masaje completo');
