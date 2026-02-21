--
-- PostgreSQL database dump
--


-- Dumped from database version 17.8
-- Dumped by pg_dump version 17.8

-- Started on 2026-02-17 19:49:10

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: -
--

-- CREATE SCHEMA public;

--
-- TOC entry 217 (class 1259 OID 16587)
-- Name: seq_categorias; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.seq_categorias
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 218 (class 1259 OID 16588)
-- Name: seq_livros; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.seq_livros
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 219 (class 1259 OID 16589)
-- Name: seq_pessoas; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.seq_pessoas
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 220 (class 1259 OID 16590)
-- Name: seq_roles; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.seq_roles
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 221 (class 1259 OID 16591)
-- Name: seq_usuarios; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.seq_usuarios
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 228 (class 1259 OID 16850)
-- Name: tb_categorias; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_categorias (
                                      id bigint NOT NULL,
                                      nome character varying(50) NOT NULL
);


--
-- TOC entry 227 (class 1259 OID 16829)
-- Name: tb_livros; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_livros (
                                  id bigint NOT NULL,
                                  autor character varying(255) NOT NULL,
                                  data_atualizacao timestamp(6) with time zone,
                                  data_criacao timestamp(6) with time zone,
                                  descricao text NOT NULL,
                                  image_url character varying(255),
                                  isbn character varying(255) NOT NULL,
                                  paginas integer NOT NULL,
                                  status_livro character varying(255) NOT NULL,
                                  titulo character varying(255) NOT NULL,
                                  pessoa_id bigint NOT NULL,
                                  CONSTRAINT tb_livros_status_livro_check CHECK (((status_livro)::text = ANY ((ARRAY['LIDO'::character varying, 'LENDO'::character varying, 'QUERO_LER'::character varying])::text[])))
);


--
-- TOC entry 222 (class 1259 OID 16744)
-- Name: tb_livros_categorias; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_livros_categorias (
                                             livro_id bigint NOT NULL,
                                             categoria_id bigint NOT NULL
);


--
-- TOC entry 223 (class 1259 OID 16747)
-- Name: tb_pessoas; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_pessoas (
                                   id bigint NOT NULL,
                                   cpf character varying(255) NOT NULL,
                                   data_criacao timestamp(6) with time zone,
                                   data_nasc date NOT NULL,
                                   nome character varying(255) NOT NULL,
                                   usuario_id bigint,
                                   email character varying(255) NOT NULL
);


--
-- TOC entry 224 (class 1259 OID 16754)
-- Name: tb_roles; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_roles (
                                 id bigint NOT NULL,
                                 nome character varying(50) NOT NULL
);


--
-- TOC entry 225 (class 1259 OID 16759)
-- Name: tb_usuarios; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_usuarios (
                                    id bigint NOT NULL,
                                    login character varying(255) NOT NULL,
                                    senha character varying(255) NOT NULL,
                                    ultimo_login timestamp(6) with time zone
);


--
-- TOC entry 226 (class 1259 OID 16766)
-- Name: tb_usuarios_roles; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_usuarios_roles (
                                          usuario_id bigint NOT NULL,
                                          role_id bigint NOT NULL
);


--
-- TOC entry 4957 (class 0 OID 16850)
-- Dependencies: 228
-- Data for Name: tb_categorias; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 4956 (class 0 OID 16829)
-- Dependencies: 227
-- Data for Name: tb_livros; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 4951 (class 0 OID 16744)
-- Dependencies: 222
-- Data for Name: tb_livros_categorias; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 4952 (class 0 OID 16747)
-- Dependencies: 223
-- Data for Name: tb_pessoas; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 4953 (class 0 OID 16754)
-- Dependencies: 224
-- Data for Name: tb_roles; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 4954 (class 0 OID 16759)
-- Dependencies: 225
-- Data for Name: tb_usuarios; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 4955 (class 0 OID 16766)
-- Dependencies: 226
-- Data for Name: tb_usuarios_roles; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 4963 (class 0 OID 0)
-- Dependencies: 217
-- Name: seq_categorias; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.seq_categorias', 1, false);


--
-- TOC entry 4964 (class 0 OID 0)
-- Dependencies: 218
-- Name: seq_livros; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.seq_livros', 1, false);


--
-- TOC entry 4965 (class 0 OID 0)
-- Dependencies: 219
-- Name: seq_pessoas; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.seq_pessoas', 1, false);


--
-- TOC entry 4966 (class 0 OID 0)
-- Dependencies: 220
-- Name: seq_roles; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.seq_roles', 1, false);


--
-- TOC entry 4967 (class 0 OID 0)
-- Dependencies: 221
-- Name: seq_usuarios; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.seq_usuarios', 1, false);


