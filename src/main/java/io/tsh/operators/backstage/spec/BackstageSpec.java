package io.tsh.operators.backstage.spec;

import com.github.dockerjava.api.model.ResourceSpecs;

import io.fabric8.kubernetes.api.model.NodeSelector;

public class BackstageSpec {
    /**
     * The image reference to use for the pod
     */
    private String imageRef;
    /**
     * The node selector to use for the pod
     */
    private NodeSelector nodeSelector;
    /**
     * The resources to use for the pod
     */
    private ResourceSpecs resources;

    /**
     * The postgresql spec
     */
    private PostgresqlSpec postgresql;

    /**
	 * @return the postgresql
	 */
	public PostgresqlSpec getPostgresql() {
		return postgresql;
	}

	/**
	 * @param postgresql the postgresql to set
	 */
	public void setPostgresql(PostgresqlSpec postgresql) {
		this.postgresql = postgresql;
	}

	/**
     * @return the resources
     */
    public ResourceSpecs getResources() {
        return resources;
    }

    /**
     * @param resources the resources to set
     */
    public void setResources(ResourceSpecs resources) {
        this.resources = resources;
    }

    /**
     * @return the nodeSelector
     */
    public NodeSelector getNodeSelector() {
        return nodeSelector;
    }

    /**
     * @param nodeSelector the nodeSelector to set
     */
    public void setNodeSelector(NodeSelector nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    /**
     * @return the imageRef
     */
    public String getImageRef() {
        return imageRef;
    }

    /**
     * @param imageRef the imageRef to set
     */
    public void setImageRef(String imageRef) {
        this.imageRef = imageRef;
    }
}
