package pseimage;

import java.util.List;

/**
 * O filtro de potência trabalha manipulando o contraste da imagem. Através da 
 * constante gama pode realizar transformações que realçam altas ou baixas intensidades
 * de maneiras diferentes.
 * A função recebe 3 argumentos, sendo o primeiro argumento o nome da imagem a 
 * ser processada, o segundo argumento uma constante C, e o terceiro argumento 
 * outra constante (gama).
 * Uma nova imagem será armazenada no disco com a identificação "potency" e o 
 * nome desse arquivo é retornado pela função.  
 */
public class Potency extends Filter implements Filterable{

    @Override
    public String filter(List<String> params) {
        
        this.openImage(params.get(0));
        this.setFilteredImageName("potency");
        
        int c = Integer.parseInt(params.get(1));
        double gama = Double.parseDouble(params.get(2));      
        
        for(int x=0; x<image.getWidth(); x++){
            for(int y=0; y<image.getHeight(); y++){
                int pixel = image.getRGB(x, y);
                Pixel p = new Pixel(pixel);
                double k = (double) p.gray;
                //System.out.println(k);
                int value = (int) (c * Math.pow(k, gama));
                value = Math.min(255, Math.max(0, value));
                p.setRGB(value, value, value);  
                image.setRGB(x, y, p.getComposedPixel());
            }
        }
        
        this.storeImage();
        return filteredImage;
    }
    
}
