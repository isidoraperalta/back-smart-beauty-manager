-- Smart Beauty Manager - Seed Data
-- Script de datos de ejemplo
-- Ejecutar en: Desarrollo y Testing SOLAMENTE
-- ⚠️ NO ejecutar en Producción

-- Insertar datos de ejemplo de clientes
INSERT INTO clientes (nombre, email, telefono, direccion, fecha_nacimiento, fecha_registro, notas) 
VALUES 
('María García', 'maria@example.com', '+56 9 2234 5601', 'Avenida Providencia, 1234, Providencia', '1990-05-15', '2025-08-10', 'Alérgica a pegamentos a base de formol. Sensible en ojos'),
('Carolina López', 'carolina@example.com', '+56 9 2345 6702', 'Calle Lastarria, 456, Lastarria', '1985-08-22', '2025-09-05', 'Prefiere pestañas volumen natural. Sin acné'),
('Ana Martínez', 'ana@example.com', '+56 9 2456 7803', 'Paseo Huerfanos, 789, Santiago Centro', '1992-03-10', '2025-10-12', 'Piel sensible. Reacciona a productos químicos'),
('Sofia Rodríguez', 'sofia.r@example.com', '+56 9 2567 8904', 'Alameda, 2340, Estación Central', '1988-11-30', '2025-10-20', 'Ojo derecho irritable. Usar gafas protectoras'),
('Francisca Fernández', 'francisca.f@example.com', '+56 9 2678 9005', 'Avenida Apoquindo, 5670, Ñuñoa', '1991-07-18', '2025-11-03', 'Alergia a látex. Usar guantes alternativos'),
('Luisa Pérez', 'luisa.p@example.com', '+56 9 2789 0106', 'Calle Teatinos, 8900, Santiago Centro', '1987-09-25', '2025-11-15', 'Dermatitis crónica. Productos hipoalergénicos solo'),
('Rosario Sánchez', 'rosario.s@example.com', '+56 9 2890 1207', 'Paseo Ahumada, 1110, Santiago Centro', '1993-02-14', '2025-12-01', 'Astigmatismo. No usar productos fuertes en ojos'),
('Mercedes Díaz', 'mercedes.d@example.com', '+56 9 2901 2308', 'Avenida Los Leones, 2220, Las Condes', '1989-06-08', '2025-12-18', 'Párpados caídos. Extensiones más ligeras recomendadas'),
('Javiera Moreno', 'javiera.m@example.com', '+56 9 3012 3409', 'Calle Antonio López, 3333, Maipú', '1994-01-20', '2026-01-10', 'Sin alergias conocidas. Muy resistente a materiales'),
('Isabel Gómez', 'isabel.g@example.com', '+56 9 3123 4510', 'Avenida Manuel Montt, 4440, Ñuñoa', '1986-12-03', '2026-01-22', 'Migrañas frecuentes. Masajes relajantes solo'),
('Antonia Ruiz', 'antonia.r@example.com', '+56 9 3234 5611', 'Calle Lyon, 5550, Providencia', '1991-04-11', '2026-02-05', 'Uñas muy frágiles. Cuidado con procedimientos químicos'),
('Beatriz Álvarez', 'beatriz.a@example.com', '+56 9 3345 6712', 'Paseo Bandera, 6660, Santiago Centro', '1988-10-27', '2026-02-18', 'Alergia a acrílicos. Solo gel permitido'),
('Fernanda Castillo', 'fernanda.c@example.com', '+56 9 3456 7813', 'Avenida Constitución, 7770, Recoleta', '1992-08-05', '2026-03-02', 'Piel grasa en zona T. Usar productos específicos'),
('Natalia Jiménez', 'natalia.j@example.com', '+56 9 3567 8914', 'Calle Dieciocho, 8880, Conchalí', '1989-03-19', '2026-03-15', 'Hipersensible a olores fuertes. Ventilación bien'),
('Marcela Vázquez', 'marcela.v@example.com', '+56 9 3678 9015', 'Avenida Italia, 9990, San Miguel', '1987-11-12', '2026-03-28', 'Artritis en manos. No presionar puntos dolorosos'),
('Laura Herrera', 'laura.h@example.com', '+56 9 3789 0116', 'Paseo Matta, 1012, La Cisterna', '1993-05-23', '2026-04-08', 'Eczema en manos. Evitar contacto directo con químicos'),
('Sergio Blanco', 'sergio.b@example.com', '+56 9 3890 1217', 'Calle Los Dominicos, 2024, Las Condes', '1990-09-08', '2026-04-20', 'Primera vez con servicios de belleza. Guiar'),
('Valentina Ortiz', 'valentina.o@example.com', '+56 9 3901 2318', 'Avenida Bellavista, 3036, Ñuñoa', '1994-12-16', '2026-05-01', null),
('Rebeca Molina', 'rebeca.m@example.com', '+56 9 4012 3419', 'Calle Suecia, 4048, Quinta Normal', '1988-02-29', '2026-05-03', null),
('Camila Navarro', 'camila.n@example.com', '+56 9 4123 4520', 'Paseo Nuncio, 5060, San Bernardo', '1991-06-07', '2026-05-05', 'Piel muy blanca. Usar protector UV después'),
('Matilde Iglesias', 'matilde.i@example.com', '+56 9 4234 5621', 'Calle Doctor Soto Rodrigo, 6072, Huechuraba', '1986-08-14', '2026-05-07', 'Alergia a níquel. Evitar herramientas con níquel'),
('Adriana Reyes', 'adriana.r@example.com', '+56 9 4345 6722', 'Avenida Santa María, 7084, Independencia', '1992-04-09', '2026-05-09', 'Depresión. Ambiente relajante muy importante'),
('Cristina Acosta', 'cristina.a@example.com', '+56 9 4456 7823', 'Calle Vergara, 8096, Providencia', '1989-07-21', '2026-05-10', 'Sin alergias. Preferencia por productos naturales'),
('Victoria Santos', 'victoria.s@example.com', '+56 9 4567 8924', 'Paseo Andrés Bello, 9108, Ñuñoa', '1990-01-30', '2026-05-11', 'Estrés laboral. Masajes profundos necesarios'),
('Andreína Cabrera', 'andreina.c@example.com', '+56 9 4678 9025', 'Avenida Presidente Kennedy, 10120, La Florida', '1987-10-05', '2026-05-12', null),
('Daniela Fuentes', 'daniela.f@example.com', '+56 9 4789 0126', 'Calle Alonso Ovalle, 11132, Recoleta', '1993-09-13', '2026-05-13', 'Psoriasis leve en manos. Tratamientos específicos'),
('Eugenia Vargas', 'eugenia.v@example.com', '+56 9 4890 1227', 'Paseo Doña Isabel, 12144, Maipú', '1991-03-22', '2026-05-14', 'Alergia a formol. Verificar composición de productos'),
('Florencia Rivera', 'florencia.r@example.com', '+56 9 4901 2328', 'Avenida Ñuñoa, 13156, Ñuñoa', '1988-11-18', '2026-05-14', 'Fibromialgia. Presión suave en todo momento'),
('Graciela Ponce', 'graciela.p@example.com', '+56 9 5012 3429', 'Calle Darío, 14168, El Bosque', '1990-05-26', '2026-05-15', 'Alergia al parabeno. Productos sin parabeno solo'),
('Hortensia Mendoza', 'hortensia.m@example.com', '+56 9 5123 4530', 'Avenida Manquehue, 15180, Las Condes', '1992-07-11', '2026-05-15', 'Sensibilidad al calor. No usar secadores a alta temp'),
('Ignacia Campos', 'ignacia.c@example.com', '+56 9 5234 5631', 'Calle Eliodoro Yañez, 16192, San Miguel', '1989-12-04', '2026-05-16', 'Sin alergia. Aroma de lavanda relajante preferido'),
('Julieta Acuña', 'julieta.a@example.com', '+56 9 5345 6732', 'Paseo Santa Lucía, 17204, Santiago Centro', '1991-02-17', '2026-05-16', null),
('Konstanza Romero', 'konstanza.r@example.com', '+56 9 5456 7833', 'Avenida Tobalaba, 18216, Ñuñoa', '1986-06-28', '2026-05-16', null);

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
(3, 'Masaje Relajante Corto', 'Masaje facial relajante express (30 min)', true),
(3, 'Masaje Relajante Largo', 'Masaje facial relajante completo (60 min)', true),
(3, 'Masaje Profundo Corto', 'Masaje facial profundo express (40 min)', true),
(3, 'Masaje Profundo Largo', 'Masaje facial profundo completo (75 min)', true);

