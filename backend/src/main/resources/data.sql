-- Insertar Salas
INSERT INTO rooms (id, name, capacity, floor, image_url) VALUES (1, 'Sala A', 10, 1, 'https://res.cloudinary.com/demo/image/upload/v1312461204/sample.jpg') ON CONFLICT (id) DO NOTHING;
INSERT INTO rooms (id, name, capacity, floor, image_url) VALUES (2, 'Sala B', 20, 1, 'https://res.cloudinary.com/demo/image/upload/v1312461204/sample.jpg') ON CONFLICT (id) DO NOTHING;
INSERT INTO rooms (id, name, capacity, floor, image_url) VALUES (3, 'Sala C', 8, 2, 'https://res.cloudinary.com/demo/image/upload/v1312461204/sample.jpg') ON CONFLICT (id) DO NOTHING;

-- Insertar Equipamiento (Asumiendo que la tabla se llama room_equipment y las columnas room_id y equipment)
-- Verificar el nombre de la tabla generada por Hibernate para @ElementCollection
INSERT INTO room_equipment (room_id, equipment) VALUES (1, 'Proyector');
INSERT INTO room_equipment (room_id, equipment) VALUES (1, 'Pizarra');
INSERT INTO room_equipment (room_id, equipment) VALUES (2, 'TV');
INSERT INTO room_equipment (room_id, equipment) VALUES (2, 'Videoconferencia');
INSERT INTO room_equipment (room_id, equipment) VALUES (3, 'Pizarra');

-- Actualizar la secuencia para evitar conflictos con futuros inserts
SELECT setval('room_id_seq', (SELECT MAX(id) FROM rooms));
