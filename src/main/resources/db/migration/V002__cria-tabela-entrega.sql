create table public.entrega (
  id bigint not null,
  id_cliente bigint not null,
  status CHARACTER VARYING(20) not null,
  taxa numeric(19,5),
  data_pedido TIMESTAMP WITHOUT TIME ZONE not null,
  data_finalizacao TIMESTAMP WITHOUT TIME ZONE,
  destinatario_nome CHARACTER VARYING(100) not null,
  destinatario_logradouro CHARACTER VARYING(100) not null,
  destinatario_numero CHARACTER VARYING(30) not null,
  destinatario_complemento CHARACTER VARYING(100) not null,
  destinatario_bairro CHARACTER VARYING(30) not null,
  PRIMARY KEY(id),
  CONSTRAINT fk_entrega_cliente FOREIGN KEY(id_cliente) REFERENCES public.cliente(id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE SEQUENCE public.seq_entrega;
