package kr.or.jaegaebal.dto;

public class SalaryRecord {
	private String dataNum;
	private String dataData;
	private String dataDate;
	private int dataPay;
	private int dataNormal;
	private int dataBonus;
	private int dataMalus;
	private int dataAnn;
	private int dataVehicle;
	private int dataMeal;
	private int dataOvertime;
	private int dataNight;
	private int dataHoli;
	private int dataGukmin;
	private int dataGeongang;
	private int dataKhoyong;
	private int dataJanggi;
	private int dataSanjae;
	private int dataSchexpan;
	private int dataIncome;
	private int dataLoincome;
	private String dataAddpay;
	private String dataPricepay;
	private int dataSumpay;
	private String dataAdddeduct;
	private String dataPricededuct;
	private int dataSumdeduct;
	private String sqlKey;
	
	public String getDataNum() {
		return dataNum;
	}
	public void setDataNum(String dataNum) {
		this.dataNum = dataNum;
	}
	public String getDataData() {
		return dataData;
	}
	public void setDataData(String dataData) {
		this.dataData = dataData;
	}
	public String getDataDate() {
		return dataDate;
	}
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}
	public int getDataPay() {
		return dataPay;
	}
	public void setDataPay(int dataPay) {
		this.dataPay = dataPay;
	}
	public int getDataNormal() {
		return dataNormal;
	}
	public void setDataNormal(int dataNormal) {
		this.dataNormal = dataNormal;
	}
	public int getDataBonus() {
		return dataBonus;
	}
	public void setDataBonus(int dataBonus) {
		this.dataBonus = dataBonus;
	}
	public int getDataMalus() {
		return dataMalus;
	}
	public void setDataMalus(int dataMalus) {
		this.dataMalus = dataMalus;
	}
	public int getDataAnn() {
		return dataAnn;
	}
	public void setDataAnn(int dataAnn) {
		this.dataAnn = dataAnn;
	}
	public int getDataVehicle() {
		return dataVehicle;
	}
	public void setDataVehicle(int dataVehicle) {
		this.dataVehicle = dataVehicle;
	}
	public int getDataMeal() {
		return dataMeal;
	}
	public void setDataMeal(int dataMeal) {
		this.dataMeal = dataMeal;
	}
	public int getDataOvertime() {
		return dataOvertime;
	}
	public void setDataOvertime(int dataOvertime) {
		this.dataOvertime = dataOvertime;
	}
	public int getDataNight() {
		return dataNight;
	}
	public void setDataNight(int dataNight) {
		this.dataNight = dataNight;
	}
	public int getDataHoli() {
		return dataHoli;
	}
	public void setDataHoli(int dataHoli) {
		this.dataHoli = dataHoli;
	}
	public int getDataGukmin() {
		return dataGukmin;
	}
	public void setDataGukmin(int dataGukmin) {
		this.dataGukmin = dataGukmin;
	}
	public int getDataGeongang() {
		return dataGeongang;
	}
	public void setDataGeongang(int dataGeongang) {
		this.dataGeongang = dataGeongang;
	}
	public int getDataKhoyong() {
		return dataKhoyong;
	}
	public void setDataKhoyong(int dataKhoyong) {
		this.dataKhoyong = dataKhoyong;
	}
	public int getDataJanggi() {
		return dataJanggi;
	}
	public void setDataJanggi(int dataJanggi) {
		this.dataJanggi = dataJanggi;
	}
	public int getDataSanjae() {
		return dataSanjae;
	}
	public void setDataSanjae(int dataSanjae) {
		this.dataSanjae = dataSanjae;
	}
	public int getDataSchexpan() {
		return dataSchexpan;
	}
	public void setDataSchexpan(int dataSchexpan) {
		this.dataSchexpan = dataSchexpan;
	}
	public int getDataIncome() {
		return dataIncome;
	}
	public void setDataIncome(int dataIncome) {
		this.dataIncome = dataIncome;
	}
	public int getDataLoincome() {
		return dataLoincome;
	}
	public void setDataLoincome(int dataLoincome) {
		this.dataLoincome = dataLoincome;
	}
	public String getDataAddpay() {
		return dataAddpay;
	}
	public void setDataAddpay(String dataAddpay) {
		this.dataAddpay = dataAddpay;
	}
	public String getDataPricepay() {
		return dataPricepay;
	}
	public void setDataPricepay(String dataPricepay) {
		this.dataPricepay = dataPricepay;
	}
	public int getDataSumpay() {
		return dataSumpay;
	}
	public void setDataSumpay(int dataSumpay) {
		this.dataSumpay = dataSumpay;
	}
	public String getDataAdddeduct() {
		return dataAdddeduct;
	}
	public void setDataAdddeduct(String dataAdddeduct) {
		this.dataAdddeduct = dataAdddeduct;
	}
	public String getDataPricededuct() {
		return dataPricededuct;
	}
	public void setDataPricededuct(String dataPricededuct) {
		this.dataPricededuct = dataPricededuct;
	}
	public int getDataSumdeduct() {
		return dataSumdeduct;
	}
	public void setDataSumdeduct(int dataSumdeduct) {
		this.dataSumdeduct = dataSumdeduct;
	}
	public String getSqlKey() {
		return sqlKey;
	}
	public void setSqlKey(String sqlKey) {
		this.sqlKey = sqlKey;
	}
	@Override
	public String toString() {
		return "SalaryRecord [dataNum=" + dataNum + ", dataData=" + dataData + ", dataDate=" + dataDate + ", dataPay="
				+ dataPay + ", dataNormal=" + dataNormal + ", dataBonus=" + dataBonus + ", dataMalus=" + dataMalus
				+ ", dataAnn=" + dataAnn + ", dataVehicle=" + dataVehicle + ", dataMeal=" + dataMeal + ", dataOvertime="
				+ dataOvertime + ", dataNight=" + dataNight + ", dataHoli=" + dataHoli + ", dataGukmin=" + dataGukmin
				+ ", dataGeongang=" + dataGeongang + ", dataKhoyong=" + dataKhoyong + ", dataJanggi=" + dataJanggi
				+ ", dataSanjae=" + dataSanjae + ", dataSchexpan=" + dataSchexpan + ", dataIncome=" + dataIncome
				+ ", dataLoincome=" + dataLoincome + ", dataAddpay=" + dataAddpay + ", dataPricepay=" + dataPricepay
				+ ", dataSumpay=" + dataSumpay + ", dataAdddeduct=" + dataAdddeduct + ", dataPricededuct="
				+ dataPricededuct + ", dataSumdeduct=" + dataSumdeduct + ", sqlKey=" + sqlKey + "]";
	}
}
