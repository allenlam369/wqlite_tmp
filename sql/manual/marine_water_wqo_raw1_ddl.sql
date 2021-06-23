DROP TABLE IF EXISTS marine_water_wqo_raw1 CASCADE;

create table marine_water_wqo_raw1
   (
      zone_ varchar(30),
      wcz varchar(10),
      subzone varchar(100),
      station varchar(10),
      mdate timestamp not null,
      stime decimal(4,0),
      sample_no decimal(4,0),
	  
	  dos decimal(7,3),
	  dom decimal(7,3),
	  dob decimal(7,3),
	  doc decimal(38,6),
	  doa decimal(38,6),
	  tin decimal(38,6),
      nh3 decimal(38,8),
	  ecoli double precision,
	  min_dos decimal(2,1),
	  min_dos_pc decimal(3,0),
	  min_dom decimal(2,1),
	  min_dom_pc decimal(3,0),
	  min_dob decimal(2,1),
	  min_dob_pc decimal(3,0),
	  min_doc decimal(2,1),
	  min_doc_pc decimal(3,0),
	  min_doa decimal(2,1),
	  min_doa_pc decimal(3,0),
	  max_tin_aam decimal(2,1),
	  max_nh3_aam decimal(4,3),
	  max_ecoli_agm decimal(4,0),
	  meet_dos varchar(3),
	  meet_dom varchar(3),
	  meet_dob varchar(3),
	  meet_doc varchar(3),
	  meet_doa varchar(3),
	  
      constraint pk_marine_water_wqo_raw1 primary key (station,mdate)
   );

