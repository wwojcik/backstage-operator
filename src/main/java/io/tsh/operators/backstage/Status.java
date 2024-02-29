package io.tsh.operators.backstage;

public class Status {

    public enum State {
        PROCESSED,
        UNKNOWN
    }

    private Status.State backstageStage = Status.State.UNKNOWN;
    private Status.State postgresqlStage = Status.State.UNKNOWN;
    /**
	 * @return the postgresqlStage
	 */
	public Status.State getPostgresqlStage() {
		return postgresqlStage;
	}

	/**
	 * @param postgresqlStage the postgresqlStage to set
	 */
	public void setPostgresqlStage(Status.State postgresqlStage) {
		this.postgresqlStage = postgresqlStage;
	}

    /**
	 * @return the backstageStage
	 */
	public Status.State getBackstageStage() {
		return backstageStage;
	}

	/**
	 * @param backstageStage the backstageStage to set
	 */
	public void setBackstageStage(Status.State backstageStage) {
		this.backstageStage = backstageStage;
	}


    public Status() {

    }

}
