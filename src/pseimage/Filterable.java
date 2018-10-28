package pseimage;

import java.util.List;

/**
 *
 * @author Herbert
 */
public interface Filterable {
    
    /**
     * Converts an image into another.
     * @param params a list of input parameters needed by the filter application.
     * @return a name that identifies the file created with the filtered image.
     */
    String filter(List<String> params);
    
}
