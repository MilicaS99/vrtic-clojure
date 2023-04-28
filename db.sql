-- Database: seminarskirad

-- DROP DATABASE IF EXISTS seminarskirad;

CREATE DATABASE seminarskirad
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

    -- Table: public.Program

-- DROP TABLE IF EXISTS public."Program";

CREATE TABLE IF NOT EXISTS public."Program"
(
    "ProgramID" integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "Naziv" character(50) COLLATE pg_catalog."default",
    "Opis" character(50) COLLATE pg_catalog."default",
    CONSTRAINT "Program_pkey" PRIMARY KEY ("ProgramID")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Program"
    OWNER to postgres;

    -- Table: public.Vaspitac

-- DROP TABLE IF EXISTS public."Vaspitac";

CREATE TABLE IF NOT EXISTS public."Vaspitac"
(
    "VaspitacID" bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    "Ime" character(50) COLLATE pg_catalog."default",
    "Prezime" character(50) COLLATE pg_catalog."default",
    "Pol" character(50) COLLATE pg_catalog."default",
    "Kontakt" character(50) COLLATE pg_catalog."default",
    "Adresa" character(50) COLLATE pg_catalog."default",
    CONSTRAINT "Vaspitac_pkey" PRIMARY KEY ("VaspitacID")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Vaspitac"
    OWNER to postgres;

    -- Table: public.Grupa

-- DROP TABLE IF EXISTS public."Grupa";

CREATE TABLE IF NOT EXISTS public."Grupa"
(
    "GrupaID" bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    "NazivGrupe" character(50) COLLATE pg_catalog."default",
    "Uzrast" character(50) COLLATE pg_catalog."default",
    "ProgramID" bigint,
    "VaspitacID" bigint,
    CONSTRAINT "Grupa_pkey" PRIMARY KEY ("GrupaID"),
    CONSTRAINT "ProgramID" FOREIGN KEY ("ProgramID")
        REFERENCES public."Program" ("ProgramID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "VaspitacID" FOREIGN KEY ("VaspitacID")
        REFERENCES public."Vaspitac" ("VaspitacID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Grupa"
    OWNER to postgres;
-- Index: fki_ProgramID

-- DROP INDEX IF EXISTS public."fki_ProgramID";

CREATE INDEX IF NOT EXISTS "fki_ProgramID"
    ON public."Grupa" USING btree
    ("ProgramID" ASC NULLS LAST)
    TABLESPACE pg_default;
-- Index: fki_VaspitacID

-- DROP INDEX IF EXISTS public."fki_VaspitacID";

CREATE INDEX IF NOT EXISTS "fki_VaspitacID"
    ON public."Grupa" USING btree
    ("VaspitacID" ASC NULLS LAST)
    TABLESPACE pg_default;