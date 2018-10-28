package pseimage;

import java.util.ArrayList;
import java.util.List;

/**
 * O filtro Laplaciano é um filtro passa-altas. Ele é utilizado para evidenciar
 * as componentes de alta frequência da imagem (bordas). Como efeito colateral
 * ele também realça ruídos existentes na imagem.
 * A função recebe um único argumento que indica o nome da imagem a ser processada.
 * Uma nova imagem será armazenada no disco com a identificação "laplace" e o 
 * nome desse arquivo é retornado pela função. 
 */
public class Laplace extends Filter implements Filterable{    
    
    @Override
    public String filter(List<String> params) {
        
        this.openImage(params.get(0));
        this.setFilteredImageName("laplace");
        
        List<String> laplaceMask = new ArrayList<>();
        laplaceMask.add(this.file);
        laplaceMask.add("3");
        laplaceMask.add("3");
        laplaceMask.add("laplace");
        laplaceMask.add("0");
        laplaceMask.add("-1");
        laplaceMask.add("0");
        laplaceMask.add("-1");
        laplaceMask.add("4");
        laplaceMask.add("-1");
        laplaceMask.add("0");
        laplaceMask.add("-1");
        laplaceMask.add("0");     
        
        return new GenericMask().filter(laplaceMask);
    }       
    
}
