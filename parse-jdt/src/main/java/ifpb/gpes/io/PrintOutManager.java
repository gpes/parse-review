package ifpb.gpes.io;

import ifpb.gpes.ExportManager;
import ifpb.gpes.Call;
import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 07/07/2017, 16:09:20
 */
public class PrintOutManager  implements ExportManager {

        @Override
        public void export(List<Call> elements) {
            elements.stream()
//                    .filter(t -> t.getMi() != null || "null".equalsIgnoreCase(t.getMi()))
//                    .collect(Collectors.toList())
                    .forEach(no -> System.out.println(no.callGraph()));

        }
    }