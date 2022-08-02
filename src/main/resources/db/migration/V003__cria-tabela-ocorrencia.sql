create table public.ocorrencia (
  id bigint not null,
  id_entrega bigint not null,
  descricao text not null,
  data_registro TIMESTAMP WITHOUT TIME ZONE not null,
  PRIMARY KEY(id),
  CONSTRAINT fk_ocorrencia_entrega FOREIGN KEY(id_entrega) REFERENCES public.entrega(id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE SEQUENCE public.seq_ocorrencia;
