package pseimage;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.PriorityQueue;

/**
 * O filtro de mínima realça regiões escuras da imagem. Ele aumenta o tamanho de
 * objetos mais escuros que o fundo e diminui o tamanho de objetos mais claros
 * que o fundo em que estão inseridos.
 * A função recebe um único argumento que indica o nome da imagem a ser processada.
 * Uma nova imagem será armazenada no disco com a identificação "min" e o 
 * nome desse arquivo é retornado pela função. 
 */
public class Min extends Filter implements Filterable{
    
    
    @Override
    public String filter(List<String> params) {
        
        this.openImage(params.get(0));
        this.setFilteredImageName("min");
        
        int maskWidth = Integer.parseInt(params.get(1));
        int maskHeight = Integer.parseInt(params.get(2));
        
        int edge = maskWidth / 2;
        int[][] newImage = new int[image.getWidth()][image.getHeight()];

        for(int i=edge; i<image.getWidth()-edge; i++){
            for(int j=edge; j<image.getHeight()-edge; j++){
               
               PriorityQueue<Integer> values = new PriorityQueue<>();
               int v = 0;
               for(int x=i-edge; x<=i+edge; x++){
                   for(int y=j-edge; y<=j+edge; y++){
                       
                       Pixel p = new Pixel(image.getRGB(x, y));
                       v = p.gray;
                       values.add(v);
                       
                   }
               }                           
               
               v = values.element();                   
               newImage[i][j] = v;
               
                
            }
        }     
        
        for(int i=edge; i<image.getWidth()-edge; i++){
            for(int j=edge; j<image.getHeight()-edge; j++){
               Pixel n = new Pixel(image.getRGB(i, j));
               int v = newImage[i][j];
               n.setRGB(v, v, v);
               image.setRGB(i, j, n.getComposedPixel());
            }
        }
        
        this.storeImage();
        return filteredImage;
    }
    
}
