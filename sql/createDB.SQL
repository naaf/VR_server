/*
Created: 24/05/2015
Modified: 25/05/2015
Model: VR
Database: PostgreSQL 9.2
*/






-- Drop keys for tables section -------------------------------------------------

ALTER TABLE "depot" DROP CONSTRAINT "Key5"
;
ALTER TABLE "message" DROP CONSTRAINT "Key4"
;
ALTER TABLE "fil_actualite" DROP CONSTRAINT "Key3"
;
ALTER TABLE "utilisateur" DROP CONSTRAINT "Key2"
;
ALTER TABLE "residence" DROP CONSTRAINT "users_pkey"
;



-- Drop tables section ---------------------------------------------------

DROP TABLE "depot"
;
DROP TABLE "message"
;
DROP TABLE "fil_actualite"
;
DROP TABLE "utilisateur"
;
DROP TABLE "residence"
;


-- Create tables section -------------------------------------------------

-- Table residence

CREATE TABLE "residence"(
 "id" Serial NOT NULL,
 "name" Character varying(128) NOT NULL,
 "number" Integer NOT NULL,
 "street_name" Character varying(256) NOT NULL,
 "city" Character varying(256) NOT NULL,
 "zip_code" Character varying(128) NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table residence

ALTER TABLE "residence" ADD CONSTRAINT "users_pkey" PRIMARY KEY ("id")
;

-- Table utilisateur

CREATE TABLE "utilisateur"(
 "id" Serial NOT NULL,
 "name" Character varying(64) NOT NULL,
 "surname" Character varying(64) NOT NULL,
 "email" Character varying(128) NOT NULL,
 "password" Character varying(256) NOT NULL,
 "role" Character varying(32) NOT NULL,
 "type_habitant" Character varying(32)
)
WITH (OIDS=FALSE)
;

-- Add keys for table utilisateur

ALTER TABLE "utilisateur" ADD CONSTRAINT "Key2" PRIMARY KEY ("id")
;

-- Table fil_actualite

CREATE TABLE "fil_actualite"(
 "id" Serial NOT NULL,
 "suject" Character varying(256) NOT NULL,
 "date_creation" Timestamp NOT NULL,
 "body" Text,
 "from_id" Integer NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table fil_actualite

ALTER TABLE "fil_actualite" ADD CONSTRAINT "Key3" PRIMARY KEY ("id")
;

-- Table message

CREATE TABLE "message"(
 "id" Serial NOT NULL,
 "from_id" Integer NOT NULL,
 "to_id" Integer NOT NULL,
 "suject" Character varying(256),
 "body" Text,
 "date_creation" Timestamp NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table message

ALTER TABLE "message" ADD CONSTRAINT "Key4" PRIMARY KEY ("id")
;

-- Table depot

CREATE TABLE "depot"(
 "id" Serial NOT NULL,
 "image" Bytea NOT NULL,
 "suject" Character varying(256) NOT NULL,
 "body" Text NOT NULL,
 "disponibiilte" Character varying(15) NOT NULL,
 "from_id" Integer,
 "date_creation" Timestamp NOT NULL
)
WITH (OIDS=FALSE)
;

-- Add keys for table depot

ALTER TABLE "depot" ADD CONSTRAINT "Key5" PRIMARY KEY ("id")
;





