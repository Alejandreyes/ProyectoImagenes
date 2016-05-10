CREATE TABLE public.usuario
(
  nombreUsuario character varying(15) NOT NULL,
  contrasenia character varying(15),
  nombre character varying(25),
  apellidos character varying(25),
  correo character varying(25),
  CONSTRAINT "pk_Usuario" PRIMARY KEY (nombreUsuario)
);
CREATE TABLE public.objeto
(
  nombreLibro character varying(20) NOT NULL,
  autor character varying(30),
  edicion integer,
  anio integer,
  genero character varying(15),
  sinopsis character varying(500),  
  numPaginas integer,
  nombreUsuario character varying(15) NOT NULL,
  CONSTRAINT "pk_Objeto" PRIMARY KEY (nombreLibro),
  CONSTRAINT "fk_Usuario" FOREIGN KEY (nombreUsuario)
      REFERENCES public.usuario (nombreUsuario)
);
create table prestar(
 nombrePrestador character varying(15) NOT NULL,
 nombreConsumidor character varying(15) NOT NULL,
 nombreLibro character varying(20) NOT NULL,
 fechaPrestamo date,
 calificacionPrestador integer,
 calificaConsumidor integer,
	CONSTRAINT "pk_Prestamo" PRIMARY KEY (nombrePrestador,nombreConsumidor, nombreLibro),
 CONSTRAINT "fk_Prestador" FOREIGN KEY (nombrePrestador)
      REFERENCES public.usuario (nombreUsuario),
 CONSTRAINT "fk_Consumidor" FOREIGN KEY (nombreConsumidor)
      REFERENCES public.usuario (nombreUsuario),
 CONSTRAINT "fk_Libro" FOREIGN KEY (nombreLibro)
      REFERENCES public.objeto (nombreLibro) 
);