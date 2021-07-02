CREATE VIEW WPG.RW_ANNUAL_WQI AS


SELECT a.site_id,
    s.station,
    s.yr,
    s.[zone],
    s.wcz,
    s.subzone,
    s.river,
    s.total,
    s.min_ph,
    s.max_ph,
    s.n_ph,
    s.m_ph,
    s.rate_ph,
    s.n_bod5,
    s.max_bod5,
    s.m_bod5,
    s.rate_bod5,
    s.max_cod,
    s.n_cod,
    s.m_cod,
    s.rate_cod,
    s.min_do,
    s.n_do,
    s.m_do,
    s.rate_do,
    s.max_amd_ss,
    s.n_ss,
    s.rate_ss_amd,
    s.rate_4wqo,
    s.rate_5wqo,
    a.bod5_pt_avg,
    a.nh4_pt_avg,
    a.dos_pt_avg,
    a.wqi_pt_avg,
    a.wqi_grade_avg
   FROM [WPG].[river_water_wqo_sum0] as s
     JOIN [WPG].[rstation] as r ON s.station = r.statname
     JOIN [WPG].[rw_wqi_avg] as a ON a.site_id = r.site_id
  WHERE s.yr = a.yr;
