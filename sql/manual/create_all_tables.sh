#!/bin/bash

export PGPASSWORD=postgres
psql -h localhost -U postgres -p 5432 -d wqplis_tmp --file ten_zone.sql
psql -h localhost -U postgres -p 5432 -d wqplis_tmp --file wpco_wcz.sql
psql -h localhost -U postgres -p 5432 -d wqplis_tmp --file wpco_sz.sql
psql -h localhost -U postgres -p 5432 -d wqplis_tmp --file river.sql
psql -h localhost -U postgres -p 5432 -d wqplis_tmp --file rstation.sql
psql -h localhost -U postgres -p 5432 -d wqplis_tmp --file mstation.sql
psql -h localhost -U postgres -p 5432 -d wqplis_tmp --file bm_beach.sql
psql -h localhost -U postgres -p 5432 -d wqplis_tmp --file bm_beach_ec_agm_rank_report.sql
psql -h localhost -U postgres -p 5432 -d wqplis_tmp --file bm_visit_label_summary.sql
psql -h localhost -U postgres -p 5432 -d wqplis_tmp --file marine_water1.sql
psql -h localhost -U postgres -p 5432 -d wqplis_tmp --file marine_water2.sql
psql -h localhost -U postgres -p 5432 -d wqplis_tmp --file marine_water_wqo_raw1.sql
psql -h localhost -U postgres -p 5432 -d wqplis_tmp --file river_water1.sql
psql -h localhost -U postgres -p 5432 -d wqplis_tmp --file river_water2.sql
psql -h localhost -U postgres -p 5432 -d wqplis_tmp --file river_water_wqi1.sql
psql -h localhost -U postgres -p 5432 -d wqplis_tmp --file river_water_wqo_sum0.sql
psql -h localhost -U postgres -p 5432 -d wqplis_tmp --file rw_wqi_avg.sql
