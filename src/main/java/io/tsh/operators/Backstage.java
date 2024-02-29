package io.tsh.operators;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.tsh.operators.backstage.Status;
import io.tsh.operators.backstage.spec.BackstageSpec;

@Version("v1alpha1")
@Group("operators.tsh.io")
public class Backstage extends CustomResource<BackstageSpec, Status> implements Namespaced { }