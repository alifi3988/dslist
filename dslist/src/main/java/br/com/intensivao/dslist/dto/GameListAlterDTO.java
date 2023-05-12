package br.com.intensivao.dslist.dto;

public class GameListAlterDTO {
	
	private Integer		sourceIndex;
	private Integer		destinationIndex;
	
	public GameListAlterDTO() {
		
	}

	public GameListAlterDTO(int sourceIndex, int destinationIndex) {
		this.sourceIndex = sourceIndex;
		this.destinationIndex = destinationIndex;
	}

	public Integer getSourceIndex() {
		return sourceIndex;
	}

	public void setSourceIndex(Integer sourceIndex) {
		this.sourceIndex = sourceIndex;
	}

	public Integer getDestinationIndex() {
		return destinationIndex;
	}

	public void setDestinationIndex(Integer destinationIndex) {
		this.destinationIndex = destinationIndex;
	}
}
