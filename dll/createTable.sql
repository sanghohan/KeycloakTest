-- Table: public.audit_log

-- DROP TABLE IF EXISTS public.audit_log;

CREATE TABLE IF NOT EXISTS public.audit_log
(
    ip character varying(20) COLLATE pg_catalog."default" NOT NULL,
    uri character varying(300) COLLATE pg_catalog."default" NOT NULL,
    create_id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    create_dt timestamp without time zone NOT NULL,
    id bigint NOT NULL DEFAULT nextval('audit_log_id_seq'::regclass)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.audit_log
    OWNER to postgres;