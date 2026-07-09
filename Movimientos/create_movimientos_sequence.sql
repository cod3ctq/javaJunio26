-- Ejecutar este script en la base de datos Oracle donde se encuentre la tabla MOVIMIENTOS
-- Ajustar el valor inicial si ya existen filas en la tabla.
CREATE SEQUENCE MOVIMIENTOS_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
