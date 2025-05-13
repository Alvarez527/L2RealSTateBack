-- DROP SCHEMA public;

CREATE SCHEMA IF NOT EXISTS public AUTHORIZATION pg_database_owner;

-- public.ciudades definition
-- Drop table
-- DROP TABLE IF EXISTS public.ciudades;

CREATE TABLE IF NOT EXISTS public.ciudades (
    id_ciudad int4 NOT NULL,
    ciudad text NOT NULL,
    CONSTRAINT ciudades_pkey PRIMARY KEY (id_ciudad)
);

-- public.clientes definition
-- Drop table
-- DROP TABLE IF EXISTS public.clientes;

CREATE TABLE IF NOT EXISTS public.clientes (
    id_cliente int4 NOT NULL,
    nombre_cliente text NOT NULL,
    telefono_cliente text NOT NULL,
    email_cliente text NOT NULL,
    CONSTRAINT clientes_pkey PRIMARY KEY (id_cliente)
);

-- public.colonias definition
-- Drop table
-- DROP TABLE IF EXISTS public.colonias;

CREATE TABLE IF NOT EXISTS public.colonias (
    id_colonia int4 NOT NULL,
    colonia text NOT NULL,
    CONSTRAINT colonias_pkey PRIMARY KEY (id_colonia)
);

-- public.estados definition
-- Drop table
-- DROP TABLE IF EXISTS public.estados;

CREATE TABLE IF NOT EXISTS public.estados (
    id_estado int4 NOT NULL,
    estado text NOT NULL,
    CONSTRAINT estados_pkey PRIMARY KEY (id_estado)
);

-- public.servicios definition
-- Drop table
-- DROP TABLE IF EXISTS public.servicios;

CREATE TABLE IF NOT EXISTS public.servicios (
    id_servicio int4 NOT NULL,
    servicio text NOT NULL,
    CONSTRAINT servicios_pkey PRIMARY KEY (id_servicio)
);

-- public.tipos_de_inmuebles definition
-- Drop table
-- DROP TABLE IF EXISTS public.tipos_de_inmuebles;

CREATE TABLE IF NOT EXISTS public.tipos_de_inmuebles (
    id_tipos_de_inmueble int4 NOT NULL,
    nombre_tipo text NOT NULL,
    CONSTRAINT tipos_de_inmuebles_pkey PRIMARY KEY (id_tipos_de_inmueble)
);

-- public.vendedores definition
-- Drop table
-- DROP TABLE IF EXISTS public.vendedores;

CREATE TABLE IF NOT EXISTS public.vendedores (
    id_vendedor int4 NOT NULL,
    nombre_vendedor text NOT NULL,
    telefono_vendedor text NOT NULL,
    email_vendedor text NOT NULL,
    CONSTRAINT vendedores_pkey PRIMARY KEY (id_vendedor)
);

-- public.inmuebles definition
-- Drop table
-- DROP TABLE IF EXISTS public.inmuebles;

CREATE TABLE IF NOT EXISTS public.inmuebles (
    id_inmueble int4 NOT NULL,
    precio numeric NOT NULL,
    antiguedad int4 NOT NULL,  -- Corregido: eliminando el espacio extra
    area numeric NOT NULL,
    construccion numeric NOT NULL,
    cuartos int4 NOT NULL,
    banos int4 NOT NULL,
    mediobanos int4 NOT NULL,
    estacionamientos int4 NOT NULL,
    descripcion text NOT NULL,
    id_tipodeinmueble int4 NOT NULL,
    id_servicio int4 NOT NULL,
    id_ciudad int4 NOT NULL,
    id_estado int4 NOT NULL,
    id_colonia int4 NOT NULL,
    CONSTRAINT inmuebles_pkey PRIMARY KEY (id_inmueble),
    CONSTRAINT inmuebles_id_ciudad_fkey FOREIGN KEY (id_ciudad) REFERENCES public.ciudades(id_ciudad),
    CONSTRAINT inmuebles_id_colonia_fkey FOREIGN KEY (id_colonia) REFERENCES public.colonias(id_colonia),
    CONSTRAINT inmuebles_id_estado_fkey FOREIGN KEY (id_estado) REFERENCES public.estados(id_estado),
    CONSTRAINT inmuebles_id_tipodeinmueble_fkey FOREIGN KEY (id_tipodeinmueble) REFERENCES public.tipos_de_inmuebles(id_tipos_de_inmueble)
);

-- public.inmuebles_servicios definition
-- Drop table
-- DROP TABLE IF EXISTS public.inmuebles_servicios;

CREATE TABLE IF NOT EXISTS public.inmuebles_servicios (
    id_inmuebles_servicios int4 NOT NULL,
    id_inmueble int4 NOT NULL,
    id_servicio int4 NOT NULL,
    CONSTRAINT inmuebles_servicios_pkey PRIMARY KEY (id_inmuebles_servicios),
    CONSTRAINT inmuebles_servicios_id_inmueble_fkey FOREIGN KEY (id_inmueble) REFERENCES public.inmuebles(id_inmueble),
    CONSTRAINT inmuebles_servicios_id_servicio_fkey FOREIGN KEY (id_servicio) REFERENCES public.servicios(id_servicio)
);
