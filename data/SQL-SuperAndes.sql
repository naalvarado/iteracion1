-- 1 Consumidor
CREATE TABLE Consumidores(
  ID NUMBER NOT NULL PRIMARY KEY,
  DOCUMENTOIDE NUMBER,
  NIT NUMBER,
  NOMBRE VARCHAR(255 BYTE) NOT NULL UNIQUE,
  EMAIL VARCHAR(255 BYTE) UNIQUE,
  DIRECCION VARCHAR(255 BYTE)
);
-- 2 SuperMercado
CREATE TABLE SuperMercados(
  ID NUMBER NOT NULL PRIMARY KEY,
  NOMBRE VARCHAR(255 BYTE) NOT NULL UNIQUE
);
-- 3 Proveedor
CREATE TABLE Proveedores(
  ID NUMBER NOT NULL PRIMARY KEY,
  NOMBRE VARCHAR(255 BYTE) NOT NULL UNIQUE
);
-- 4 ProveedorSupermercado
CREATE TABLE ProveedoresSuperMercados(
  ID_PROVEEDOR NUMBER,
  ID_SUPERMERCADO NUMBER,
  CONSTRAINT FK_ProveedorPSM FOREIGN KEY (ID_PROVEEDOR) REFERENCES Proveedores(ID),
  CONSTRAINT FK_SuperMercadoPSM FOREIGN KEY (ID_SUPERMERCADO) REFERENCES SuperMercados(ID)
);
-- 5 Sucursal
CREATE TABLE Sucursales(
	ID NUMBER NOT NULL PRIMARY KEY,
	SUPERMERCADO NUMBER,
	NOMBRE VARCHAR(255 BYTE) NOT NULL UNIQUE,
	CIUDAD VARCHAR(255 BYTE) NOT NULL,
	DIRECCION VARCHAR(255 BYTE) NOT NULL UNIQUE,
  CONSTRAINT FK_SuperMercadoS FOREIGN KEY (SUPERMERCADO) REFERENCES SuperMercados(ID)
 );
-- 6 Bodega
CREATE TABLE Bodegas(
  ID NUMBER NOT NULL PRIMARY KEY,
  ID_SUCURSAL NUMBER,
  TIPO VARCHAR(255 BYTE) NOT NULL,
  VOLUMEN NUMBER NOT NULL,
  MAX_PESO NUMBER NOT NULL,
  CONSTRAINT FK_SucursalB FOREIGN KEY (ID_SUCURSAL) REFERENCES Sucursales(ID)
);
-- 7 Local
CREATE TABLE Locales(
 ID NUMBER NOT NULL PRIMARY KEY,
 SUCURSAL NUMBER,
 DIRECCION VARCHAR(255 BYTE) NOT NULL UNIQUE,
 CONSTRAINT FK_SucursalL FOREIGN KEY (SUCURSAL) REFERENCES Sucursales(ID)
);
-- 8 Estante
CREATE TABLE Estantes(
 ID NUMBER NOT NULL PRIMARY KEY,
 LOCAL NUMBER,
 VOLUMEN NUMBER NOT NULL,
 MAX_PESO NUMBER NOT NULL,
 CONSTRAINT FK_LocalE FOREIGN KEY (LOCAL) REFERENCES Locales(ID)
);
-- 9 Producto
CREATE TABLE Productos(
	ID NUMBER NOT NULL PRIMARY KEY,
	SUCURSAL NUMBER,
	BODEGA NUMBER,
	ESTANTE NUMBER,
	NOMBRE VARCHAR2(255 BYTE) NOT NULL,
	CODIGO VARCHAR2(255 BYTE) NOT NULL,
	MARCA VARCHAR2(255 BYTE) NOT NULL,
	PRESENTACION VARCHAR2(255 BYTE),
	CANTIDAD_PRESENTACION NUMBER,
	VOLUMEN_PAQUETE NUMBER,
	CALIFICACION_CALIDAD NUMBER,
  FECHA_VENCIMIENTO DATE,
  PRECIO_UNIDAD NUMBER NOT NULL,
  TIPO VARCHAR(255 BYTE) NOT NULL,
  SUB_TIPO VARCHAR(255 BYTE) NOT NULL,
  CONSTRAINT FK_SucursalP FOREIGN KEY (SUCURSAL) REFERENCES Sucursales(ID),
  CONSTRAINT FK_BodegaP FOREIGN KEY (BODEGA) REFERENCES Bodegas(ID),
  CONSTRAINT FK_EstanteP FOREIGN KEY (ESTANTE) REFERENCES Estantes(ID)
 );
 -- 10 Venta
 CREATE TABLE Ventas(
   ID NUMBER NOT NULL PRIMARY KEY,
   FECHA DATE NOT NULL,
   ID_PRODUCTO NUMBER,
   LOCAL NUMBER,
   CONSTRAINT FK_ProductoV FOREIGN KEY (ID_PRODUCTO) REFERENCES Productos(ID),
   CONSTRAINT FK_LocalV FOREIGN KEY (LOCAL) REFERENCES Locales(ID)
 );
-- 11 ReordenBodega
CREATE TABLE NivelesReordenBodegas(
  ID_BODEGA NUMBER,
  ID_PRODUCTO NUMBER,
  CANTIDAD_MINIMA NUMBER NOT NULL,
  CONSTRAINT FK_BodegaNRB FOREIGN KEY (ID_BODEGA) REFERENCES Bodegas(ID),
  CONSTRAINT FK_ProductoNRB FOREIGN KEY (ID_PRODUCTO) REFERENCES Productos(ID)
);
-- 12 ReordenEstante
CREATE TABLE NivelesReordenEstantes(
  ID_ESTANTE NUMBER,
  ID_PRODUCTO NUMBER,
  CANTIDAD_MINIMA NUMBER NOT NULL,
  CONSTRAINT FK_EstanteNRE FOREIGN KEY (ID_ESTANTE) REFERENCES Estantes(ID),
  CONSTRAINT FK_ProductoNRE FOREIGN KEY (ID_PRODUCTO) REFERENCES Productos(ID)
);
-- 13 Pedido
CREATE TABLE Pedidos(
  ID NUMBER NOT NULL PRIMARY KEY,
  ID_PRODUCTO NUMBER,
  CANTIDAD NUMBER NOT NULL,
  PRECIOACORDADO NUMBER NOT NULL,
  FECHA_ENTREGA DATE NOT NULL,
  ENTREGADO VARCHAR(1 BYTE) NOT NULL,
  SUCURSAL NUMBER,
  PROVEEDOR NUMBER,
  CONSTRAINT FK_ProductoPe FOREIGN KEY (ID_PRODUCTO) REFERENCES Productos(ID),
  CONSTRAINT FK_SucursalPe FOREIGN KEY (SUCURSAL) REFERENCES Sucursales(ID),
  CONSTRAINT FK_ProveedorPe FOREIGN KEY (PROVEEDOR) REFERENCES Proveedores(ID)
);
-- 14 ProveedorProducto
CREATE TABLE ProveedoresProductos(
  ID_PROVEEDOR NUMBER,
  ID_PRODUCTO NUMBER,
  CONSTRAINT FK_ProveedorPP FOREIGN KEY (ID_PROVEEDOR) REFERENCES Proveedores(ID),
  CONSTRAINT FK_ProductoPP FOREIGN KEY (ID_PRODUCTO) REFERENCES Productos(ID)
);
-- TIPOS PRODUCTO Perecedero, NoPerecedero, Aceo, Igienen, Utiles
