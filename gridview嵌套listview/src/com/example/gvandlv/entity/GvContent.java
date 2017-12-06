package com.example.gvandlv.entity;

import java.util.List;

public class GvContent {

	private String tv;
	
	private List<LvContent> lv;
	
	

	public GvContent(String tv, List<LvContent> lv) {
		super();
		this.tv = tv;
		this.lv = lv;
	}

	public String getTv() {
		return tv;
	}

	public void setTv(String tv) {
		this.tv = tv;
	}
	
	
	
	public List<LvContent> getLv() {
		return lv;
	}

	public void setLv(List<LvContent> lv) {
		this.lv = lv;
	}



	public static class LvContent{
		
		
		
		private String lv_tv;

		
		
		public LvContent(String lv_tv) {
			super();
			this.lv_tv = lv_tv;
		}

		public String getLv_tv() {
			return lv_tv;
		}

		public void setLv_tv(String lv_tv) {
			this.lv_tv = lv_tv;
		}
		
		
		
	}
	
}
