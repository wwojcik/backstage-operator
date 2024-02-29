package io.tsh.operators.backstage;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Kind;
import io.fabric8.kubernetes.model.annotation.Plural;
import io.fabric8.kubernetes.model.annotation.Version;
import io.tsh.operators.backstage.spec.BackstageSpec;

@Group(Backstage.GROUP_STRING)
@Version(Backstage.VERSION_STRING)
@JsonInclude(Include.NON_NULL)
@Kind(Backstage.KIND)
@Plural(Backstage.PLURAL)
public class Backstage extends CustomResource<BackstageSpec, Status> implements Namespaced {
    public static final String KIND = "backstage";
    public static final String PLURAL = "backstages";
    public static final String GROUP_STRING = "operators.tsh.io";
    public static final String VERSION_STRING = "v1alpha1";



    public Backstage() {
    }
}
