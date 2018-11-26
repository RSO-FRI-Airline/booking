package si.fri.rso.health;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import si.fri.rso.services.configuration.AppProperties;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Health
@ApplicationScoped
public class BookingHealthCheck implements HealthCheck {

    @Inject
    private AppProperties appProperties;

    @Override
    public HealthCheckResponse call() {
        HealthCheckResponseBuilder healthCheckResponseBuilder =
                HealthCheckResponse.named(BookingHealthCheck.class.getSimpleName());
        if (appProperties.isHealthy()) {
            return healthCheckResponseBuilder.up().build();
        } else {
            return healthCheckResponseBuilder.down().build();
        }
    }
}
