package com.spring.tourist.util.dvo;

public class PageMaker {

	private int board_num_page;
	private int totalPage;
	private int startBlock;
	private int endBlock;
	private boolean nextPage;
	private boolean perPage;
	private Critia critia;


	
	
	public int getBoard_num_page() {
		return board_num_page;
	}

	public void setBoard_num_page(int board_num_page) {
		this.board_num_page = board_num_page;
	}

	public Critia getCritia() {
		return critia;
	}

	public void setCritia(Critia critia) {
		this.critia = critia;
	}

	public PageMaker(Critia critia, int count) {
		this.board_num_page=5;
		setCritia(critia);
		setTotalPage(count);
		setBlock();

	}

	public void setBlock() {
		startBlock = ((critia.getPage() - 1) / board_num_page) * board_num_page + 1;
		endBlock = startBlock + board_num_page - 1;
		if (endBlock > totalPage) {
			endBlock = totalPage;
		}
		perPage = (critia.getPage() == 1) ? false : true;
		nextPage = endBlock >= totalPage ? false : true;

	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int count) {
		
		int total = count / critia.getNumPage();
		if (total % critia.getNumPage() > 0) {
			total++;
		}
		this.totalPage = total;
	
	}

	
	public int getStartBlock() {
		return startBlock;
	}

	public void setStartBlock(int startBlock) {
		this.startBlock = startBlock;
	}

	public int getEndBlock() {
		return endBlock;
	}

	public void setEndBlock(int endBlock) {
		this.endBlock = endBlock;
	}

	public boolean isNextPage() {
		return nextPage;
	}

	public void setNextPage(boolean nextPage) {
		this.nextPage = nextPage;
	}

	public boolean isPerPage() {
		return perPage;
	}

	public void setPerPage(boolean perPage) {
		this.perPage = perPage;
	}

	




}
