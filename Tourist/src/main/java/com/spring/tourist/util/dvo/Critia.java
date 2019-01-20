package com.spring.tourist.util.dvo;

public class Critia {
	private int page;
	private int numPage;
	
	
	
	
	public Critia() {
		// TODO Auto-generated constructor stub
	this(1,10);
		
		
		
	}
	public Critia(int page,int numPage) {
		this.page=page;
		this.numPage=numPage;
	}
	
	




	public int getPage() {
		return page;
	}
	public void setPage(int page) {

		if(page<=0) {
			this.page=1;
			return;
		}
		this.page = page;
	}
	public int getNumPage() {
		return numPage;
	}
	public void setNumPage(int numPage) {
		if(numPage<5||numPage>=100) {
			this.numPage=10;
			return;
		}
		this.numPage = numPage;
	}

}
