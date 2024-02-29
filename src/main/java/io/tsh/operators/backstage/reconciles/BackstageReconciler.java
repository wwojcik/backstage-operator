package io.tsh.operators.backstage.reconciles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.javaoperatorsdk.operator.api.reconciler.Context;
import io.javaoperatorsdk.operator.api.reconciler.ControllerConfiguration;
import io.javaoperatorsdk.operator.api.reconciler.Reconciler;
import io.javaoperatorsdk.operator.api.reconciler.UpdateControl;
import io.tsh.operators.backstage.Backstage;
import io.tsh.operators.backstage.Status;
import jakarta.inject.Inject;
@ControllerConfiguration(name = "backstage-controller")
public class BackstageReconciler implements Reconciler<Backstage> {
    static final Logger log = LoggerFactory.getLogger(BackstageReconciler.class);

    @Inject
    KubernetesClient client;

    @Override
    public UpdateControl<Backstage> reconcile(Backstage resource, Context<Backstage> context)
            throws Exception {
        Status status = resource.getStatus();
        if (status != null && Status.State.PROCESSED == status.getBackstageStage()) {
            log.info("Resource already processed, doing nothing");
            return UpdateControl.noUpdate();
        }
        log.info("Processing resources {}", resource.getMetadata().getName());
        return UpdateControl.updateResource(resource);
    }

}
