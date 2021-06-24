-- ddl script for table mstation for postgresql
-- generated by (c) ispirer sqlways 9.0 build 6620 64bit licensed to ecom - william leung - united states - ispirer mnmtk 2020 microsoft sql server to postgresql database migration demo license (1 month, 20210626)
-- timestamp: thu may 27 10:22:23 2021
-- create table statement


drop table if exists mstation cascade;


create table mstation
(
   site_id decimal(4,0)  not null,
   mw_name varchar(10),
   ms_name varchar(10),
   mw_ts_name varchar(10),
   ms_ts_name varchar(10),
   ms_dx_name varchar(10),
   hs_name varchar(10),
   mt_name varchar(10),
   depth decimal(3,0),
   sz_id varchar(3),
   easting decimal(9,3),
   northing decimal(9,3),
   latitude decimal(10,7),
   longitude decimal(10,7),
   environment varchar(50),
   start_date timestamp,
   active varchar(1),
   show varchar(1),
   cmmview decimal(2,0),
   wcz_code decimal(3,0),
   mw_id decimal(3,0),
   ms_id decimal(3,0),
   station_id decimal(3,0),
   valid_user varchar(10),
   valid_date timestamp,
   valid_code decimal(3,0),
   easting1 decimal(9,3),
   northing1 decimal(9,3)
);


-- primary key

alter table mstation add constraint pk_mstation
primary key(site_id);

-- alter table mstation add constraint unique_mw_name
-- unique(mw_name);


alter table mstation add constraint fk_mstation_wpco_sz
foreign key(sz_id)
references wpco_sz(sz_id)   on delete no action  on update no action;

CREATE UNIQUE INDEX unique_mw_name
ON mstation(mw_name);


