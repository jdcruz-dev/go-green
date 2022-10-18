-- Table: public.flight

-- DROP TABLE IF EXISTS public.flight;

CREATE TABLE IF NOT EXISTS public.flight
(
    id uuid NOT NULL,
    flight_number character varying COLLATE pg_catalog."default",
    departure_port character varying COLLATE pg_catalog."default",
    arrival_port character varying COLLATE pg_catalog."default",
	airline_code character varying COLLATE pg_catalog."default",
    departure_time timestamp with time zone,
    arrival_time timestamp with time zone,
    created_at timestamp with time zone,
    updated_at timestamp with time zone,
    deleted_at timestamp with time zone,
    CONSTRAINT flight_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.flight
    OWNER to postgres;