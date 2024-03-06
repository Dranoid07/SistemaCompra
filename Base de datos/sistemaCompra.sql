PGDMP  9    +                |            sistemaCompra    16.2    16.2 K    >           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            @           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            A           1262    16827    sistemaCompra    DATABASE     �   CREATE DATABASE "sistemaCompra" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Dominican Republic.1252';
    DROP DATABASE "sistemaCompra";
                postgres    false            �            1259    16864 	   articulos    TABLE     �   CREATE TABLE public.articulos (
    id integer NOT NULL,
    descripcion character varying(100),
    marca_id integer,
    unidad_medida_id integer,
    existencia boolean,
    estado character varying(20)
);
    DROP TABLE public.articulos;
       public         heap    postgres    false            �            1259    16863    articulos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.articulos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.articulos_id_seq;
       public          postgres    false    226            B           0    0    articulos_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.articulos_id_seq OWNED BY public.articulos.id;
          public          postgres    false    225            �            1259    16836    departamentos    TABLE     �   CREATE TABLE public.departamentos (
    id integer NOT NULL,
    nombre character varying(100),
    estado character varying(20)
);
 !   DROP TABLE public.departamentos;
       public         heap    postgres    false            �            1259    16835    departamentos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.departamentos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.departamentos_id_seq;
       public          postgres    false    218            C           0    0    departamentos_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.departamentos_id_seq OWNED BY public.departamentos.id;
          public          postgres    false    217            �            1259    16829 	   empleados    TABLE     �   CREATE TABLE public.empleados (
    id integer NOT NULL,
    cedula character varying(20),
    nombre character varying(100),
    departamento character varying(100),
    estado character varying(20)
);
    DROP TABLE public.empleados;
       public         heap    postgres    false            �            1259    16828    empleados_id_seq    SEQUENCE     �   CREATE SEQUENCE public.empleados_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.empleados_id_seq;
       public          postgres    false    216            D           0    0    empleados_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.empleados_id_seq OWNED BY public.empleados.id;
          public          postgres    false    215            �            1259    16927    login    TABLE     �   CREATE TABLE public.login (
    id integer NOT NULL,
    username character varying(255) NOT NULL,
    password character varying(255) NOT NULL
);
    DROP TABLE public.login;
       public         heap    postgres    false            �            1259    16926    login_id_seq    SEQUENCE     �   CREATE SEQUENCE public.login_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.login_id_seq;
       public          postgres    false    232            E           0    0    login_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.login_id_seq OWNED BY public.login.id;
          public          postgres    false    231            �            1259    16843    marcas    TABLE     �   CREATE TABLE public.marcas (
    id integer NOT NULL,
    descripcion character varying(100),
    estado character varying(20)
);
    DROP TABLE public.marcas;
       public         heap    postgres    false            �            1259    16842    marcas_id_seq    SEQUENCE     �   CREATE SEQUENCE public.marcas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.marcas_id_seq;
       public          postgres    false    220            F           0    0    marcas_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.marcas_id_seq OWNED BY public.marcas.id;
          public          postgres    false    219            �            1259    16898    orden_compra    TABLE       CREATE TABLE public.orden_compra (
    numero_orden integer NOT NULL,
    solicitud_id integer,
    fecha_orden date,
    estado character varying(20),
    articulo_id integer,
    cantidad integer,
    unidad_medida_id integer,
    marca_id integer,
    costo_unitario numeric
);
     DROP TABLE public.orden_compra;
       public         heap    postgres    false            �            1259    16897    orden_compra_numero_orden_seq    SEQUENCE     �   CREATE SEQUENCE public.orden_compra_numero_orden_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.orden_compra_numero_orden_seq;
       public          postgres    false    230            G           0    0    orden_compra_numero_orden_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.orden_compra_numero_orden_seq OWNED BY public.orden_compra.numero_orden;
          public          postgres    false    229            �            1259    16857    proveedores    TABLE     �   CREATE TABLE public.proveedores (
    id integer NOT NULL,
    rnc character varying(20),
    nombre_comercial character varying(100),
    estado character varying(20)
);
    DROP TABLE public.proveedores;
       public         heap    postgres    false            �            1259    16856    proveedores_id_seq    SEQUENCE     �   CREATE SEQUENCE public.proveedores_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.proveedores_id_seq;
       public          postgres    false    224            H           0    0    proveedores_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.proveedores_id_seq OWNED BY public.proveedores.id;
          public          postgres    false    223            �            1259    16881    solicitud_articulos    TABLE     �   CREATE TABLE public.solicitud_articulos (
    id integer NOT NULL,
    empleado_solicitante character varying(100),
    fecha_solicitud date,
    articulo_id integer,
    cantidad integer,
    unidad_medida_id integer,
    estado character varying(20)
);
 '   DROP TABLE public.solicitud_articulos;
       public         heap    postgres    false            �            1259    16880    solicitud_articulos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.solicitud_articulos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.solicitud_articulos_id_seq;
       public          postgres    false    228            I           0    0    solicitud_articulos_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.solicitud_articulos_id_seq OWNED BY public.solicitud_articulos.id;
          public          postgres    false    227            �            1259    16850    unidades_medida    TABLE     �   CREATE TABLE public.unidades_medida (
    id integer NOT NULL,
    descripcion character varying(100),
    estado character varying(20)
);
 #   DROP TABLE public.unidades_medida;
       public         heap    postgres    false            �            1259    16849    unidades_medida_id_seq    SEQUENCE     �   CREATE SEQUENCE public.unidades_medida_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.unidades_medida_id_seq;
       public          postgres    false    222            J           0    0    unidades_medida_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.unidades_medida_id_seq OWNED BY public.unidades_medida.id;
          public          postgres    false    221            }           2604    16867    articulos id    DEFAULT     l   ALTER TABLE ONLY public.articulos ALTER COLUMN id SET DEFAULT nextval('public.articulos_id_seq'::regclass);
 ;   ALTER TABLE public.articulos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    226    225    226            y           2604    16839    departamentos id    DEFAULT     t   ALTER TABLE ONLY public.departamentos ALTER COLUMN id SET DEFAULT nextval('public.departamentos_id_seq'::regclass);
 ?   ALTER TABLE public.departamentos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    217    218            x           2604    16832    empleados id    DEFAULT     l   ALTER TABLE ONLY public.empleados ALTER COLUMN id SET DEFAULT nextval('public.empleados_id_seq'::regclass);
 ;   ALTER TABLE public.empleados ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    216    216            �           2604    16930    login id    DEFAULT     d   ALTER TABLE ONLY public.login ALTER COLUMN id SET DEFAULT nextval('public.login_id_seq'::regclass);
 7   ALTER TABLE public.login ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    232    231    232            z           2604    16846 	   marcas id    DEFAULT     f   ALTER TABLE ONLY public.marcas ALTER COLUMN id SET DEFAULT nextval('public.marcas_id_seq'::regclass);
 8   ALTER TABLE public.marcas ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    220    219    220                       2604    16901    orden_compra numero_orden    DEFAULT     �   ALTER TABLE ONLY public.orden_compra ALTER COLUMN numero_orden SET DEFAULT nextval('public.orden_compra_numero_orden_seq'::regclass);
 H   ALTER TABLE public.orden_compra ALTER COLUMN numero_orden DROP DEFAULT;
       public          postgres    false    230    229    230            |           2604    16860    proveedores id    DEFAULT     p   ALTER TABLE ONLY public.proveedores ALTER COLUMN id SET DEFAULT nextval('public.proveedores_id_seq'::regclass);
 =   ALTER TABLE public.proveedores ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    224    223    224            ~           2604    16884    solicitud_articulos id    DEFAULT     �   ALTER TABLE ONLY public.solicitud_articulos ALTER COLUMN id SET DEFAULT nextval('public.solicitud_articulos_id_seq'::regclass);
 E   ALTER TABLE public.solicitud_articulos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    228    227    228            {           2604    16853    unidades_medida id    DEFAULT     x   ALTER TABLE ONLY public.unidades_medida ALTER COLUMN id SET DEFAULT nextval('public.unidades_medida_id_seq'::regclass);
 A   ALTER TABLE public.unidades_medida ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    222    221    222            5          0    16864 	   articulos 
   TABLE DATA           d   COPY public.articulos (id, descripcion, marca_id, unidad_medida_id, existencia, estado) FROM stdin;
    public          postgres    false    226   =X       -          0    16836    departamentos 
   TABLE DATA           ;   COPY public.departamentos (id, nombre, estado) FROM stdin;
    public          postgres    false    218   �X       +          0    16829 	   empleados 
   TABLE DATA           M   COPY public.empleados (id, cedula, nombre, departamento, estado) FROM stdin;
    public          postgres    false    216   Y       ;          0    16927    login 
   TABLE DATA           7   COPY public.login (id, username, password) FROM stdin;
    public          postgres    false    232   �Y       /          0    16843    marcas 
   TABLE DATA           9   COPY public.marcas (id, descripcion, estado) FROM stdin;
    public          postgres    false    220   *Z       9          0    16898    orden_compra 
   TABLE DATA           �   COPY public.orden_compra (numero_orden, solicitud_id, fecha_orden, estado, articulo_id, cantidad, unidad_medida_id, marca_id, costo_unitario) FROM stdin;
    public          postgres    false    230   zZ       3          0    16857    proveedores 
   TABLE DATA           H   COPY public.proveedores (id, rnc, nombre_comercial, estado) FROM stdin;
    public          postgres    false    224   �Z       7          0    16881    solicitud_articulos 
   TABLE DATA           �   COPY public.solicitud_articulos (id, empleado_solicitante, fecha_solicitud, articulo_id, cantidad, unidad_medida_id, estado) FROM stdin;
    public          postgres    false    228   �[       1          0    16850    unidades_medida 
   TABLE DATA           B   COPY public.unidades_medida (id, descripcion, estado) FROM stdin;
    public          postgres    false    222   \       K           0    0    articulos_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.articulos_id_seq', 7, true);
          public          postgres    false    225            L           0    0    departamentos_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.departamentos_id_seq', 6, true);
          public          postgres    false    217            M           0    0    empleados_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.empleados_id_seq', 5, true);
          public          postgres    false    215            N           0    0    login_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.login_id_seq', 3, true);
          public          postgres    false    231            O           0    0    marcas_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.marcas_id_seq', 5, true);
          public          postgres    false    219            P           0    0    orden_compra_numero_orden_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.orden_compra_numero_orden_seq', 5, true);
          public          postgres    false    229            Q           0    0    proveedores_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.proveedores_id_seq', 5, true);
          public          postgres    false    223            R           0    0    solicitud_articulos_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.solicitud_articulos_id_seq', 5, true);
          public          postgres    false    227            S           0    0    unidades_medida_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.unidades_medida_id_seq', 6, true);
          public          postgres    false    221            �           2606    16869    articulos articulos_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.articulos
    ADD CONSTRAINT articulos_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.articulos DROP CONSTRAINT articulos_pkey;
       public            postgres    false    226            �           2606    16841     departamentos departamentos_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.departamentos
    ADD CONSTRAINT departamentos_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.departamentos DROP CONSTRAINT departamentos_pkey;
       public            postgres    false    218            �           2606    16834    empleados empleados_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.empleados
    ADD CONSTRAINT empleados_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.empleados DROP CONSTRAINT empleados_pkey;
       public            postgres    false    216            �           2606    16934    login login_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.login
    ADD CONSTRAINT login_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.login DROP CONSTRAINT login_pkey;
       public            postgres    false    232            �           2606    16848    marcas marcas_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.marcas
    ADD CONSTRAINT marcas_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.marcas DROP CONSTRAINT marcas_pkey;
       public            postgres    false    220            �           2606    16905    orden_compra orden_compra_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.orden_compra
    ADD CONSTRAINT orden_compra_pkey PRIMARY KEY (numero_orden);
 H   ALTER TABLE ONLY public.orden_compra DROP CONSTRAINT orden_compra_pkey;
       public            postgres    false    230            �           2606    16862    proveedores proveedores_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.proveedores
    ADD CONSTRAINT proveedores_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.proveedores DROP CONSTRAINT proveedores_pkey;
       public            postgres    false    224            �           2606    16886 ,   solicitud_articulos solicitud_articulos_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.solicitud_articulos
    ADD CONSTRAINT solicitud_articulos_pkey PRIMARY KEY (id);
 V   ALTER TABLE ONLY public.solicitud_articulos DROP CONSTRAINT solicitud_articulos_pkey;
       public            postgres    false    228            �           2606    16855 $   unidades_medida unidades_medida_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.unidades_medida
    ADD CONSTRAINT unidades_medida_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.unidades_medida DROP CONSTRAINT unidades_medida_pkey;
       public            postgres    false    222            �           2606    16870 !   articulos articulos_marca_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.articulos
    ADD CONSTRAINT articulos_marca_id_fkey FOREIGN KEY (marca_id) REFERENCES public.marcas(id);
 K   ALTER TABLE ONLY public.articulos DROP CONSTRAINT articulos_marca_id_fkey;
       public          postgres    false    4742    226    220            �           2606    16875 )   articulos articulos_unidad_medida_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.articulos
    ADD CONSTRAINT articulos_unidad_medida_id_fkey FOREIGN KEY (unidad_medida_id) REFERENCES public.unidades_medida(id);
 S   ALTER TABLE ONLY public.articulos DROP CONSTRAINT articulos_unidad_medida_id_fkey;
       public          postgres    false    222    4744    226            �           2606    16911 *   orden_compra orden_compra_articulo_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.orden_compra
    ADD CONSTRAINT orden_compra_articulo_id_fkey FOREIGN KEY (articulo_id) REFERENCES public.articulos(id);
 T   ALTER TABLE ONLY public.orden_compra DROP CONSTRAINT orden_compra_articulo_id_fkey;
       public          postgres    false    230    226    4748            �           2606    16921 '   orden_compra orden_compra_marca_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.orden_compra
    ADD CONSTRAINT orden_compra_marca_id_fkey FOREIGN KEY (marca_id) REFERENCES public.marcas(id);
 Q   ALTER TABLE ONLY public.orden_compra DROP CONSTRAINT orden_compra_marca_id_fkey;
       public          postgres    false    220    4742    230            �           2606    16906 +   orden_compra orden_compra_solicitud_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.orden_compra
    ADD CONSTRAINT orden_compra_solicitud_id_fkey FOREIGN KEY (solicitud_id) REFERENCES public.solicitud_articulos(id);
 U   ALTER TABLE ONLY public.orden_compra DROP CONSTRAINT orden_compra_solicitud_id_fkey;
       public          postgres    false    230    4750    228            �           2606    16916 /   orden_compra orden_compra_unidad_medida_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.orden_compra
    ADD CONSTRAINT orden_compra_unidad_medida_id_fkey FOREIGN KEY (unidad_medida_id) REFERENCES public.unidades_medida(id);
 Y   ALTER TABLE ONLY public.orden_compra DROP CONSTRAINT orden_compra_unidad_medida_id_fkey;
       public          postgres    false    4744    230    222            �           2606    16887 8   solicitud_articulos solicitud_articulos_articulo_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.solicitud_articulos
    ADD CONSTRAINT solicitud_articulos_articulo_id_fkey FOREIGN KEY (articulo_id) REFERENCES public.articulos(id);
 b   ALTER TABLE ONLY public.solicitud_articulos DROP CONSTRAINT solicitud_articulos_articulo_id_fkey;
       public          postgres    false    4748    226    228            �           2606    16892 =   solicitud_articulos solicitud_articulos_unidad_medida_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.solicitud_articulos
    ADD CONSTRAINT solicitud_articulos_unidad_medida_id_fkey FOREIGN KEY (unidad_medida_id) REFERENCES public.unidades_medida(id);
 g   ALTER TABLE ONLY public.solicitud_articulos DROP CONSTRAINT solicitud_articulos_unidad_medida_id_fkey;
       public          postgres    false    228    222    4744            5   g   x�3��I,(�/�4�4�,�tL.�,��2�I�9�2-?/_!�����,��1�gnAQjq~Q"�	P"&a�����Z�iV7�����,�/B�'F��� _�&�      -   Z   x�3�IM����O?�6��1�$�,�ˈ�9?��(�&`���W�{�%BDL8�R�K���<Js���jM���j�2s2SS`�1z\\\ 0$j      +   �   x�m�M
�0��u<E.0%���R\�DJW�"hF�v�mz��z/ցЮ����c$B�Taow��Ӭ-/�3���b����,�����"���Rvю�|�vY�59����ׇ�C�<�
S;�TM�%}3v"|���x^�,�����@�4��F�a���BLI���X�]G��ڵ�����&���L�      ;   4   x�3��M�+M��442�2��H,ʩ,�415�2�tJ-��L�4�������  P
�      /   @   x�3�N�-.�K�tL.�,��2�t,(�I�q�9���*a<N� ۔�%5'��3/���� �*�      9   d   x�M�A
�0���/J�������KO��l ����2gm�S�[Q(wII6��ȝ�Qe�*A�08�>��(rd"~�h�{�a'�V� �y&�      3   �   x�Eͽ
�0F��ͽ|��ϟ�ADЩ��KH�Ҥ���K#��<p$$K�J�&�k�)w�i�C(��:|�PP���)b��[.�_��fMMlI���G�g�z���Æ�ؑ�Oϋ{���²�֙,�ѕ:���WB�/�0�      7   �   x�3��*M�SH-J��4202�50�50�4�4�Լ��Լ�T.#N�Ģ�k���/�AVmTkT�XP������e��X��_���R��^��ؘӔ��hNǼD�Û�ՙ��D2��KM9M�\���� �9�      1   N   x�3���LIL�tL.�,��2�t�ON�K��9�3s�Ӌs�aB&�>�%E���y�SN�T� Tތ3'	!���� ���     