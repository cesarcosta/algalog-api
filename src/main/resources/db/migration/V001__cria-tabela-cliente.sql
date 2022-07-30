create table public.cliente (
  id bigint primary key,
  nome CHARACTER VARYING(100) not null,
  email CHARACTER VARYING(100) null,
  telefone CHARACTER VARYING(15) null
)