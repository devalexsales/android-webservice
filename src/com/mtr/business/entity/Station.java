package com.mtr.business.entity;

import java.util.Date;


public class Station {
	
	private Long id;
	
	private int stationNo;
	
	private String stationCode;
	
	private String line;
	
	private String line_Ch;
	
	private String stationName;
	
	private String stationName_Ch;
	
	private Date lastUpdate;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getStationNo() {
		return stationNo;
	}
	public void setStationNo(int stationNo) {
		this.stationNo = stationNo;
	}
	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getLine_Ch() {
		return line_Ch;
	}
	public void setLine_Ch(String line_Ch) {
		this.line_Ch = line_Ch;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getStationName_Ch() {
		return stationName_Ch;
	}
	public void setStationName_Ch(String stationName_Ch) {
		this.stationName_Ch = stationName_Ch;
	}
	
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public void generateValues(String[] strings) {
		if (strings.length > 4) {
			this.stationNo = (strings[0] == null || !strings[0].matches("^[0-9]+$")) ? 0 : Integer.parseInt(strings[0]);
			this.stationCode = strings[1];
			this.line = strings[2];
			this.line_Ch = strings[3];
			this.stationName = strings[4];
			this.stationName_Ch = strings[5];
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("stationNo:["+stationNo+"],");
		sb.append("stationCode:["+stationCode+"],");
		sb.append("line:["+line+"],");
		sb.append("line_Ch:["+line_Ch+"],");
		sb.append("stationName:["+stationName+"],");
		sb.append("stationName_Ch:["+stationName_Ch+"],");
		sb.append("lastUpdate:["+lastUpdate+"]");
		return sb.toString();
	}

}


