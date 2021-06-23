DROP TABLE IF EXISTS river_water_wqi1 CASCADE;

create table river_water_wqi1(
	zone varchar(30),
	wcz varchar(10),
	subzone varchar(100),
	river varchar(100),
	station varchar(5),
	mdate timestamp not null,
	stime decimal(4,0),
	sample_no decimal(2,0),
	l_bod5 varchar(1),
	bod5 decimal(22,6),
	l_nh4 varchar(1),
	nh4 decimal(22,6),
	l_dos varchar(1),
	dos decimal(22,6),
	bod5_pt decimal(1,0),
	nh4_pt decimal(1,0),
	dos_pt decimal(1,0),
	wqi_pt decimal(3,0),
	wqi_grade varchar(10),
	view_no decimal(2,0),
	constraint pk_river_water_wqi1 primary key (station,mdate)
);

ALTER TABLE river_water_wqi1 add CONSTRAINT fk_river_water_wqi1
FOREIGN KEY(station)
REFERENCES rstation(statname)  ON DELETE NO ACTION  ON UPDATE NO ACTION;

