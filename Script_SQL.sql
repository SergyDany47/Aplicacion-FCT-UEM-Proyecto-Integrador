DROP TABLE tutor CASCADE CONSTRAINTS;
DROP TABLE centro CASCADE CONSTRAINTS;
DROP TABLE empresa CASCADE CONSTRAINTS;
DROP TABLE grupo CASCADE CONSTRAINTS;
DROP TABLE alumno CASCADE CONSTRAINTS;
DROP TABLE practica CASCADE CONSTRAINTS;
DROP TABLE colabora CASCADE CONSTRAINTS;
DROP TABLE gestiona CASCADE CONSTRAINTS;
DROP TABLE pertenece CASCADE CONSTRAINTS;
DROP TABLE users CASCADE CONSTRAINTS;
DROP TABLE registra CASCADE CONSTRAINTS;


CREATE TABLE alumno (
    dni         VARCHAR2(10 BYTE) NOT NULL,
    nombre      VARCHAR2(25 CHAR) NOT NULL,
    apellidos   VARCHAR2(55 CHAR) NOT NULL,
    num_exp     NUMBER(15) NOT NULL,
    fec_naci    date NOT NULL,
    nacionalidad VARCHAR2(55 CHAR) NOT NULL
);

ALTER TABLE alumno ADD CONSTRAINT alumno_pk PRIMARY KEY ( num_exp );

CREATE TABLE centro (
    cod_centro   NUMBER(1) NOT NULL,
    localidad    VARCHAR2(25 CHAR) NOT NULL,
    director     VARCHAR2(25 CHAR) NOT NULL,
    dat          VARCHAR2(25 CHAR) NOT NULL
);

ALTER TABLE centro ADD CONSTRAINT centro_pk PRIMARY KEY ( cod_centro );

CREATE TABLE colabora (
    centro_cod_centro   NUMBER(1) NOT NULL,
    empresa_cif         VARCHAR2(15 BYTE) NOT NULL,
    numconv             NUMBER NOT NULL,
    anexo_1             VARCHAR2(50 CHAR) NOT NULL,
    fecha               DATE NOT NULL
);

ALTER TABLE colabora ADD CONSTRAINT colabora_pk PRIMARY KEY ( centro_cod_centro,
                                                              empresa_cif );

CREATE TABLE empresa (
    cif         VARCHAR2(15 BYTE) NOT NULL,
    nombre      VARCHAR2(20 CHAR) NOT NULL,
    direccion   VARCHAR2(30 CHAR) NOT NULL,
    telefono    NUMBER(12) NOT NULL,
    resp_e      VARCHAR2(50 CHAR) NOT NULL,
    localidad   VARCHAR2(50 CHAR) NOT NULL
);

ALTER TABLE empresa ADD CONSTRAINT empresa_pk PRIMARY KEY ( cif );

CREATE TABLE gestiona (
    tutor_dni_tutor   VARCHAR2(9 BYTE) NOT NULL,
    grupo_cod_grupo   NUMBER(5) NOT NULL,
    fecha             DATE NOT NULL,
    anexo_2_2         DATE NOT NULL,
    anio_academico    VARCHAR2(50 CHAR)
);

ALTER TABLE gestiona ADD CONSTRAINT gestiona_pk PRIMARY KEY ( tutor_dni_tutor,
                                                              grupo_cod_grupo );

CREATE TABLE grupo (
    cod_grupo      NUMBER(5) NOT NULL,
    nom_grupo      VARCHAR2(50 CHAR) NOT NULL,
    clave_ciclo    NUMBER(10) NOT NULL,
    nombre_ciclo   VARCHAR2(50 CHAR) NOT NULL
);

ALTER TABLE grupo ADD CONSTRAINT grupo_pk PRIMARY KEY ( cod_grupo );

CREATE TABLE pertenece (
    grupo_cod_grupo   NUMBER(5) NOT NULL,
    alumno_num_exp    NUMBER(15) NOT NULL,
    anio_academico    VARCHAR2(50 CHAR)
);

ALTER TABLE pertenece ADD CONSTRAINT pertenece_pk PRIMARY KEY ( grupo_cod_grupo,
                                                                alumno_num_exp );

