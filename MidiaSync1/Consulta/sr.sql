-- Table: teste_equipamento

-- DROP TABLE teste_equipamento;

CREATE TABLE teste_equipamento
(
  id character varying(255) NOT NULL,
  "version" bigint,
  cadastro_data timestamp without time zone NOT NULL,
  nomecliente character varying(255) NOT NULL,
  cadastro_time timestamp without time zone,
  CONSTRAINT teste_equipamento_pkey PRIMARY KEY (id)
)
WITH (OIDS=FALSE);
ALTER TABLE teste_equipamento OWNER TO postgres;
