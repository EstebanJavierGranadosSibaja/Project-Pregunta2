/*
Created: 16/05/2024
Modified: 22/05/2024
Model: Oracle 18c
Database: Oracle 18c
*/


-- Create tables section -------------------------------------------------

-- Table preg_preguntas

CREATE TABLE "preg_preguntas"(
  "pre_id" Number NOT NULL,
  "pre_texto_pregunta" Varchar2(250 ) NOT NULL,
  "pre_cantidad_respondidas" Number NOT NULL,
  "pre_cantidad_aciertos" Number NOT NULL,
  "cat_id" Number
)
/

-- Create indexes for table preg_preguntas

CREATE INDEX "IX_preg_cat_res" ON "preg_preguntas" ("cat_id")
/

-- Add keys for table preg_preguntas

ALTER TABLE "preg_preguntas" ADD CONSTRAINT "PK_preg_preguntas" PRIMARY KEY ("pre_id")
/

-- Table preg_respuestas

CREATE TABLE "preg_respuestas"(
  "res_id" Number NOT NULL,
  "res_respuesta" Varchar2(250 ) NOT NULL,
  "res_es_correcta" Char(1 ) NOT NULL,
  "res_cantidad_seleccionada" Number NOT NULL,
  "pre_id" Number
)
/

-- Create indexes for table preg_respuestas

CREATE INDEX "IX_preg_pre_res" ON "preg_respuestas" ("pre_id")
/

-- Add keys for table preg_respuestas

ALTER TABLE "preg_respuestas" ADD CONSTRAINT "PK_preg_respuestas" PRIMARY KEY ("res_id")
/

-- Table preg_jugadores

CREATE TABLE "preg_jugadores"(
  "jug_id" Number NOT NULL,
  "jug_nombre" Varchar2(50 ) NOT NULL,
  "jug_partidas_ganadas" Number NOT NULL
)
/

-- Add keys for table preg_jugadores

ALTER TABLE "preg_jugadores" ADD CONSTRAINT "PK_preg_jugadores" PRIMARY KEY ("jug_id")
/

-- Table preg_jugpartidas

CREATE TABLE "preg_jugpartidas"(
  "jpar_id" Number NOT NULL,
  "jpar_posicion_sector" Number NOT NULL,
  "jpar_posicion_casilla" Number NOT NULL,
  "jpar_cantidad_ayudas" Number NOT NULL,
  "jpar_doble_ayuda" Char(1 ),
  "jpar_pasar_ayuda" Char(1 ),
  "jpar_bomba_ayuda" Char(1 ),
  "jpar_extra_ayuda" Char(1 ),
  "jpar_cantidad_fichas" Number NOT NULL,
  "jpar_ficha_arte" Char(1 ),
  "jpar_ficha_historia" Char(1 ),
  "jpar_ficha_geografia" Char(1 ),
  "jpar_ficha_ciencias" Char(1 ),
  "jpar_ficha_entretenimiento" Char(1 ),
  "jpar_ficha_deporte" Char(1 ),
  "ppar_id" Number,
  "jug_id" Number
)
/

-- Create indexes for table preg_jugpartidas

CREATE INDEX "jug_jpar_FK" ON "preg_jugpartidas" ("ppar_id")
/

CREATE INDEX "ppar_jpar_FK" ON "preg_jugpartidas" ("jug_id")
/

-- Add keys for table preg_jugpartidas

ALTER TABLE "preg_jugpartidas" ADD CONSTRAINT "PK_preg_jugpartidas" PRIMARY KEY ("jpar_id")
/

-- Table preg_categorias

CREATE TABLE "preg_categorias"(
  "cat_id" Number NOT NULL,
  "cat_categoria" Varchar2(30 ) NOT NULL,
  "cat_cantidad_respondidas" Number NOT NULL,
  "cat_cantidad_aciertos" Number NOT NULL
)
/

-- Add keys for table preg_categorias

ALTER TABLE "preg_categorias" ADD CONSTRAINT "PK_preg_categorias" PRIMARY KEY ("cat_id")
/

-- Table preg_prinpartida

CREATE TABLE "preg_prinpartida"(
  "ppar_id" Number NOT NULL,
  "ppar_modo_juego" Char(1 ) NOT NULL,
  "ppar_tiempo_total" Timestamp(6),
  "ppar_tiempo_transcurrido" Timestamp(6),
  "ppar_cantidad_rondas" Number NOT NULL,
  "ppar_estado_partida" Char(1 ) NOT NULL
)
/

-- Add keys for table preg_prinpartida

ALTER TABLE "preg_prinpartida" ADD CONSTRAINT "PK_preg_prinpartida" PRIMARY KEY ("ppar_id")
/

-- Table preg_interpparpre

CREATE TABLE "preg_interpparpre"(
  "pre_id" Number NOT NULL,
  "ppar_id" Number NOT NULL
)
/

-- Add keys for table preg_interpparpre

ALTER TABLE "preg_interpparpre" ADD CONSTRAINT "PK_preg_interpparpre" PRIMARY KEY ("pre_id","ppar_id")
/

-- Table preg_interjugpre

CREATE TABLE "preg_interjugpre"(
  "jug_id" Number NOT NULL,
  "pre_id" Number NOT NULL
)
/

-- Add keys for table preg_interjugpre

ALTER TABLE "preg_interjugpre" ADD CONSTRAINT "PK_preg_interjugpre" PRIMARY KEY ("jug_id","pre_id")
/


-- Create foreign keys (relationships) section ------------------------------------------------- 

ALTER TABLE "preg_respuestas" ADD CONSTRAINT "pre_res_FK" FOREIGN KEY ("pre_id") REFERENCES "preg_preguntas" ("pre_id")
/



ALTER TABLE "preg_preguntas" ADD CONSTRAINT "cat_pre_FK" FOREIGN KEY ("cat_id") REFERENCES "preg_categorias" ("cat_id")
/



ALTER TABLE "preg_jugpartidas" ADD CONSTRAINT "ppar_jpar_FK" FOREIGN KEY ("ppar_id") REFERENCES "preg_prinpartida" ("ppar_id")
/



ALTER TABLE "preg_jugpartidas" ADD CONSTRAINT "jug_jpar_FK" FOREIGN KEY ("jug_id") REFERENCES "preg_jugadores" ("jug_id")
/



ALTER TABLE "preg_interpparpre" ADD CONSTRAINT "pre_interpparpre_FK" FOREIGN KEY ("pre_id") REFERENCES "preg_preguntas" ("pre_id")
/



ALTER TABLE "preg_interpparpre" ADD CONSTRAINT "ppar_interpparpre_FK" FOREIGN KEY ("ppar_id") REFERENCES "preg_prinpartida" ("ppar_id")
/



ALTER TABLE "preg_interjugpre" ADD CONSTRAINT "jug_interjugpre_FK" FOREIGN KEY ("jug_id") REFERENCES "preg_jugadores" ("jug_id")
/



ALTER TABLE "preg_interjugpre" ADD CONSTRAINT "jug_interpparpre_FK" FOREIGN KEY ("pre_id") REFERENCES "preg_preguntas" ("pre_id")
/
