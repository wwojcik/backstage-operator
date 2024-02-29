package io.tsh.operators.backstage.spec;

public class PostgresqlSpec {
    private boolean isCreate;
    /**
	 * @return the isCreate
	 */
	public boolean isCreate() {
		return isCreate;
	}
	/**
	 * @param isCreate the isCreate to set
	 */
	public void setCreate(boolean isCreate) {
		this.isCreate = isCreate;
	}
	private String databaseDns;
    private String databaseName;
    private String databasePassword;
    private String databaseUser;
    private String imageRef;
}