-- Insertar datos de ejemplo de acciones
INSERT INTO acciones (nombre)
VALUES 
('Aplicar'),
('Retocar'),
('Retirar'),
('Otro'),
('No aplica');

-- Insertar datos de ejemplo de servicios (intermedia: tipo + accion)
INSERT INTO servicios (tipo_id, accion_id, precio, duracion_minutos, dias_para_retocar)
VALUES 
-- Pestañas Naturales (tipo_id=1)
(1, 1, 50000, 60, 21),  -- Aplicar
(1, 2, 25000, 30, 21),  -- Retocar
(1, 3, 15000, 20, null),  -- Retirar
-- Volumen Ruso (tipo_id=2)
(2, 1, 65000, 75, 21),  -- Aplicar
(2, 2, 30000, 35, 21),  -- Retocar
(2, 3, 15000, 20, null),  -- Retirar
-- Uñas de Gel (tipo_id=3)
(3, 1, 40000, 45, 21),  -- Aplicar
(3, 2, 20000, 25, 21),  -- Retocar
(3, 3, 15000, 20, null),  -- Retirar
-- Uñas Acrílicas (tipo_id=4)
(4, 1, 45000, 50, 30),  -- Aplicar
(4, 2, 22000, 28, 30),  -- Retocar
(4, 3, 15000, 20, null),  -- Retirar
-- Masaje Relajante Corto (tipo_id=5)
(5, 5, 30000, 30, null),  -- No aplica
-- Masaje Relajante Largo (tipo_id=6)
(6, 5, 60000, 60, null),  -- No aplica
-- Masaje Profundo Corto (tipo_id=7)
(7, 5, 35000, 40, null),  -- No aplica
-- Masaje Profundo Largo (tipo_id=8)
(8, 5, 75000, 75, null);  -- No aplica

