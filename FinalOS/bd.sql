PGDMP     8    +    	            v            Final2    10.4    10.4     �
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �
           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �
           1262    16432    Final2    DATABASE     �   CREATE DATABASE "Final2" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE "Final2";
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �
           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            �
           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    16433    participante    TABLE     �   CREATE TABLE public.participante (
    id integer NOT NULL,
    tiu character varying(50) NOT NULL,
    nombre character varying(50) NOT NULL,
    sede character varying(50) NOT NULL,
    puntaje integer
);
     DROP TABLE public.participante;
       public         postgres    false    3            �            1259    16438 	   resultado    TABLE     �   CREATE TABLE public.resultado (
    id integer NOT NULL,
    fecha character varying(50) NOT NULL,
    participante_id integer,
    puesto character varying(50) NOT NULL
);
    DROP TABLE public.resultado;
       public         postgres    false    3            �
          0    16433    participante 
   TABLE DATA                     public       postgres    false    196   �       �
          0    16438 	   resultado 
   TABLE DATA                     public       postgres    false    197   �       q
           2606    16437    participante participante_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.participante
    ADD CONSTRAINT participante_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.participante DROP CONSTRAINT participante_pkey;
       public         postgres    false    196            s
           2606    16442    resultado resultado_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.resultado
    ADD CONSTRAINT resultado_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.resultado DROP CONSTRAINT resultado_pkey;
       public         postgres    false    197            t
           2606    16443    resultado fk_participante    FK CONSTRAINT     �   ALTER TABLE ONLY public.resultado
    ADD CONSTRAINT fk_participante FOREIGN KEY (participante_id) REFERENCES public.participante(id);
 C   ALTER TABLE ONLY public.resultado DROP CONSTRAINT fk_participante;
       public       postgres    false    196    2673    197            �
   
   x���          �
   
   x���         