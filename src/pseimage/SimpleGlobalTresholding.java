package pseimage;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A limiarização global simples torna a imagem binária escolhendo automaticamente
 * um limiar que irá dividir os pixels em dois grupos. Inicialmente o limiar 
 * é a intensidade média da imagem, então o limiar vai sendo modificado até que
 * a mudança nos grupos com a troca do limiar seja insignificante.
 * A função recebe um único argumento que indica o nome da imagem a ser processada.
 * Uma nova imagem será armazenada no disco com a identificação "limiarização_global"
 * e o nome desse arquivo é retornado pela função. 
 */
public class SimpleGlobalTresholding extends Filter implements Filterable {

    @Override
    public String filter(List<String> params) {
        try {
            this.openImage(params.get(0));
            this.setFilteredImageName("limiarização_global");
            
            int[] h = Filter.getHistogram(params.get(0));
            int treshold = Filter.getMean(h);
            int[] groups = new int[h.length];
            
            boolean done = false;
            while(!done){
                int m1 = 0;
                int g1 = 0;
                int m2 = 0;
                int g2 = 0;
                for(int i=0; i<h.length; i++){
                    if(i < treshold){
                        m1 += h[i]*i;
                        g1 += h[i];
                    } else{
                        m2 += h[i]*i;
                        g2 += h[i];
                    }
                }
                if(g1 != 0)
                    m1 = m1 / g1;
                if(g2 != 0)
                    m2 = m2 / g2;

                int newTreshold = (m1 + m2) / 2;
                int diff = Math.abs(newTreshold - treshold);
                if(diff < (newTreshold / 10)){
                    done = true;
                } else{
                    treshold = newTreshold;
                }
            }
            
            for(int i=0; i<image.getWidth(); i++){
                for(int j=0; j<image.getHeight(); j++){
                    Pixel n = new Pixel(image.getRGB(i, j));
                    int v = (n.gray > treshold) ? 255 : 0;
                    n.setRGB(v, v, v);
                    image.setRGB(i, j, n.getComposedPixel());
                }
            }
            
            this.storeImage();
            return filteredImage;
        } catch (IOException ex) {
            Logger.getLogger(SimpleGlobalTresholding.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
