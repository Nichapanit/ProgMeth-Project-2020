package model;

public enum CHARACTER {
	PENGUIN(ClassLoader.getSystemResource("penguin.png").toString()),
	BEAR(ClassLoader.getSystemResource("polar bear.png").toString()),
	MOOSE(ClassLoader.getSystemResource("seal.png").toString());

	private String characterUrl;

	private CHARACTER(String characterUrl) {
		this.characterUrl = characterUrl;
	}

	public String getCharacterUrl() {
		return this.characterUrl;
	}

}