CREATE TABLE practica (
    empresa_cif      VARCHAR2(15 BYTE) NOT NULL,
    alumno_num_exp   NUMBER(15) NOT NULL,
    anexo_2_1        DATE NOT NULL,
    anexo_3          DATE NOT NULL,
    anexo_7          DATE NOT NULL,
    anexo_8          DATE NOT NULL,
    fecha_ini        DATE NOT NULL,
    fecha_fin        DATE NOT NULL,
    email_t          VARCHAR2(50 CHAR),
    horario          VARCHAR2(50 CHAR) NOT NULL,
    tutore           VARCHAR2(50 CHAR) NOT NULL,
    anio_academico   VARCHAR2(50 CHAR)
);

ALTER TABLE practica ADD CONSTRAINT relation_8_pk PRIMARY KEY ( empresa_cif, alumno_num_exp );

CREATE TABLE tutor (
    dni_tutor           VARCHAR2(9 BYTE) NOT NULL,
    nombre              VARCHAR2(25 CHAR) NOT NULL,
    apellidos           VARCHAR2(50 CHAR) NOT NULL,
    centro_cod_centro   NUMBER(1)
);

ALTER TABLE tutor ADD CONSTRAINT tutor_pk PRIMARY KEY ( dni_tutor );

CREATE TABLE users (
    usr                 VARCHAR2(50  CHAR) NOT NULL,
    rol                 VARCHAR2(50 CHAR) NOT NULL,
    pwd                 VARCHAR2(50 CHAR) NOT NULL,
    email               VARCHAR2(50 CHAR) NOT NULL
);

ALTER TABLE users ADD CONSTRAINT users_pk PRIMARY KEY ( usr );

CREATE TABLE registra (
    usr                 VARCHAR2(50  CHAR) NOT NULL,
    dni_tutor           VARCHAR2(9 BYTE) NOT NULL
   
);
ALTER TABLE registra ADD CONSTRAINT registra_pk PRIMARY KEY ( usr,dni_tutor );

ALTER TABLE colabora
    ADD CONSTRAINT colabora_centro_fk FOREIGN KEY ( centro_cod_centro )
        REFERENCES centro ( cod_centro );

ALTER TABLE colabora
    ADD CONSTRAINT colabora_empresa_fk FOREIGN KEY ( empresa_cif )
        REFERENCES empresa ( cif ) ON DELETE CASCADE;

ALTER TABLE gestiona
    ADD CONSTRAINT gestiona_grupo_fk FOREIGN KEY ( grupo_cod_grupo )
        REFERENCES grupo ( cod_grupo );

ALTER TABLE gestiona
    ADD CONSTRAINT gestiona_tutor_fk FOREIGN KEY ( tutor_dni_tutor )
        REFERENCES tutor ( dni_tutor ) ON DELETE CASCADE;

ALTER TABLE pertenece
    ADD CONSTRAINT pertenece_alumno_fk FOREIGN KEY ( alumno_num_exp )
        REFERENCES alumno ( num_exp ) ON DELETE CASCADE;

ALTER TABLE pertenece
    ADD CONSTRAINT pertenece_grupo_fk FOREIGN KEY ( grupo_cod_grupo )
        REFERENCES grupo ( cod_grupo );

ALTER TABLE practica
    ADD CONSTRAINT relation_8_alumno_fk FOREIGN KEY ( alumno_num_exp )
        REFERENCES alumno ( num_exp ) ON DELETE CASCADE;

ALTER TABLE practica
    ADD CONSTRAINT relation_8_empresa_fk FOREIGN KEY ( empresa_cif )
        REFERENCES empresa ( cif ) ON DELETE CASCADE;

ALTER TABLE tutor
    ADD CONSTRAINT tutor_centro_fk FOREIGN KEY ( centro_cod_centro )
        REFERENCES centro ( cod_centro );
        
ALTER TABLE registra
    ADD CONSTRAINT registra_tutor_fk FOREIGN KEY (dni_tutor)
        REFERENCES tutor ( dni_tutor ) ON DELETE CASCADE;

ALTER TABLE registra
    ADD CONSTRAINT registra_users_fk FOREIGN KEY ( usr )
        REFERENCES users ( usr );
        

        
        
