package si.fri.rso;

import com.kumuluz.ee.cors.annotations.CrossOrigin;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("v1")
@CrossOrigin
public class BookingApplication extends Application {
}
