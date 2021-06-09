DROP TABLE IF EXISTS bm_beach_ec_agm_rank_report CASCADE;

create table bm_beach_ec_agm_rank_report (
      district_name varchar(50),
      district_name_c varchar(50),
      hotline_district varchar(20),
      hotline_district_c varchar(10),
      beach_name varchar(52) not null,
      chinese_name varchar(24),
      sc_name varchar(24),
      beach_group varchar(2),
      district_order varchar(3),
      beach_code varchar(5),
      year_ int,
      annual_log_g_mean decimal(38,8),
      annual_g_mean decimal(38,8),
      sample_count int,
      rank_ decimal(2,0),
      list_order_2 varchar(3),
      constraint pk_bm_beach_ec_agm_rank_report primary key (beach_code, year_)
);

ALTER TABLE bm_beach_ec_agm_rank_report add CONSTRAINT fk_bm_beach_ec_agm_rank_report
FOREIGN KEY(beach_code)
REFERENCES bm_beach(beach_code)  ON DELETE NO ACTION  ON UPDATE NO ACTION;

