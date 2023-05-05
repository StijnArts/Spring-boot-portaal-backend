/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2014                    */
/* Created on:     17/04/2023 13:54:34                          */
/*==============================================================*/
USE master
GO

DROP DATABASE IF EXISTS slagerportal
GO

CREATE DATABASE slagerportal
GO

USE slagerportal
GO

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('COMPANYPRODUCTS') and o.name = 'FK_COMPANYP_COMPANYPR_COMPANY')
alter table COMPANYPRODUCTS
   drop constraint FK_COMPANYP_COMPANYPR_COMPANY
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('COMPANYPRODUCTS') and o.name = 'FK_COMPANYP_COMPANYPR_PRODUCT')
alter table COMPANYPRODUCTS
   drop constraint FK_COMPANYP_COMPANYPR_PRODUCT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CUSTOMER') and o.name = 'FK_CUSTOMER_CUSTOMER__COMPANY')
alter table CUSTOMER
   drop constraint FK_CUSTOMER_CUSTOMER__COMPANY
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('INVENTORY') and o.name = 'FK_INVENTOR_COMPANY_H_COMPANY')
alter table INVENTORY
   drop constraint FK_INVENTOR_COMPANY_H_COMPANY
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('INVENTORY') and o.name = 'FK_INVENTOR_INVENTORY_PRODUCT')
alter table INVENTORY
   drop constraint FK_INVENTOR_INVENTORY_PRODUCT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('"TRANSACTION"') and o.name = 'FK_TRANSACT_COMPANY_M_COMPANY')
alter table "TRANSACTION"
   drop constraint FK_TRANSACT_COMPANY_M_COMPANY
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('"TRANSACTION"') and o.name = 'FK_TRANSACT_TRANSACTI_PRODUCT')
alter table "TRANSACTION"
   drop constraint FK_TRANSACT_TRANSACTI_PRODUCT
go

if exists (select 1
            from  sysobjects
           where  id = object_id('COMPANY')
            and   type = 'U')
   drop table COMPANY
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('COMPANYPRODUCTS')
            and   name  = 'COMPANYPRODUCTS_FK'
            and   indid > 0
            and   indid < 255)
   drop index COMPANYPRODUCTS.COMPANYPRODUCTS_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('COMPANYPRODUCTS')
            and   type = 'U')
   drop table COMPANYPRODUCTS
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('CUSTOMER')
            and   name  = 'CUSTOMER_PURCHASES_FROM_COMPANY_FK'
            and   indid > 0
            and   indid < 255)
   drop index CUSTOMER.CUSTOMER_PURCHASES_FROM_COMPANY_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CUSTOMER')
            and   type = 'U')
   drop table CUSTOMER
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('INVENTORY')
            and   name  = 'COMPANY_HAS_INVENTORY_FK'
            and   indid > 0
            and   indid < 255)
   drop index INVENTORY.COMPANY_HAS_INVENTORY_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('INVENTORY')
            and   name  = 'INVENTORY_HAS_PRODUCT_FK'
            and   indid > 0
            and   indid < 255)
   drop index INVENTORY.INVENTORY_HAS_PRODUCT_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('INVENTORY')
            and   type = 'U')
   drop table INVENTORY
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PRODUCT')
            and   type = 'U')
   drop table PRODUCT
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('"TRANSACTION"')
            and   name  = 'TRANSACTION_CONTAINS_PRODUCT_FK'
            and   indid > 0
            and   indid < 255)
   drop index "TRANSACTION".TRANSACTION_CONTAINS_PRODUCT_FK
go

if exists (select 1
            from  sysindexes
           where  id    = object_id('"TRANSACTION"')
            and   name  = 'COMPANY_MAKES_TRANSACTION_FK'
            and   indid > 0
            and   indid < 255)
   drop index "TRANSACTION".COMPANY_MAKES_TRANSACTION_FK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('"TRANSACTION"')
            and   type = 'U')
   drop table "TRANSACTION"
go

if exists(select 1 from systypes where name='COMPANYCITY')
   drop type COMPANYCITY
go

if exists(select 1 from systypes where name='COMPANYNAME')
   drop type COMPANYNAME
go

if exists(select 1 from systypes where name='COMPANYSTREET')
   drop type COMPANYSTREET
go

if exists(select 1 from systypes where name='COMPANYZIPCODE')
   drop type COMPANYZIPCODE
go

if exists(select 1 from systypes where name='CUSTOMEREMAIL')
   drop type CUSTOMEREMAIL
go

if exists(select 1 from systypes where name='CUSTOMERFIRSTNAME')
   drop type CUSTOMERFIRSTNAME
go

if exists(select 1 from systypes where name='CUSTOMERGENDER')
   drop type CUSTOMERGENDER
go

