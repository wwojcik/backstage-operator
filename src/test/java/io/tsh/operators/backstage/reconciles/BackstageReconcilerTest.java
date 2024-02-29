package io.tsh.operators.backstage.reconciles;

import static java.util.concurrent.TimeUnit.MINUTES;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.javaoperatorsdk.operator.Operator;
import io.quarkus.test.junit.QuarkusTest;
import io.tsh.operators.backstage.Backstage;
import io.tsh.operators.backstage.Status;
import io.tsh.operators.backstage.spec.BackstageSpec;
import io.tsh.operators.backstage.spec.PostgresqlSpec;
import jakarta.inject.Inject;
@QuarkusTest
public class BackstageReconcilerTest {

    private static final String BACKSTAGE_REQUEST_NAME = "mybackstage1";

    @Inject
    Operator operator;

    @Inject
    KubernetesClient client;

    @Test
    void canReconcile() {
        final Backstage testRequest = new Backstage();
        testRequest.setMetadata(new ObjectMetaBuilder()
                .withName(BACKSTAGE_REQUEST_NAME)
                .withNamespace(client.getNamespace())
                .build());
        // act
        client.resource(testRequest).create();
         // assert
        await().ignoreException(NullPointerException.class).atMost(1, MINUTES).untilAsserted(() -> {
            Backstage updatedRequest = client.resource(testRequest).get();
            assertThat(updatedRequest.getStatus(), is(notNullValue()));
            assertThat(updatedRequest.getStatus().getBackstageStage(), is(Status.State.PROCESSED));
        });
    }

    @Test
    void itShouldCreatePostgresqlInstance(){
        final Backstage testRequest = new Backstage();
        final BackstageSpec spec = new BackstageSpec();
        final PostgresqlSpec postgresqlSpec = new PostgresqlSpec();
        postgresqlSpec.setCreate(true);
        spec.setPostgresql(postgresqlSpec);
        testRequest.setSpec(spec);
        testRequest.setMetadata(new ObjectMetaBuilder()
                .withName(BACKSTAGE_REQUEST_NAME)
                .withNamespace(client.getNamespace())
                .build());
        // act
        client.resource(testRequest).create();
        // assert
        await().ignoreException(NullPointerException.class).atMost(1, MINUTES).untilAsserted(() -> {
            Backstage updatedRequest = client.resource(testRequest).get();
            assertThat(updatedRequest.getStatus(), is(notNullValue()));
            assertThat(updatedRequest.getStatus().getPostgresqlStage(), is(Status.State.PROCESSED));
            assertThat(updatedRequest.getStatus().getPostgresqlStage(), is(notNullValue()));
        });
    }

}