-- Insertar datos de ejemplo de citas
INSERT INTO citas (cliente_id, servicio_id, fecha_hora, estado, lugar, descuento, cargo_extra, valor_total, notas) 
VALUES 
-- Pestañas Naturales
(1, 1, '2026-05-10 10:00:00', 'CONFIRMADA', 'LOCAL', 0, null, 50000, 'Seda sintética. Alérgica a pegamentos a base de formol'),
(2, 2, '2026-05-10 14:30:00', 'CONFIRMADA', 'LOCAL', 0, null, 25000, 'Cliente prefiere extensiones más densas'),
(3, 3, '2026-05-11 15:00:00', 'AGENDADA', 'DOMICILIO', 0, null, 15000, 'Llegar 5 min antes. Ojo derecho sensible'),
-- Volumen Ruso
(4, 4, '2026-05-11 09:30:00', 'CONFIRMADA', 'LOCAL', 0, null, 65000, 'Primer servicio. Consultar densidad preferida'),
(5, 5, '2026-05-11 11:00:00', 'CONFIRMADA', 'DOMICILIO', 5000, null, 25000, 'Aficionada a volumen extremo. Oferta especial'),
(6, 6, '2026-05-12 10:30:00', 'CONFIRMADA', 'LOCAL', 0, null, 15000, 'Servicio rápido. Cliente con prisa'),
-- Uñas de Gel
(7, 7, '2026-05-12 13:00:00', 'AGENDADA', 'LOCAL', 0, null, 40000, 'Color neutro. Uñas frágiles naturalmente'),
(8, 8, '2026-05-12 16:00:00', 'CONFIRMADA', 'DOMICILIO', 10000, null, 10000, 'Clienta VIP. Descuento aplicado'),
(9, 9, '2026-05-13 09:00:00', 'CONFIRMADA', 'LOCAL', 0, null, 15000, 'Paciencia con puntas delicadas al retirar'),
-- Uñas Acrílicas
(10, 10, '2026-05-13 11:30:00', 'CONFIRMADA', 'LOCAL', 5000, null, 40000, 'Primer servicio. Color gradiente'),
(11, 11, '2026-05-13 14:00:00', 'AGENDADA', 'DOMICILIO', 0, null, 22000, 'Clienta regular. Mismo diseño que última vez'),
(12, 12, '2026-05-14 10:00:00', 'CONFIRMADA', 'LOCAL', 0, null, 15000, 'Cuidado con superficie delgada'),
-- Masaje Relajante
(13, 13, '2026-05-14 15:30:00', 'CONFIRMADA', 'LOCAL', 10000, null, 50000, 'Tensión en cervicales. Presión media-fuerte'),
(14, 14, '2026-05-14 12:00:00', 'CONFIRMADA', 'DOMICILIO', 5000, null, 25000, 'Cliente regular. Aroma de lavanda'),
-- Masaje Profundo
(15, 15, '2026-05-15 09:30:00', 'CONFIRMADA', 'LOCAL', 0, null, 75000, 'Contracturas en espalda. Masaje terapéutico'),
(16, 16, '2026-05-15 13:00:00', 'AGENDADA', 'DOMICILIO', 0, null, 35000, 'Sin aceites. Reacción alérgica previa'),
(17, 14, '2026-05-15 15:00:00', 'CONFIRMADA', 'LOCAL', 0, null, 30000, 'Cliente migrañosa. Enfoque en sienes'),
(18, 13, '2026-05-16 10:00:00', 'CONFIRMADA', 'DOMICILIO', 10000, null, 50000, 'Estrés laboral. Sesión completa relajante'),
(19, 11, '2026-05-16 12:30:00', 'CONFIRMADA', 'LOCAL', 5000, null, 17000, 'Cliente VIP con descuento'),
(20, 2, '2026-05-16 14:00:00', 'CONFIRMADA', 'DOMICILIO', 0, null, 25000, 'Cliente habitual. Extensiones sofisticadas');

-- Usuario predefinido (contraseña: admin123)
-- Hash generado con BCrypt 10 rounds
INSERT INTO usuarios (username, password)
VALUES 
('admin', '$2a$10$ICK9LzjTUHngMtJR5XtWauWGivzjerc.zVVFIBqCxEnPLIkKPHs52');