if exists(select 1 from systypes where name='CUSTOMERLASTNAME')
   drop type CUSTOMERLASTNAME
go

if exists(select 1 from systypes where name='ID')
   drop type ID
go

if exists(select 1 from systypes where name='INVENTORYQUANTITY')
   drop type INVENTORYQUANTITY
go

if exists(select 1 from systypes where name='INVENTORYQUANTITYMAX')
   drop type INVENTORYQUANTITYMAX
go

if exists(select 1 from systypes where name='NUMBER')
   drop type NUMBER
go

if exists(select 1 from systypes where name='PRODUCTNAME')
   drop type PRODUCTNAME
go

if exists(select 1 from systypes where name='PRODUCTPRICE')
   drop type PRODUCTPRICE
go

if exists(select 1 from systypes where name='TRANSACTIONDATESOLD')
   drop type TRANSACTIONDATESOLD
go

if exists(select 1 from systypes where name='TRANSACTIONQUANTITYSOLD')
   drop type TRANSACTIONQUANTITYSOLD
go

/*==============================================================*/
/* Domain: COMPANYCITY                                          */
/*==============================================================*/
create type COMPANYCITY
   from varchar(58)
go

/*==============================================================*/
/* Domain: COMPANYNAME                                          */
/*==============================================================*/
create type COMPANYNAME
   from varchar(100)
go

/*==============================================================*/
/* Domain: COMPANYSTREET                                        */
/*==============================================================*/
create type COMPANYSTREET
   from varchar(100)
go

/*==============================================================*/
/* Domain: COMPANYZIPCODE                                       */
/*==============================================================*/
create type COMPANYZIPCODE
   from varchar(6)
go

/*==============================================================*/
/* Domain: CUSTOMEREMAIL                                        */
/*==============================================================*/
create type CUSTOMEREMAIL
   from varchar(100)
go

/*==============================================================*/
/* Domain: CUSTOMERFIRSTNAME                                    */
/*==============================================================*/
create type CUSTOMERFIRSTNAME
   from varchar(100)
go

/*==============================================================*/
/* Domain: CUSTOMERGENDER                                       */
/*==============================================================*/
create type CUSTOMERGENDER
   from varchar(30)
go

/*==============================================================*/
/* Domain: CUSTOMERLASTNAME                                     */
/*==============================================================*/
create type CUSTOMERLASTNAME
   from varchar(100)
go

/*==============================================================*/
/* Domain: ID                                                   */
/*==============================================================*/
create type ID
   from numeric
go

/*==============================================================*/
/* Domain: INVENTORYQUANTITY                                    */
/*==============================================================*/
create type INVENTORYQUANTITY
   from numeric
go

/*==============================================================*/
/* Domain: INVENTORYQUANTITYMAX                                 */
/*==============================================================*/
create type INVENTORYQUANTITYMAX
   from numeric
go

/*==============================================================*/
/* Domain: NUMBER                                               */
/*==============================================================*/
create type NUMBER
   from numeric
go

/*==============================================================*/
/* Domain: PRODUCTNAME                                          */
/*==============================================================*/
create type PRODUCTNAME
   from varchar(100)
go

/*==============================================================*/
/* Domain: PRODUCTPRICE                                         */
/*==============================================================*/
create type PRODUCTPRICE
   from decimal(8,2)
go

/*==============================================================*/
/* Domain: TRANSACTIONDATESOLD                                  */
/*==============================================================*/
create type TRANSACTIONDATESOLD
   from datetime
go

/*==============================================================*/
/* Domain: TRANSACTIONQUANTITYSOLD                              */
/*==============================================================*/
create type TRANSACTIONQUANTITYSOLD
   from numeric
go

/*==============================================================*/
/* Table: COMPANY                                               */
/*==============================================================*/
create table COMPANY (
   COMPANYID            ID                   identity,
   NAME                 COMPANYNAME          not null,
   CITY                 COMPANYCITY          not null,
   ZIPCODE              COMPANYZIPCODE       not null,
   STREET               COMPANYSTREET        not null,
   NUMBER               NUMBER               not null,
   constraint PK_COMPANY primary key (COMPANYID)
)
go

/*==============================================================*/
/* Table: COMPANYPRODUCTS                                       */
/*==============================================================*/
create table COMPANYPRODUCTS (
   COMPANYID            ID                   not null,
   PRODUCTID            ID                   not null,
   constraint PK_COMPANYPRODUCTS primary key (COMPANYID, PRODUCTID)
)
go

/*==============================================================*/
/* Index: COMPANYPRODUCTS_FK                                    */
/*==============================================================*/

create nonclustered index COMPANYPRODUCTS_FK on COMPANYPRODUCTS (COMPANYID ASC)
go

