package bwqfds;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;

import common.EntityManagerUtil;
import common.Utils;
import model.BmVisitLabelSummary;

public class CollectDataForSect1 {
	static private EntityManager em = EntityManagerUtil.getEntityManager(); // for postgres

	public static void main(String[] args) {
		em.getTransaction().begin();
		List<BmVisitLabelSummary> list = twoDaysAgo();

		StringBuilder sb = new StringBuilder();
		toCsv(list, sb);

		System.out.println(sb.toString().replaceAll("null", ""));
	}

	private static void toCsv(List<BmVisitLabelSummary> list, StringBuilder sb) {
		sb.append(
				"beach	date	time	temp	do	dosat	sal	ph	turb	bather	eca	ecb	ecc	ecd	source1	source2	source3	source4	source5	s1_salinity	s2_salinity	s3_salinity	s4_salinity	s5_salinity	s1_flow	s2_flow	s3_flow	s4_flow	s5_flow	f1_flow	f2_flow	f3_flow	f4_flow	f5_flow	freshwater1	freshwater2	freshwater3	freshwater4	freshwater5	g_mean	r_g_mean	grade	dayappend	dayedit	dayupload\n");

		String pattern1 = "dd/MM/yyyy";
		String pattern2 = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf1 = new SimpleDateFormat(pattern1);
		SimpleDateFormat sdf2 = new SimpleDateFormat(pattern2);

		for (int i = 0; i < list.size(); i++) {
			BmVisitLabelSummary row = list.get(i);
			sb.append(row.getBeachCode()).append('\t');
			sb.append(sdf1.format(row.getSampleDate())).append('\t');
			sb.append(row.getSampleTime()).append('\t');
			sb.append(row.getTemper()).append('\t');
			sb.append(row.getDo_()).append('\t');
			sb.append(row.getDos()).append('\t');
			sb.append(row.getSal()).append('\t');
			sb.append(row.getPh()).append('\t');
			sb.append(row.getTurb()).append('\t');
			sb.append(row.getBatherValue()).append('\t');
			sb.append(row.getEcR()).append('\t');
			sb.append(row.getEcM()).append('\t');
			sb.append(row.getEcL()).append('\t');
			sb.append(row.getEcO()).append('\t');
			sb.append(row.getEcS1()).append('\t');
			sb.append(row.getEcS2()).append('\t');
			sb.append(row.getEcS3()).append('\t');
			sb.append(row.getEcS4()).append('\t');
			sb.append(row.getEcS5()).append('\t');
			sb.append(row.getSalS1()).append('\t');
			sb.append(row.getSalS2()).append('\t');
			sb.append(row.getSalS3()).append('\t');
			sb.append(row.getSalS4()).append('\t');
			sb.append(row.getSalS5()).append('\t');
			sb.append(row.getFlowS1()).append('\t');
			sb.append(row.getFlowS2()).append('\t');
			sb.append(row.getFlowS3()).append('\t');
			sb.append(row.getFlowS4()).append('\t');
			sb.append(row.getFlowS5()).append('\t');
			sb.append(row.getFlowF1()).append('\t');
			sb.append(row.getFlowF2()).append('\t');
			sb.append(row.getFlowF3()).append('\t');
			sb.append(row.getFlowF4()).append('\t');
			sb.append(row.getFlowF5()).append('\t');
			sb.append(row.getEcF1()).append('\t');
			sb.append(row.getEcF2()).append('\t');
			sb.append(row.getEcF3()).append('\t');
			sb.append(row.getEcF4()).append('\t');
			sb.append(row.getEcF5()).append('\t');
			sb.append(row.getGMean()).append('\t');
			sb.append(row.getRGMean()).append('\t');
			sb.append(row.getGrade()).append('\t');
			sb.append(sdf2.format(row.getDayappend())).append('\t');
			sb.append(sdf2.format(row.getDayedit())).append('\t');
			sb.append(sdf2.format(row.getDayupload())).append('\n');
		}
	}

	// HKU_BMDS
	private static List<BmVisitLabelSummary> twoDaysAgo() {
		String theDayBefore = Utils.getTodayMinusTwo();
//		System.err.println(theDayBefore);

		String sql = "from BmVisitLabelSummary where sample_date = '" + theDayBefore + "' order by beach_code";

		@SuppressWarnings("unchecked")
		List<BmVisitLabelSummary> list = em.createQuery(sql).getResultList();

		return list;
	}

}
