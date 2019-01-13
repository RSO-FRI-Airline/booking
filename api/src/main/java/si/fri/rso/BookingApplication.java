package si.fri.rso;


import com.kumuluz.ee.discovery.annotations.RegisterService;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("v1")
@RegisterService
public class BookingApplication extends Application {
}