/*==============================================================*/
/* Table: CUSTOMER                                              */
/*==============================================================*/
create table CUSTOMER (
   CUSTOMERID           ID                   identity,
   COMPANYID            ID                   not null,
   FIRSTNAME            CUSTOMERFIRSTNAME    not null,
   LASTNAME             CUSTOMERLASTNAME     not null,
   GENDER               CUSTOMERGENDER       not null,
   EMAIL                CUSTOMEREMAIL        not null,
   constraint PK_CUSTOMER primary key (CUSTOMERID)
)
go

/*==============================================================*/
/* Index: CUSTOMER_PURCHASES_FROM_COMPANY_FK                    */
/*==============================================================*/




create nonclustered index CUSTOMER_PURCHASES_FROM_COMPANY_FK on CUSTOMER (COMPANYID ASC)
go

/*==============================================================*/
/* Table: INVENTORY                                             */
/*==============================================================*/
create table INVENTORY (
   INVENTORYID          ID                   identity,
   PRODUCTID            ID                   not null,
   COMPANYID            ID                   not null,
   QUANTITY             INVENTORYQUANTITY    not null,
   QUANTITY_MAX         INVENTORYQUANTITYMAX not null,
   constraint PK_INVENTORY primary key (INVENTORYID)
)
go

/*==============================================================*/
/* Index: INVENTORY_HAS_PRODUCT_FK                              */
/*==============================================================*/




create nonclustered index INVENTORY_HAS_PRODUCT_FK on INVENTORY (PRODUCTID ASC)
go

/*==============================================================*/
/* Index: COMPANY_HAS_INVENTORY_FK                              */
/*==============================================================*/

create nonclustered index COMPANY_HAS_INVENTORY_FK on INVENTORY (COMPANYID ASC)
go

/*==============================================================*/
/* Table: PRODUCT                                               */
/*==============================================================*/
create table PRODUCT (
   PRODUCTID            ID                   identity,
   NAME                 COMPANYNAME          not null,
   PRICE_PER_KG         PRODUCTPRICE         not null,
   constraint PK_PRODUCT primary key (PRODUCTID)
)
go

/*==============================================================*/
/* Table: "TRANSACTION"                                         */
/*==============================================================*/
create table "TRANSACTION" (
   TRANSACTIONID        ID                   identity,
   COMPANYID            ID                   not null,
   PRODUCTID            ID                   not null,
   QUANTITY_SOLD        TRANSACTIONQUANTITYSOLD not null,
   DATE_SOLD            TRANSACTIONDATESOLD  not null,
   constraint PK_TRANSACTION primary key (TRANSACTIONID)
)
go

/*==============================================================*/
/* Index: COMPANY_MAKES_TRANSACTION_FK                          */
/*==============================================================*/




create nonclustered index COMPANY_MAKES_TRANSACTION_FK on "TRANSACTION" (COMPANYID ASC)
go

/*==============================================================*/
/* Index: TRANSACTION_CONTAINS_PRODUCT_FK                       */
/*==============================================================*/




create nonclustered index TRANSACTION_CONTAINS_PRODUCT_FK on "TRANSACTION" (PRODUCTID ASC)
go

alter table COMPANYPRODUCTS
   add constraint FK_COMPANYP_COMPANYPR_COMPANY foreign key (COMPANYID)
      references COMPANY (COMPANYID)
         on update CASCADE
         on delete CASCADE
go

alter table COMPANYPRODUCTS
   add constraint FK_COMPANYP_COMPANYPR_PRODUCT foreign key (PRODUCTID)
      references PRODUCT (PRODUCTID)
         on update CASCADE
         on delete CASCADE
go

alter table CUSTOMER
   add constraint FK_CUSTOMER_CUSTOMER__COMPANY foreign key (COMPANYID)
      references COMPANY (COMPANYID)
         on update CASCADE
         on delete CASCADE
go

alter table INVENTORY
   add constraint FK_INVENTOR_COMPANY_H_COMPANY foreign key (COMPANYID)
      references COMPANY (COMPANYID)
         on update CASCADE
         on delete CASCADE
go

alter table INVENTORY
   add constraint FK_INVENTOR_INVENTORY_PRODUCT foreign key (PRODUCTID)
      references PRODUCT (PRODUCTID)
         on update CASCADE
         on delete CASCADE
go

alter table "TRANSACTION"
   add constraint FK_TRANSACT_COMPANY_M_COMPANY foreign key (COMPANYID)
      references COMPANY (COMPANYID)
         on update CASCADE
         on delete NO ACTION
go


alter table "TRANSACTION"
   add constraint FK_TRANSACT_TRANSACTI_PRODUCT foreign key (PRODUCTID)
      references PRODUCT (PRODUCTID)
         on update CASCADE
         on delete NO ACTION
go