--
-- TOC entry 4792 (class 2606 OID 16854)
-- Name: tb_categorias tb_categorias_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_categorias
    ADD CONSTRAINT tb_categorias_pkey PRIMARY KEY (id);


--
-- TOC entry 4790 (class 2606 OID 16836)
-- Name: tb_livros tb_livros_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_livros
    ADD CONSTRAINT tb_livros_pkey PRIMARY KEY (id);


--
-- TOC entry 4772 (class 2606 OID 16753)
-- Name: tb_pessoas tb_pessoas_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_pessoas
    ADD CONSTRAINT tb_pessoas_pkey PRIMARY KEY (id);


--
-- TOC entry 4780 (class 2606 OID 16758)
-- Name: tb_roles tb_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_roles
    ADD CONSTRAINT tb_roles_pkey PRIMARY KEY (id);


--
-- TOC entry 4784 (class 2606 OID 16765)
-- Name: tb_usuarios tb_usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_usuarios
    ADD CONSTRAINT tb_usuarios_pkey PRIMARY KEY (id);


--
-- TOC entry 4774 (class 2606 OID 16849)
-- Name: tb_pessoas uk4chd3jr876nq7l2sxg17epw28; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_pessoas
    ADD CONSTRAINT uk4chd3jr876nq7l2sxg17epw28 UNIQUE (email);


--
-- TOC entry 4782 (class 2606 OID 16776)
-- Name: tb_roles uk4cofgwbwa5cihyfoclqi1b0ry; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_roles
    ADD CONSTRAINT uk4cofgwbwa5cihyfoclqi1b0ry UNIQUE (nome_desc);


--
-- TOC entry 4776 (class 2606 OID 16774)
-- Name: tb_pessoas uk7qwebvnpfi36mqtcl9qr6ka08; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_pessoas
    ADD CONSTRAINT uk7qwebvnpfi36mqtcl9qr6ka08 UNIQUE (usuario_id);


--
-- TOC entry 4786 (class 2606 OID 16778)
-- Name: tb_usuarios uk9v12hr9s4xeuggcy1ss95jmwy; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_usuarios
    ADD CONSTRAINT uk9v12hr9s4xeuggcy1ss95jmwy UNIQUE (login);


--
-- TOC entry 4794 (class 2606 OID 16856)
-- Name: tb_categorias ukkek0ib8u8j19qpwwi6n8fqupd; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_categorias
    ADD CONSTRAINT ukkek0ib8u8j19qpwwi6n8fqupd UNIQUE (nome_desc);


--
-- TOC entry 4778 (class 2606 OID 16772)
-- Name: tb_pessoas uknn3m4y572iqookhf99e0hu5qk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_pessoas
    ADD CONSTRAINT uknn3m4y572iqookhf99e0hu5qk UNIQUE (cpf);


--
-- TOC entry 4788 (class 2606 OID 16780)
-- Name: tb_usuarios_roles unique_role_user; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_usuarios_roles
    ADD CONSTRAINT unique_role_user UNIQUE (usuario_id, role_id);


--
-- TOC entry 4795 (class 2606 OID 16857)
-- Name: tb_livros_categorias categoria_livro_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_livros_categorias
    ADD CONSTRAINT categoria_livro_fk FOREIGN KEY (categoria_id) REFERENCES public.tb_categorias(id);


--
-- TOC entry 4796 (class 2606 OID 16842)
-- Name: tb_livros_categorias livro_categoria_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_livros_categorias
    ADD CONSTRAINT livro_categoria_fk FOREIGN KEY (livro_id) REFERENCES public.tb_livros(id);


--
-- TOC entry 4800 (class 2606 OID 16837)
-- Name: tb_livros pessoa_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_livros
    ADD CONSTRAINT pessoa_fk FOREIGN KEY (pessoa_id) REFERENCES public.tb_pessoas(id);


--
-- TOC entry 4798 (class 2606 OID 16801)
-- Name: tb_usuarios_roles role_usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_usuarios_roles
    ADD CONSTRAINT role_usuario_fk FOREIGN KEY (role_id) REFERENCES public.tb_roles(id);


--
-- TOC entry 4797 (class 2606 OID 16796)
-- Name: tb_pessoas usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_pessoas
    ADD CONSTRAINT usuario_fk FOREIGN KEY (usuario_id) REFERENCES public.tb_usuarios(id);


--
-- TOC entry 4799 (class 2606 OID 16806)
-- Name: tb_usuarios_roles usuario_role_fk; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_usuarios_roles
    ADD CONSTRAINT usuario_role_fk FOREIGN KEY (usuario_id) REFERENCES public.tb_usuarios(id);


-- Completed on 2026-02-17 19:49:11

--
-- PostgreSQL database dump complete
--


