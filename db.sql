CREATE TABLE public.adm_user
(
  id integer NOT NULL DEFAULT nextval('adm_user_id_seq'::regclass),
  first_name character varying NOT NULL,
  last_name character varying NOT NULL,
  mobile_number character varying NOT NULL,
  email character varying NOT NULL,
  date_of_birth date,
  gender numeric(1,0),
  created_date timestamp(6) with time zone,
  created_by character varying(50),
  created_terminal character varying(50),
  update_date timestamp(6) with time zone,
  update_by character varying(50),
  update_terminal character varying(50),
  CONSTRAINT adm_user_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.adm_user
  OWNER TO postgres;