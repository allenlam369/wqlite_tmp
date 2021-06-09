drop table if exists rw_wqi_avg cascade;

create table rw_wqi_avg (
	site_id decimal(4,0),
	yr int,
	total int,
	bod5_pt_avg decimal(38,6),
	nh4_pt_avg decimal(38,6),
	dos_pt_avg decimal(38,6),
	wqi_pt_avg decimal(38,6),
	wqi_grade_avg varchar(10),
	constraint pk_rw_wqi_avg primary key (site_id,yr)
);

alter table rw_wqi_avg add constraint fk_rw_wqi_avg
foreign key(site_id)
references rstation(site_id)  on delete no action  on update no action;