INSERT INTO alumno(dni, nombre, apellidos, num_exp, fec_naci, nacionalidad) VALUES('594131t', 'Juan', 'Perez Garcia',1523547, '09/11/1997', 'Francesa');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, fec_naci, nacionalidad) VALUES('644131t', 'Alvaro', 'Eustakio Bichuela',1623547, '09/11/2000', 'Española');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, fec_naci, nacionalidad) VALUES('784131t', 'Sebas', 'Garcia Garcia',1723547, '09/11/2001', 'Indu');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, fec_naci, nacionalidad) VALUES('224131t', 'Ivan', 'Perez Alvarez',1583547, '09/11/1997', 'Ingles');
INSERT INTO alumno(dni, nombre, apellidos, num_exp, fec_naci, nacionalidad) VALUES('094131t', 'Sergio', 'Perez Perez',1593547, '09/11/1999', 'Ruso');

INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(4, 'villaviciosa', 'Ana','pepito');
INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(1, 'villaviciosa', 'Maria','pepito Norte');
INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(2, 'villaviciosa', 'Francisco','pepito Sur');
INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(3, 'villaviciosa', 'Jose','pepito Este');
INSERT INTO centro(cod_centro, localidad, director, DAT) VALUES(5, 'villaviciosa', 'Paula','pepito Oeste');


INSERT INTO empresa(cif, nombre, direccion, telefono, resp_e, localidad) VALUES('dfkj3156', 'algo S.A.', 'c/Miseria Nยบ69', 666666666,'Pedro Camacho', 'Las Penas');
INSERT INTO empresa(cif, nombre, direccion, telefono, resp_e, localidad) VALUES('hykj3156', 'cosa S.A.', 'c/Peseta Nยบ69', 777777777,'Raul Camacho', 'Las Panas');
INSERT INTO empresa(cif, nombre, direccion, telefono, resp_e, localidad) VALUES('sdkj3156', 'toma S.A.', 'c/Euro Nยบ69', 888888888,'Ernesto Camacho', 'Las Pinas');
INSERT INTO empresa(cif, nombre, direccion, telefono, resp_e, localidad) VALUES('grkj3156', 'raro S.A.', 'c/Dolar Nยบ69', 999999999,'Juanjo Camacho', 'Las Ponas');
INSERT INTO empresa(cif, nombre, direccion, telefono, resp_e, localidad) VALUES('twkj3156', 'malo S.A.', 'c/Libra Nยบ69', 123456789,'David Camacho', 'Las Punas');

INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(3, 'WomanDAM', 0043, 'DAM');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(2, 'DarkBallDAW', 0041, 'DAW');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(1, 'JavaSoulsASIR', 0042, 'ASIR');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(4, 'CriticalErrorTAFAD', 0044, 'TAFAD');
INSERT INTO grupo(cod_grupo, nom_grupo, clave_ciclo, nombre_ciclo) VALUES(5, 'UniversityTELECO', 0045, 'TELECO');

INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('159863p', 'Juan Carlos', 'Monedero Vacio', 4);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('569863f', 'Paco', 'Moreno', 1);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('919863s', 'Carlos', 'Mora', 2);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('559863d', 'Juan', 'Moro', 3);
INSERT INTO tutor(dni_tutor, nombre, apellidos, centro_cod_centro) VALUES('152263l', 'Jose', 'Romero', 5);

INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(4,'dfkj3156', 154895, '7/11/15', '10/11/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(1,'hykj3156', 188895, '7/11/15', '10/11/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(3,'sdkj3156', 155895, '7/11/15', '10/11/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(2,'grkj3156', 144895, '7/11/15', '10/11/12');
INSERT INTO colabora(centro_cod_centro, empresa_cif, numconv, anexo_1, fecha) VALUES(5,'twkj3156', 199895, '7/11/15', '10/11/12');

INSERT INTO gestiona(tutor_dni_tutor, grupo_cod_grupo, fecha, anexo_2_2, anio_academico) VALUES('159863p',3, '9/8/17', '7/12/15', '2019/2020');
INSERT INTO gestiona(tutor_dni_tutor, grupo_cod_grupo, fecha, anexo_2_2, anio_academico) VALUES('569863f',1, '9/8/17', '7/12/15', '2019/2020');
INSERT INTO gestiona(tutor_dni_tutor, grupo_cod_grupo, fecha, anexo_2_2, anio_academico) VALUES('919863s',2, '9/8/17', '7/12/15', '2019/2020');
INSERT INTO gestiona(tutor_dni_tutor, grupo_cod_grupo, fecha, anexo_2_2, anio_academico) VALUES('559863d',4, '9/8/17', '7/12/15', '2019/2020');
INSERT INTO gestiona(tutor_dni_tutor, grupo_cod_grupo, fecha, anexo_2_2, anio_academico) VALUES('152263l',5, '9/8/17', '7/12/15', '2019/2020');

INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, email_t, horario,tutore, anio_academico) VALUES('dfkj3156', 1523547, '7/11/15', '7/11/15', '7/11/15', '7/11/15', '7/11/15', '7/11/15', 'tutor@gmail.com','de 9 a 5', 'Dolores Fuertes de Barriga', '2019/2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, email_t, horario,tutore, anio_academico) VALUES('hykj3156', 1623547, '7/11/15', '7/11/15', '7/11/15', '7/11/15', '7/11/15', '7/11/15', 'tutor1@gmail.com','de 8 a 5', 'Dolores Fuertes de Pierna', '2019/2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, email_t, horario,tutore,anio_academico) VALUES('sdkj3156', 1723547, '7/11/15', '7/11/15', '7/11/15', '7/11/15', '7/11/15', '7/11/15', 'tuto2@gmail.com','de 6 a 5', 'Dolores Fuertes de Cabeza', '2019/2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, email_t, horario,tutore, anio_academico) VALUES('grkj3156', 1583547, '7/11/15', '7/11/15', '7/11/15', '7/11/15', '7/11/15', '7/11/15', 'tuto3@gmail.com','de 5 a 5', 'Dolores Fuertes de Rodilla', '2019/2020');
INSERT INTO practica(empresa_cif, alumno_num_exp, anexo_2_1, anexo_3,anexo_7, anexo_8, fecha_ini, fecha_fin, email_t, horario,tutore, anio_academico) VALUES('twkj3156', 1593547, '7/11/15', '7/11/15', '7/11/15', '7/11/15', '7/11/15', '7/11/15', 'tutor4@gmail.com','de 4 a 5', 'Dolores Fuertes de Culo', '2019/2020');

INSERT INTO pertenece(grupo_cod_grupo, alumno_num_exp, Anio_academico) VALUES(3,1523547, '2019/2020');
INSERT INTO pertenece(grupo_cod_grupo, alumno_num_exp, Anio_academico) VALUES(2,1623547, '2019/2020');
INSERT INTO pertenece(grupo_cod_grupo, alumno_num_exp, Anio_academico) VALUES(1,1723547, '2019/2020');
INSERT INTO pertenece(grupo_cod_grupo, alumno_num_exp, Anio_academico) VALUES(4,1583547, '2019/2020');
INSERT INTO pertenece(grupo_cod_grupo, alumno_num_exp, Anio_academico) VALUES(5,1593547, '2019/2020');

INSERT INTO users(usr, rol, pwd, email) VALUES('Pedro','tutor', '1234', 'pedro@gmail.com');
INSERT INTO users(usr, rol, pwd, email) VALUES('Master','director', '1234', 'director@gmail.com');





/*SENTENCIAS SELECT

"SELECT * FROM sebas.users WHERE usr='" + usr + "' AND pwd='" + pwd + "'";
"SELECT rol FROM sebas.users WHERE usr='" + usr + "'";
"INSERT INTO sebas.users(usr, rol, pwd, email) VALUES(?, ?, ?, ?)";
"INSERT INTO sebas.alumno (dni,nombre,apellidos,num_exp,fec_naci,nacionalidad) VALUES(?, ?, ?, ?, ?, ?)";
"DELETE FROM sebas.alumno WHERE num_exp = ?";
"UPDATE sebas.alumno SET num_exp=?,dni=?,nombre=?,apellidos=?,fec_naci=?,nacionalidad=? WHERE dni=? ";
"INSERT INTO sebas.empresa (cif,nombre,direccion,telefono,resp_e,localidad) VALUES(?, ?, ?, ?, ?, ?)";
"DELETE FROM sebas.empresa WHERE cif=?";
"UPDATE sebas.empresa SET cif=?,nombre=?,direccion=?,telefono=?,resp_e=?,localidad=? WHERE cif=? ";
"INSERT INTO sebas.tutor (dni_tutor,nombre,apellidos,centro_cod_centro) VALUES(?, ?, ?, ?)";
"UPDATE sebas.tutor SET dni_tutor=?,nombre=?,apellidos=?,centro_cod_centro=? WHERE dni_tutor=? ";
"DELETE FROM sebas.tutor WHERE dni_tutor=?";
"Select dni, fec_naci from sebas.alumno where dni='"+dni+"'";


*/
