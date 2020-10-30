CREATE TABLE PESSOA(
ID		SERIAL,
NAME		VARCHAR,
EMAIL		VARCHAR,
PASSWORD 	VARCHAR,
CONSTRAINT pk_pesssoa PRIMARY KEY (ID)
);


CREATE TABLE ELETRONICO(
ID 			SERIAL,
NAME 			VARCHAR,
MARCA			VARCHAR,
POTENCIA		NUMERIC,
TEMPO_USO		NUMERIC(4,2),
GASTO_DIA_WATTS		NUMERIC(6,2),
GASTO_MES_WATTS		NUMERIC(6,2),
GASTO_DIA_REAIS		NUMERIC(6,2),
GASTO_MES_REAIS		NUMERIC(6,2),
PESSOA_ID_FK		INTEGER,
CONSTRAINT pk_eletronico PRIMARY KEY (ID),
CONSTRAINT fk_eletronico FOREIGN KEY (PESSOA_ID_FK) 
REFERENCES PESSOA (ID) 
);

CREATE DATABASE "CONSUMO-WEBSERVICE"
ENCODING = 'UTF8'
CONNECTION LIMIT = -1;
