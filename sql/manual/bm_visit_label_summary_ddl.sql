DROP TABLE IF EXISTS bm_visit_label_summary CASCADE;

create table bm_visit_label_summary (
	district_name varchar(45),
	beach_name varchar(52),
	beach_group varchar(2),
	closed varchar(1),
	district_order varchar(3),
	list_order varchar(3),
	bmvisit_id varchar(14) not null,
	site_id decimal(4,0),
	mdate timestamp not null,
	stime decimal(4,0),
	sample_no decimal(2,0),
	beach_code varchar(5),
	sample_date timestamp,
	sample_time varchar(5),
	temper decimal(3,1),
	do_ decimal(4,2),
	dos decimal(4,1),
	sal decimal(4,2),
	sal_r decimal(38,2),
	sal_m decimal(38,2),
	sal_l decimal(38,2), 
	sal_o decimal(38,2),
	ph decimal(4,2),
	turb decimal(6,2),
	weather_value decimal(1,0),
	wind_value decimal(1,0),
	climate_value decimal(1,0),
	sea_clarity_value decimal(1,0),
	sea_condition_value decimal(1,0),
	wind_direction varchar(3),
	bather_value decimal(1,0),
	tide_value decimal(1,0),
	tide_ratio decimal(5,2),
	tide_height decimal(5,2),
	abs_tide_height decimal(5,2),
	ec_r decimal(38,0),
	ec_m decimal(38,0),
	ec_l decimal(38,0),
	ec_o decimal(38,0),
	ec_s1 decimal(38,0),
	ec_s2 decimal(38,0),
	ec_s3 decimal(38,0),
	ec_s4 decimal(38,0),
	ec_s5 decimal(38,0),
	sal_s1 decimal(38,2),
	sal_s2 decimal(38,2),
	sal_s3 decimal(38,2),
	sal_s4 decimal(38,2),
	sal_s5 decimal(38,2),
	sal_s1_2 decimal(38,2),
	sal_s2_2 decimal(38,2),
	sal_s3_2 decimal(38,2),
	sal_s4_2 decimal(38,2),
	sal_s5_2 decimal(38,2),
	sal_f1_2 decimal(38,2),
	sal_f2_2 decimal(38,2),
	sal_f3_2 decimal(38,2),
	sal_f4_2 decimal(38,2),
	sal_f5_2 decimal(38,2),
	flow_s1 varchar(2),
	flow_s2 varchar(2),
	flow_s3 varchar(2),
	flow_s4 varchar(2),
	flow_s5 varchar(2),
	flow_f1 varchar(2),
	flow_f2 varchar(2),
	flow_f3 varchar(2),
	flow_f4 varchar(2),
	flow_f5 varchar(2),
	ec_f1 decimal(38,0),
	ec_f2 decimal(38,0),
	ec_f3 decimal(38,0),
	ec_f4 decimal(38,0),
	ec_f5 decimal(38,0),
	fc_r decimal(38,0),
	fc_m decimal(38,0),
	fc_l decimal(38,0),
	fc_o decimal(38,0),
	fc_s1 decimal(38,0),
	fc_s2 decimal(38,0),
	fc_s3 decimal(38,0),
	fc_s4 decimal(38,0),
	fc_s5 decimal(38,0),
	fc_f1 decimal(38,0),
	fc_f2 decimal(38,0),
	fc_f3 decimal(38,0),
	fc_f4 decimal(38,0),
	fc_f5 decimal(38,0),
	g_mean decimal(9,0),
	r_g_mean decimal(9,0),
	log_g_mean decimal(12,8),
	adj_log_gm decimal(12,8),
	mth_g_mean decimal(9,0),
	wk_g_mean decimal(9,0),
	g_mean_fc decimal(9,0),
	r_g_mean_fc decimal(9,0),
	log_g_mean_fc decimal(12,8),
	adj_log_gm_fc decimal(12,8),
	mth_g_mean_fc decimal(9,0),
	wk_g_mean_fc decimal(9,0),
	move_avg decimal(12,8),
	move_avg_fc decimal(12,8),
	grade decimal(2,0),
	grade_change decimal(1,0),
	remarks varchar(200),
	dayappend timestamp,
	dayedit timestamp,
	dayupload timestamp,
	rain_station_code varchar(3),
	sdatetime timestamp,
	rainfall decimal(5,1),
	rainfall_max_3hr decimal(5,1),
	rainfall_max_time timestamp,
	rainfall_last_12hr decimal(5,1),
	rainfall_last_24hr decimal(5,1),
	rainfall_last_72hr decimal(5,1),
	risk_rain_max_3hr varchar(1),
	risk_rain_last_12hr varchar(1),
	risk_rain_last_24hr varchar(1),
	risk_rain_last_72hr varchar(1),
	weather varchar(20),
	wind varchar(20),
	climate varchar(20),
	sea_clarity varchar(20),
	sea_condition varchar(20),
	bather varchar(20),
	tide varchar(20),
	flow_label_s1 varchar(20),
	flow_label_s2 varchar(20),
	flow_label_s3 varchar(20),
	flow_label_s4 varchar(20),
	flow_label_s5 varchar(20),
	flow_label_f1 varchar(20),
	flow_label_f2 varchar(20),
	flow_label_f3 varchar(20),
	flow_label_f4 varchar(20),
	flow_label_f5 varchar(20),
	tide_station_code varchar(3),
	mrefuse_cleanlines_level decimal(1,0),
	constraint pk_bm_visit_label_summary primary key (bmvisit_id)
);


ALTER TABLE bm_visit_label_summary add CONSTRAINT fk_bm_visit_label_summary
FOREIGN KEY(beach_code)
REFERENCES bm_beach(beach_code)  ON DELETE NO ACTION  ON UPDATE NO ACTION;

